import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File("input.txt"));
		String lineString;
		double score;
		int numCourses = inFile.nextInt(); // 과목 수 읽음
		inFile.nextLine(); // 과목 수 읽은 후 나머지 라인 읽어서 버림

		List[] courses = new List[numCourses];

		int i = 0;
		while (inFile.hasNextLine()) {
			courses[i] = new List();
			lineString = inFile.nextLine(); // 점수 라인 전체를 읽음
			StringTokenizer line = new StringTokenizer(lineString);
			while (line.hasMoreTokens()) { // 토큰이 남아 있는 동안
				score = Double.parseDouble(line.nextToken()); // 토큰 획득
//				courses[i].insertLast(score); // 끝에 삽입
				courses[i].insertInSortedOrder(score); // 정렬 삽입
			}
			i += 1;
		}
		inFile.close();
		
		for(i=0; i<numCourses; i++){
			System.out.print("과목 "+(i+1)+" : ");
			courses[i].print();
			System.out.println();
		}
	}
}
