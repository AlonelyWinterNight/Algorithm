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

	public void advance() { // 그레고리력의 윤년 규칙에 따라 날짜 계산.
		this.day += 1; // 윤년인 경우 2월이 29일 , 윤년이 아니면 2월은 28일.
		if (this.month == 2 && this.isLeapYear() == true) {// 윤년 2월.
			if (this.day > 29) {
				day = 1;
				month += 1;
				if (month > 12) {
					month = 1;
					year += 1;
				}
			}
		} else if (this.month == 2 && this.isLeapYear() != true) { // 윤년 아닌 2월
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
		} else { // 2월, 상기 월 제외한 달.
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
