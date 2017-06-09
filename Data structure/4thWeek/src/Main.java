import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File("input.txt"));
		String lineString;
		double score;
		int numCourses = inFile.nextInt(); // ���� �� ����
		inFile.nextLine(); // ���� �� ���� �� ������ ���� �о ����

		List[] courses = new List[numCourses];

		int i = 0;
		while (inFile.hasNextLine()) {
			courses[i] = new List();
			lineString = inFile.nextLine(); // ���� ���� ��ü�� ����
			StringTokenizer line = new StringTokenizer(lineString);
			while (line.hasMoreTokens()) { // ��ū�� ���� �ִ� ����
				score = Double.parseDouble(line.nextToken()); // ��ū ȹ��
//				courses[i].insertLast(score); // ���� ����
				courses[i].insertInSortedOrder(score); // ���� ����
			}
			i += 1;
		}
		inFile.close();
		
		for(i=0; i<numCourses; i++){
			System.out.print("���� "+(i+1)+" : ");
			courses[i].print();
			System.out.println();
		}
	}
}
