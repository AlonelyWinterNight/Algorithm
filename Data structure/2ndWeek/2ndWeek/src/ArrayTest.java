
public class ArrayTest {

	// ---P2�� ��� ����
	public static final int SIZE = 12;
	public static final int ROWSIZE = 4;
	public static final int COLSIZE = 3;

	public static void main(String[] args) {
		// [i,j] = [i-1,j] + [i-1,j-1]; //��, �ٷ� �� �� ���� + �� ���� ���� ����
		// ---P1
		int[][] pascal = new int[10][];
		/*
		 * pascal[0] = new int[0]; pascal[1] = new int[2]; pascal[2] = new
		 * int[3]; ... ...
		 */
		for (int i = 0; i < 10; i++) {
			pascal[i] = new int[i + 1];
		}

		for (int i = 0; i < pascal.length; i++) {
			for (int j = 0; j < pascal[i].length; j++) {
				if (j == 0) {
					pascal[i][j] = 1;
				} else if (j < pascal[i].length - 1) {
					pascal[i][j] = pascal[i - 1][j] + pascal[i - 1][j - 1];
				} else {
					pascal[i][j] = pascal[i - 1][j - 1] + 0;
				}
			}
		}

		for (int i = 0; i < pascal.length; i++) {
			for (int j = 0; j < pascal[i].length; j++) {
				System.out.print(pascal[i][j] + "\t");
			}
			System.out.println();
		}

		// ---P2
		int[] array = { 89, 88, 96, 23, 77, 12, 36, 28, 93, 83, 25, 30 };
		int[][] twoDim = new int[ROWSIZE][COLSIZE];
		int[] Max = new int[ROWSIZE];

		System.out.println("\n");
		makeTwoDimension(array, twoDim);
		printOneDimensionArray(array);
		printTwoDimension(twoDim);
		findMax(twoDim, Max);
		printTwoDimensionWithMax(twoDim, Max);
	}

	// ---P2
	// 1���� �迭�� 2���� �迭�� ��ȯ
	public static void makeTwoDimension(int a[], int[][] twoDimensionArray) {
		int k = 0;
		for (int i = 0; i < ROWSIZE; i++) {
			for (int j = 0; j < COLSIZE; j++) {
				twoDimensionArray[i][j] = a[k];
				k++;
			}
		}
	}

	// 1���� �迭 ���
	public static void printOneDimensionArray(int[] a) {
		System.out.println("Onew Dimension Array");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");
	}

	// 2���� �迭 ���
	public static void printTwoDimension(int[][] twoDimensionArray) {
		System.out.println("Two Dimension Array");
		for (int i = 0; i < ROWSIZE; i++) {
			for (int j = 0; j < COLSIZE; j++) {
				System.out.print(twoDimensionArray[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// 2���� �迭�� �� ���� �ִ밪�� ���Ͽ� 1���� �迭 maxArray�� ����
	public static void findMax(int[][] twoDimensionArray, int[] maxArray) {
		int max = 0;
		for (int i = 0; i < ROWSIZE; i++) {
			max = twoDimensionArray[i][0];
			for (int j = 0; j < COLSIZE; j++) {
				if (twoDimensionArray[i][j] > max) {
					max = twoDimensionArray[i][j];
				}
			}
			maxArray[i] = max;
		}
	}

	// 2���� �迭�� ��� ���� �ִ밪�� ���
	public static void printTwoDimensionWithMax(int[][] twoDimensionArray, int[] maxArray) {
		System.out.println("Print Two Dimension With Max");
		for (int i = 0; i < ROWSIZE; i++) {
			for (int j = 0; j < COLSIZE; j++) {
				System.out.print(twoDimensionArray[i][j] + " ");
			}
			System.out.print(maxArray[i]);
			System.out.println();
		}
		System.out.println();
	}
}
