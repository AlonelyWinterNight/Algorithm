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

	public Date cloneDate() { // 날짜를 복사(Deep copy) 하는 함수.
		return new Date(this.year, this.month, this.day);
	}

	public int getDay() { // private 변수 참조를 위해 만든 함수.
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

	public int compareTo(Date newDate) { // 달력 작성을 위해 연,월 까지만 비교한다.
		if (this.year == newDate.year && this.month == newDate.month) {
			return 0;
		} else if (this.year < newDate.year) {
			return 1; // 연도부터 비교하는 날짜가 과거
		} else if (this.year > newDate.year) {
			return -1; // 연도부터 비교하는 날짜가 과거
		} else {
			if (this.month < newDate.month) {
				return 1; // 비교하는 날짜가 미래
			} else {
				return -1;
			}
		}
	}

	public int advance(Date modiDate, int dayIndex, int timeCase) { // 그레고리력의 윤년
																	// 규칙에 따라 날짜
																	// 계산.
		if (timeCase != 1) {// 과거(timeCase 인자 값 1)를 조사하는게 아닌 경우.
			while (this.year != modiDate.year || this.month != modiDate.month) {
				// 연,월이 같아질때까지 기준점을 계산함.
				if (this.month == 2 && this.isLeapYear() == true) {// 윤년 2월.
					dayIndex += 29 % 7; // 요일 인덱스 변경.
					if (dayIndex > 6) {
						dayIndex -= 7;
					}
					this.month += 1;
					if (month > 12) {
						month = 1;
						year += 1;
					}
				} else if (this.month == 2 && this.isLeapYear() != true) { // 윤년X
					dayIndex += 28 % 7; // 요일 인덱스 변경.
					if (dayIndex > 6) {
						dayIndex -= 7;
					}
					this.month += 1;
					if (month > 12) {
						month = 1;
						year += 1;
					}
				} else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
					dayIndex += 30 % 7; // 요일 인덱스 변경.
					if (dayIndex > 6) {
						dayIndex -= 7;
					}
					this.month += 1;
					if (month > 12) {
						month = 1;
						year += 1;
					}
				} else { // 2월과 상기 월 제외한 나머지 달들.
					dayIndex += 31 % 7; // 요일 인덱스 변경.
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
		} else {// 과거는 방법을 달리 함.
			while (this.year != modiDate.year || this.month != modiDate.month) {
				// 연,월이 같아질때까지 기준점을 계산함.
				if (this.month == 2 && this.isLeapYear() == true) {// 윤년 2월.
					dayIndex -= 29 % 7; // 요일 인덱스 변경.
					if (dayIndex < 0) {
						dayIndex += 7;
					}
					this.month += 1;
					if (month > 12) {
						month = 1;
						year += 1;
					}
				} else if (this.month == 2 && this.isLeapYear() != true) { // 윤년X
					dayIndex -= 28 % 7; // 요일 인덱스 변경.
					if (dayIndex < 0) {
						dayIndex += 7;
					}
					this.month += 1;
					if (month > 12) {
						month = 1;
						year += 1;
					}
				} else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
					dayIndex -= 30 % 7; // 요일 인덱스 변경.
					if (dayIndex < 0) {
						dayIndex += 7;
					}
					this.month += 1;
					if (month > 12) {
						month = 1;
						year += 1;
					}
				} else { // 2월과 상기 월 제외한 나머지 달들.
					dayIndex -= 31 % 7; // 요일 인덱스 변경.
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

	public boolean isLeapYear() { // 윤년 여부를 검사하는 함수.
		if (this.year % 4 == 0 && this.year % 100 != 0 || this.year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int calculateDays() { // 그레고리력의 윤년 규칙에 따라 한 달의 날짜 수를 계산하는 함수.
		int MAX_DAYS = 0;
		if (this.month == 2 && this.isLeapYear() == true) {// 윤년 2월.
			MAX_DAYS = 29;
		} else if (this.month == 2 && this.isLeapYear() != true) { // 윤년 아닌 2월
			MAX_DAYS = 28;
		} else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
			MAX_DAYS = 30;
		} else { // 2월, 상기 월 제외한 달.
			MAX_DAYS = 31;
		}
		return MAX_DAYS;
	}

}
