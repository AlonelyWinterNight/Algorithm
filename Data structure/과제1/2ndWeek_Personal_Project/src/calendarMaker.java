import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*	2017-03-21 
 *  달력을 만드는 프로그램. */

public class calendarMaker {
	public static final int MAX_ROWSIZE = 6;
	public static final int COLSIZE = 7;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File("sample.txt"));
		String line;
		String sign;

		String[] std_Date = inFile.nextLine().split(" |\t|\n"); // 기준년월일,날짜
		Date flagDate = new Date(Integer.parseInt(std_Date[0]), Integer.parseInt(std_Date[1]),
				Integer.parseInt(std_Date[2]));
		String flagDay = std_Date[3]; // 기준일에 해당하는 요일.

		while (inFile.hasNextLine()) {
			String[] temp = inFile.nextLine().split(" |\t|\n");
			Date a = new Date(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
//
//			if (a.compareTo(flagDate) == 0) {
//				sign = "=";
//			} else if (a.compareTo(flagDate) == 1) {
//				sign = "<";
//			} else {
//				sign = ">";
//			}
		}
		inFile.close();
	}

	// 2차원 배열 출력
	public static void printTwoDimension(Date flag) {
		int MAX_DAYS = 0;
		System.out.println(flag.toString());
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		flag.calculateDays();

		for (int i = 1; i < MAX_DAYS;) {
			for (int j = 0; j < COLSIZE; j++) {
				System.out.print(i);
				i++;
			}
			System.out.println();
		}
		System.out.println();
	}
}
