public class Date {
	private int year;
	private int month;
	private int day;

	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public Date() {
		this(0, 0, 0);
	}

	public Date cloneDate() { // ��¥�� ����(Deep copy) �ϴ� �Լ�.
		return new Date(this.year, this.month, this.day);
	}

	public int getDay() { // private ���� ������ ���� ���� �Լ�.
		return this.day;
	}

	public String toString() {
		String month_toString = "";
		String[] months = { "Januaray", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		for (int i = 0; i < months.length; i++) {
			if (month - 1 == i) {
				month_toString = months[i];
			}
		}
		return String.format("%4s", "\t" + year + " " + month_toString);
	}

	public int compareTo(Date newDate) { // �޷� �ۼ��� ���� ��,�� ������ ���Ѵ�.
		if (this.year == newDate.year && this.month == newDate.month) {
			return 0;
		} else if (this.year < newDate.year) {
			return 1; // �������� ���ϴ� ��¥�� ����
		} else if (this.year > newDate.year) {
			return -1; // �������� ���ϴ� ��¥�� ����
		} else {
			if (this.month < newDate.month) {
				return 1; // ���ϴ� ��¥�� �̷�
			} else {
				return -1;
			}
		}
	}

	public int advance(Date modiDate, int dayIndex, int timeCase) { // �׷������� ����
																	// ��Ģ�� ���� ��¥
																	// ���.
		if (timeCase != 1) {// ����(timeCase ���� �� 1)�� �����ϴ°� �ƴ� ���.
			while (this.year != modiDate.year || this.month != modiDate.month) {
				// ��,���� ������������ �������� �����.
				if (this.month == 2 && this.isLeapYear() == true) {// ���� 2��.
					dayIndex += 29 % 7; // ���� �ε��� ����.
					if (dayIndex > 6) {
						dayIndex -= 7;
					}
					this.month += 1;
					if (month > 12) {
						month = 1;
						year += 1;
					}
				} else if (this.month == 2 && this.isLeapYear() != true) { // ����X
					dayIndex += 28 % 7; // ���� �ε��� ����.
					if (dayIndex > 6) {
						dayIndex -= 7;
					}
					this.month += 1;
					if (month > 12) {
						month = 1;
						year += 1;
					}
				} else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
					dayIndex += 30 % 7; // ���� �ε��� ����.
					if (dayIndex > 6) {
						dayIndex -= 7;
					}
					this.month += 1;
					if (month > 12) {
						month = 1;
						year += 1;
					}
				} else { // 2���� ��� �� ������ ������ �޵�.
					dayIndex += 31 % 7; // ���� �ε��� ����.
					if (dayIndex > 6) {
						dayIndex -= 7;
					}
					this.month += 1;
					if (month > 12) {
						month = 1;
						year += 1;
					}
				}
			}
		} else {// ���Ŵ� ����� �޸� ��.
			while (this.year != modiDate.year || this.month != modiDate.month) {
				// ��,���� ������������ �������� �����.
				if (this.month == 2 && this.isLeapYear() == true) {// ���� 2��.
					dayIndex -= 29 % 7; // ���� �ε��� ����.
					if (dayIndex < 0) {
						dayIndex += 7;
					}
					this.month += 1;
					if (month > 12) {
						month = 1;
						year += 1;
					}
				} else if (this.month == 2 && this.isLeapYear() != true) { // ����X
					dayIndex -= 28 % 7; // ���� �ε��� ����.
					if (dayIndex < 0) {
						dayIndex += 7;
					}
					this.month += 1;
					if (month > 12) {
						month = 1;
						year += 1;
					}
				} else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
					dayIndex -= 30 % 7; // ���� �ε��� ����.
					if (dayIndex < 0) {
						dayIndex += 7;
					}
					this.month += 1;
					if (month > 12) {
						month = 1;
						year += 1;
					}
				} else { // 2���� ��� �� ������ ������ �޵�.
					dayIndex -= 31 % 7; // ���� �ε��� ����.
					if (dayIndex < 0) {
						dayIndex += 7;
					}
					this.month += 1;
					if (month > 12) {
						month = 1;
						year += 1;
					}
				}
			}
		}
		return dayIndex;
	}

	public boolean isLeapYear() { // ���� ���θ� �˻��ϴ� �Լ�.
		if (this.year % 4 == 0 && this.year % 100 != 0 || this.year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int calculateDays() { // �׷������� ���� ��Ģ�� ���� �� ���� ��¥ ���� ����ϴ� �Լ�.
		int MAX_DAYS = 0;
		if (this.month == 2 && this.isLeapYear() == true) {// ���� 2��.
			MAX_DAYS = 29;
		} else if (this.month == 2 && this.isLeapYear() != true) { // ���� �ƴ� 2��
			MAX_DAYS = 28;
		} else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
			MAX_DAYS = 30;
		} else { // 2��, ��� �� ������ ��.
			MAX_DAYS = 31;
		}
		return MAX_DAYS;
	}

}
