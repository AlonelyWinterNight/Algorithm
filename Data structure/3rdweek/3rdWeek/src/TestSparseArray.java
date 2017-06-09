import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestSparseArray {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File("input.txt"));
		int size, index, value;
		size = inFile.nextInt();// 배열의 크기를 읽음 . 파일 첫 줄.
		SparseArray sa = new SparseArray(size);
		while (inFile.hasNextInt()) {
			index = inFile.nextInt();
			value = inFile.nextInt();
			sa.set(index, value);//인덱스와 값을 읽어 연결리스트에 연결
		}
		sa.print();
		inFile.close();
	}
}
