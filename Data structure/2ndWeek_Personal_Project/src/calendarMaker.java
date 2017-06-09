import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class calendarMaker {
	public static final int ROWSIZE = 6; // 달력에 표시할 week의 수(최대 6)
	public static final int COLSIZE = 7; // 달력 한 줄(each week)에 표시할 날짜의 수.

	public static void main(String[] args) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File("input.txt"));
		String[] std_Date = inFile.nextLine().split(" |\t|\n"); // 기준년월일,날짜
		Date flagDate = new Date(Integer.parseInt(std_Date[0]), Integer.parseInt(std_Date[1]), Integer.parseInt(std_Date[2]));

		String flagDay = std_Date[3]; // 기준일에 해당하는 '요일'.
		String[] DayList = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Firday", "Saturday" };
		int dayIndex = 0; // 기준 요일의 '지점(인덱스)'
		for (int i = 0; i < DayList.length; i++) {
			if (flagDay.equals(DayList[i])) {
				dayIndex = i;
			}
		}

		if(flagDate.getDay()==1){
			// 1일이라면 기준일의 시작점이 지정돼있으므로 그냥 넘어간다. ex)3월 1일 목요일 
		}else{
			for (int i = 0; i < flagDate.getDay(); i++) {
				if (dayIndex < 0) {
					dayIndex = 6; // Sun~Sat의 인덱스가 0~6 이므로.
				} else {
					dayIndex--; // 기준일로부터 해당 달 1일까지 돌아가면서 인덱스를 변경함.
				}
			} // flagDayIndex, 즉 기준일에 해당하는 1일의 인덱스(요일)를 찾아냄.
		}
		
		//달력을 계산하고 출력하는 부분
		while (inFile.hasNextLine()) {
			String[] temp = inFile.nextLine().split(" |\t|\n");
			Date newDate = new Date(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), 1);
			int dayIndex_changed = dayIndex;
			
			if (flagDate.compareTo(newDate) == 0) { // 현재 달력을 조회.
				printCalendar(flagDate, dayIndex);
			} else if (flagDate.compareTo(newDate) == 1) { // 미래 달력을 조회.
				//newDate의 data 변경을 방지하기 위해 clone한 객체를 계산에 사용.
				Date pastDate = flagDate.cloneDate(); // 기준년월을 clone함.
				Date currentDate = newDate.cloneDate(); // 현재년월을 clone함.
				dayIndex_changed = pastDate.advance(currentDate, dayIndex_changed, 0); //과거->현재로 증가시킴.
				printCalendar(newDate, dayIndex_changed); //위에서 얻은 정보를 바탕으로, newDate에 대한 달력 출력.
			} else { // 과거 달력을 조회.
				Date pastDate = newDate.cloneDate(); // 기준년월을 clone함.
				Date currentDate = flagDate.cloneDate(); // 현재년월을 clone함.
				dayIndex_changed = pastDate.advance(currentDate, dayIndex_changed, 1); //과거->현재로 증가시킴.
				printCalendar(newDate, dayIndex_changed); //위에서 얻은 정보를 바탕으로, newDate에 대한 달력 출력.
			}
		}
		inFile.close();
	}
	
	// 달력을 출력하는 함수.
	public static void printCalendar(Date newDate, int dayIndex) {
		int MAX_DAYS = newDate.calculateDays(); // 출력하고자 하는 해당 년월의 날짜 수를 계산한다.
		System.out.println(newDate.toString());
		System.out.println("---------------------------");
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");

		// 얻은 정보를 바탕으로 달력을 출력한다.
		int day_count = 1;
		for (int i = 0; i < ROWSIZE; i++) {
			if (i == 0) {
				for (int j = 0; j < COLSIZE; j++) {
					if (j < dayIndex) {
						System.out.print(String.format("%4s", " "));
					} else {
						if (day_count > MAX_DAYS) {
							break;
						} else {
							System.out.print(String.format("%4s",day_count +  " "));
							day_count++;
						}
					}
				}
				System.out.println();
			} else {
				for (int j = 0; j < COLSIZE; j++) {
					if (day_count > MAX_DAYS) {
						break;
					} else {
						System.out.print(String.format("%4s", day_count + " "));
						day_count++;
					}
				}
				System.out.println();
			}
		}
	}
}
