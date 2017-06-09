import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input1.txt"));
		int row = sc.nextInt();
		int col = sc.nextInt();
		SparseMatrix m1_Row = new SparseMatrix(row, col);
		SparseMatrix m1_Col = new SparseMatrix(col, row);

		while (sc.hasNextLine()) {
			row = sc.nextInt();
			col = sc.nextInt();
			int value = sc.nextInt();
			Node temp1 = new Node(row, col, value);
			m1_Row.insert(row, col, temp1);
			Node temp2 = new Node(col, row, value);
			m1_Col.insert(col, row, temp2);
		}
		System.out.println("input1.txt" + "\n------------");
		System.out.println("Sparse Matrix by Rows");
		m1_Row.printMatrix();
		System.out.println("Sparse Matrix by Columns");
		m1_Col.printMatrix();
		sc.close();

		sc = new Scanner(new File("input2.txt"));
		row = sc.nextInt();
		col = sc.nextInt();
		SparseMatrix m2_Row = new SparseMatrix(row, col);
		SparseMatrix m2_Col = new SparseMatrix(col, row);

		while (sc.hasNextLine()) {
			row = sc.nextInt();
			col = sc.nextInt();
			int value = 0;
			String tempValue = sc.next();
			if (tempValue.charAt(0) == '-') { // value가 음수인 경우.
				value = Integer.parseInt(tempValue);
			} else {
				value = Integer.parseInt(tempValue);
			}
			Node temp1 = new Node(row, col, value);
			m2_Row.insert(row, col, temp1);
			Node temp2 = new Node(col, row, value);
			m2_Col.insert(col, row, temp2);
		}
		System.out.println("input2.txt" + "\n------------");
		System.out.println("Sparse Matrix by Rows");
		m2_Row.printMatrix();
		System.out.println("Sparse Matrix by Columns");
		m2_Col.printMatrix();
		sc.close();

		System.out.println("Multiplication" + "\n------------");
		SparseMatrix dummy = new SparseMatrix(0, 0);
		System.out.println("Sparse Matrix by Rows");
		dummy.multiplyMatrix(m1_Row, m2_Row);
		System.out.println("Sparse Matrix by Columns");
		dummy.multiplyMatrix(m2_Col, m1_Col);
	}
}