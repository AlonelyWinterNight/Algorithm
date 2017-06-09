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

	public String toString() {
		return year + "/" + month + "/" + day + " ";
	}

	public int compareTo(Date newDate) {
		if (this.year < newDate.year) {
			return 1;
		} else if (this.year > newDate.year) {
			return -1;
		} else {
			if (this.month < newDate.month) {
				return 1;
			} else if (this.year > newDate.year) {
				return -1;
			} else {
				if (this.day == newDate.day) {
					return 0;
				} else if (this.day > newDate.day) {
					return -1;
				} else
					return 1;
			}
		}

	}

	public void advance() { // �׷������� ���� ��Ģ�� ���� ��¥ ���.
		this.day += 1; // ������ ��� 2���� 29�� , ������ �ƴϸ� 2���� 28��.
		if (this.month == 2 && this.isLeapYear() == true) {// ���� 2��.
			if (this.day > 29) {
				day = 1;
				month += 1;
				if (month > 12) {
					month = 1;
					year += 1;
				}
			}
		} else if (this.month == 2 && this.isLeapYear() != true) { // ���� �ƴ� 2��
			if (this.day > 28) {
				day = 1;
				month += 1;
				if (month > 12) {
					month = 1;
					year += 1;
				}
			}
		} else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
			if (this.day > 30) {
				day = 1;
				month += 1;
				if (month > 12) {
					month = 1;
					year += 1;
				}
			}
		} else { // 2��, ��� �� ������ ��.
			if (this.day > 31) {
				day = 1;
				month += 1;
				if (month > 12) {
					month = 1;
					year += 1;
				}
			}
		}
	}

	public boolean isLeapYear() {
		if (this.year % 4 == 0 && this.year % 100 != 0 || this.year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
