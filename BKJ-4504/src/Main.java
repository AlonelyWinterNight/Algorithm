// 2번째 풀이
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp = 9999;
		ArrayList<String> result = new ArrayList<String>();

		while (temp > 0 && temp < 10000) {
			StringBuilder str = new StringBuilder("");
			temp = sc.nextInt();
			if (temp == 0) {
				break;
			} else if (temp % n == 0) {
				str.append(temp + " is a multiple of " + n + ".");
				result.add(str.toString());
			} else {
				str.append(temp + " is NOT a multiple of " + n + ".");
				result.add(str.toString());
			}
		}
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}

// // 1번째 풀이
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		ArrayList<Integer> temp = new ArrayList<Integer>();
//		int temp_input = 9999;
//		while (temp_input != 0) {
//			temp_input = sc.nextInt();
//			if (temp_input > 0 && temp_input < 10000) {
//				temp.add(temp_input);
//			}
//		}
//		isMultiple(n, temp);
//	}
//
//	public static void isMultiple(int n, ArrayList<Integer> temp) {
//		for (int i = 0; i < temp.size(); i++) {
//			if (temp.get(i) == 0) {
//				break;
//			} else if (temp.get(i) % n == 0) {
//				System.out.println(temp.get(i) + " is a multiple of " + n + ".");
//			} else {
//				System.out.println(temp.get(i) + " is NOT a multiple of " + n + ".");
//			}
//		}
//	}
//}
