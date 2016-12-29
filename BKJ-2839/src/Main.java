import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 배달해야하는 설탕의 무게 N 킬로그램
		int bag_3 = 0;
		int bag_5 = 0;
		if (N >= 3 && N <= 5000) {
			while (N != 0 && N > 0) {
				if (N % 5 == 3 && N % 3 != 0 || N%5 == 0) {
					bag_5++;
					N = N - 5;
				} else {
					if (N - 3 < 0) {
						bag_5 = 0; bag_3 = -1;
						break;
					} else {
						bag_3++;
						N = N - 3;
					}
				}
			}
			System.out.println(bag_3 + bag_5);
		} else {
			System.out.println("-1");
		}
	}
}