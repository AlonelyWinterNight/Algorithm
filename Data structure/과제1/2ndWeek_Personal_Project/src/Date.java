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
		return year + " " + month;
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

	public int calculateDays() { // 그레고리력의 윤년 규칙에 따라 날짜 계산.
		int MAX_DAYS = 0;
		if (this.month == 2 && this.isLeapYear() == true) {// 윤년 2월.
			MAX_DAYS = 29;
		} else if (this.month == 2 && this.isLeapYear() != true) { // 윤년 아닌 2월
			MAX_DAYS = 28;
		} else if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8
				|| this.month == 10 || this.month == 12) {
			MAX_DAYS = 31;
		} else if (this.month != 2) { // 2월, 상기 월 제외한 달.
			MAX_DAYS = 30;
		}
		return MAX_DAYS;
	}

	public boolean isLeapYear() {
		if (this.year % 4 == 0 && this.year % 100 != 0 || this.year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
