import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner inFile = null;
		try {
			inFile = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file: input.txt");
		}

		SortedLinkedList<Student> studentList = new SortedLinkedList<>();
		// inFile에서 학생 데이터 읽어 studentList에 저장

		getStudentData(inFile, studentList);
		System.out.print(studentList);
		inFile.close();
	}

	public static void getStudentData(Scanner inFile, SortedLinkedList<Student> studentList) {
		int studentNumber;
		String studentName;
		String courseName;
		int credits;
		String grade;
		Student student;
		Course course;

		String lineStr;
		String[] courseStr;

		while (inFile.hasNext()) {
			studentNumber = inFile.nextInt();
			studentName = inFile.next();
			inFile.nextLine(); // 학번, 학생 이름 읽고 나머지 라인을 읽고 버림
			SortedLinkedList<Course> courseList = new SortedLinkedList<>();
			courseList.clear();

			while (inFile.hasNextLine()) {
				lineStr = inFile.nextLine();
				if (!lineStr.isEmpty()) {
					courseStr = lineStr.split(" ");
					courseName = courseStr[0];
					credits = Integer.parseInt(courseStr[1]);
					grade = courseStr[2];
					course = new Course(courseName, credits, grade.charAt(0));
					courseList.insert(course);
				} else
					break;
			}

			student = new Student(studentNumber, studentName, courseList);
			studentList.insert(student);
		}
	}

}
