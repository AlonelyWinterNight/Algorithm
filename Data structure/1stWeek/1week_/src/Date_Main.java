import java.util.Scanner;
import java.io.*;

public class Date_Main {

	public static void main(String[] args) throws FileNotFoundException {
		//---------------문제 1
		Scanner inFile = new Scanner(new File("input1.txt"));
		PrintWriter outFile = new PrintWriter("output1.txt");
		String line;
		String sign;

		while (inFile.hasNextLine()) {
			line = inFile.nextLine();
			String[] temp;
			temp = line.split(" |\t|\n"); // " " 또는 Tab 구분자로 잘라넣음.
			
			Date a = new Date(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
			Date b = new Date(Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]));

			if (a.compareTo(b) == 0) {
				sign = "=";
			}
			else if(a.compareTo(b) == 1){
				sign = "<";
			}
			else{
				sign = ">";
			}
			
			line = a.toString() +"\t"+ sign +"\t"+ b.toString();
			outFile.println(line);
		}
		inFile.close();
		outFile.close();
		
		//---------------문제 2
		inFile = new Scanner(new File("input2.txt"));
		outFile = new PrintWriter("output2.txt");
		
		while(inFile.hasNextLine()){
			line = inFile.nextLine();
			
			String[] temp;
			temp = line.split(" |\t|\n");
			
			Date flag = new Date(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),Integer.parseInt(temp[2]));
			Date origin = new Date(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),Integer.parseInt(temp[2]));
			
			int count = Integer.parseInt(temp[3]);
			
			for(int i=0; i<count; i++){
				flag.advance();
			}
			
			line = origin.toString() + count + " 일 후  ==> " + flag.toString();
			outFile.println(line);
		}
		inFile.close();
		outFile.close();
	}
}
