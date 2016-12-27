import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		int[] oct = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++) {
			oct[i] = (int) temp.charAt(i) - 48;
		}
		int[][] digit = new int[oct.length][3];

		for (int i = 0; i < digit.length; i++) {
			for (int j = 2; j >= 0; j--) {
				digit[i][j] = oct[i] % 2;
				oct[i] = oct[i] / 2;
			}
		}

		for (int i = 0; i < digit.length; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 0 && j == 0 && digit[i][j] == 0) {
					continue;
				} else {
					System.out.print(digit[i][j]);
				}
			}
		}
	}
}

// // 친절한 버전
// import java.util.Scanner;
//
// public class Main {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// String temp = sc.nextLine();
// int[] oct = new int[temp.length()];
// for (int i = 0; i < temp.length(); i++) {
// oct[i] = (int) temp.charAt(i) - 48;
// }
// int[][] digit = new int[oct.length][3];
//
// for (int i = 0; i < digit.length; i++) {
// System.out.println("----"+oct[i]+"----");
// for (int j = 2; j >= 0; j--) {
// int n = oct[i] % 2;
// System.out.println("n : "+oct[i]+" % 2");
// digit[i][j] = n;
// System.out.println("나머지 : "+digit[i][j]);
// oct[i] = oct[i] / 2;
// System.out.println("중간몫 : "+oct[i]);
// }
// }
//
// for (int i = 0; i < digit.length; i++) {
// for (int j = 0; j < 3; j++) {
// if (i == 0 && j == 0 && digit[i][j] == 0) {
// System.out.print("");
// } else {
// System.out.print(digit[i][j]);
// }
// }
// System.out.println();
// }
// }
// }
