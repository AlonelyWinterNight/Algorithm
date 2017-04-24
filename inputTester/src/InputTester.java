import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class InputTester {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File("input.txt"));

		String tempString;
		double tempDouble;
		int tempInt;
 
		while (inFile.hasNext()) {
			if (inFile.hasNextInt()) {
				System.out.print("Integer is detected : ");
				tempInt = inFile.nextInt();
				System.out.println(tempInt);
			} else if (inFile.hasNextDouble()) {
				System.out.print("Double is detected : ");
				tempDouble = inFile.nextDouble();
				System.out.println(tempDouble);
			} else {
				System.out.print("String is detected : ");
				tempString = inFile.next();
				System.out.println(tempString);
			}
		}
		inFile.close();
	}
}