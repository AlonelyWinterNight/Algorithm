import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * ----------------- ---- p1
		 */
		Scanner inFile = new Scanner(new File("input.txt"));
		SortedArrayList<Integer> intList = new SortedArrayList<Integer>();
		SortedArrayList<Double> doubleList = new SortedArrayList<Double>();
		SortedArrayList<String> stringList = new SortedArrayList<String>();

		String tempString;
		double tempDouble;
		int tempInt;

		while (inFile.hasNext()) {
			if (inFile.hasNextInt()) {
				tempInt = inFile.nextInt();
				intList.insert(tempInt);
			} else if (inFile.hasNextDouble()) {
				tempDouble = inFile.nextDouble();
				doubleList.insert(tempDouble);
			} else {
				tempString = inFile.next();
				stringList.insert(tempString);
			}
		}
		inFile.close();

		System.out.print("Integer data : ");
		intList.print();
		System.out.print("Double data : ");
		doubleList.print();
		System.out.print("String data : ");
		stringList.print();

		/*
		 * ----------------- ---- p2
		 */
		SortedArrayList<Course> courseList = new SortedArrayList<Course>();
		Course course;
		String name = null;
		int credit = 0;
		char grade = 0;
		Scanner input = new Scanner(new File("course.txt"));
		while (input.hasNext()) {
			name = input.next();
			credit = input.nextInt();
			grade = input.next().charAt(0);
			course = new Course(name, credit, grade);
			courseList.insert(course);
		}
		input.close();
		System.out.println("\nCourse data"+"\n-----------");
		courseList.println();
		
		// Student part
		
		SortedArrayList<Student> studentList = new SortedArrayList<Student>();
		Student student;
		int number; // 학번
		double score; // 점수 (100.0 만점)
		input = new Scanner(new File("student.txt"));
		while(input.hasNext()){
			number = input.nextInt();
			name = input.next();
			score = input.nextDouble();
			student = new Student(number,name,score);
			studentList.insert(student);
		}
		System.out.println("\nStudent data"+"\n-----------");
		studentList.println();
		
		input = new Scanner(System.in);
		System.out.println("\nEnter a command: i(nsert), r(emove), s(earch), p(rint), q(uit)");
		System.out.print("> ");
		String command = input.next();
		
		while (true) {
			if (command.equals("i")) {
				student = new Student(input.nextInt(), input.next(), input.nextDouble());
				studentList.insert(student);
			} else if (command.equals("r")) {
				student = new Student(input.nextInt(), input.next(), input.nextDouble());
				try {
					if (studentList.remove(student))
						System.out.println("Student removed.");
					else
						System.out.println("No such student");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (command.equals("s")) {
				student = new Student(input.nextInt(), input.next(), input.nextDouble());
				try {
					if (studentList.search(student))
						System.out.println("Student is in the list.");
					else
						System.out.println("No such student!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (command.equals("p"))
				studentList.println();
			else if (command.equals("q")) {
				System.out.println("Commands Terminated!");
				break;
			}
			System.out.print("> ");
			command = input.next();
		}
	}
}
