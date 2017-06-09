import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestSparseArray {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File("input.txt"));
		int size, index, value;
		size = inFile.nextInt();// �迭�� ũ�⸦ ���� . ���� ù ��.
		SparseArray sa = new SparseArray(size);
		while (inFile.hasNextInt()) {
			index = inFile.nextInt();
			value = inFile.nextInt();
			sa.set(index, value);//�ε����� ���� �о� ���Ḯ��Ʈ�� ����
		}
		sa.print();
		inFile.close();
	}
}
