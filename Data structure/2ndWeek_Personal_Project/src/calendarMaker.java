import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class calendarMaker {
	public static final int ROWSIZE = 6; // �޷¿� ǥ���� week�� ��(�ִ� 6)
	public static final int COLSIZE = 7; // �޷� �� ��(each week)�� ǥ���� ��¥�� ��.

	public static void main(String[] args) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File("input.txt"));
		String[] std_Date = inFile.nextLine().split(" |\t|\n"); // ���س����,��¥
		Date flagDate = new Date(Integer.parseInt(std_Date[0]), Integer.parseInt(std_Date[1]), Integer.parseInt(std_Date[2]));

		String flagDay = std_Date[3]; // �����Ͽ� �ش��ϴ� '����'.
		String[] DayList = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Firday", "Saturday" };
		int dayIndex = 0; // ���� ������ '����(�ε���)'
		for (int i = 0; i < DayList.length; i++) {
			if (flagDay.equals(DayList[i])) {
				dayIndex = i;
			}
		}

		if(flagDate.getDay()==1){
			// 1���̶�� �������� �������� �����������Ƿ� �׳� �Ѿ��. ex)3�� 1�� ����� 
		}else{
			for (int i = 0; i < flagDate.getDay(); i++) {
				if (dayIndex < 0) {
					dayIndex = 6; // Sun~Sat�� �ε����� 0~6 �̹Ƿ�.
				} else {
					dayIndex--; // �����Ϸκ��� �ش� �� 1�ϱ��� ���ư��鼭 �ε����� ������.
				}
			} // flagDayIndex, �� �����Ͽ� �ش��ϴ� 1���� �ε���(����)�� ã�Ƴ�.
		}
		
		//�޷��� ����ϰ� ����ϴ� �κ�
		while (inFile.hasNextLine()) {
			String[] temp = inFile.nextLine().split(" |\t|\n");
			Date newDate = new Date(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), 1);
			int dayIndex_changed = dayIndex;
			
			if (flagDate.compareTo(newDate) == 0) { // ���� �޷��� ��ȸ.
				printCalendar(flagDate, dayIndex);
			} else if (flagDate.compareTo(newDate) == 1) { // �̷� �޷��� ��ȸ.
				//newDate�� data ������ �����ϱ� ���� clone�� ��ü�� ��꿡 ���.
				Date pastDate = flagDate.cloneDate(); // ���س���� clone��.
				Date currentDate = newDate.cloneDate(); // �������� clone��.
				dayIndex_changed = pastDate.advance(currentDate, dayIndex_changed, 0); //����->����� ������Ŵ.
				printCalendar(newDate, dayIndex_changed); //������ ���� ������ ��������, newDate�� ���� �޷� ���.
			} else { // ���� �޷��� ��ȸ.
				Date pastDate = newDate.cloneDate(); // ���س���� clone��.
				Date currentDate = flagDate.cloneDate(); // �������� clone��.
				dayIndex_changed = pastDate.advance(currentDate, dayIndex_changed, 1); //����->����� ������Ŵ.
				printCalendar(newDate, dayIndex_changed); //������ ���� ������ ��������, newDate�� ���� �޷� ���.
			}
		}
		inFile.close();
	}
	
	// �޷��� ����ϴ� �Լ�.
	public static void printCalendar(Date newDate, int dayIndex) {
		int MAX_DAYS = newDate.calculateDays(); // ����ϰ��� �ϴ� �ش� ����� ��¥ ���� ����Ѵ�.
		System.out.println(newDate.toString());
		System.out.println("---------------------------");
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");

		// ���� ������ �������� �޷��� ����Ѵ�.
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
