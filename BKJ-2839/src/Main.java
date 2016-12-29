import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 배달해야하는 설탕의 무게 N 킬로그램
		int bag_3 = 0;
		int bag_5 = 0;

		while (N != 0 && N > 0) {
			if (N % 5 == 3 && N / 3 != 1) {
				bag_5++;
				N = N - 5;
			} else {
				bag_3++;
				N = N - 3;
			}
		}
		System.out.println(bag_3 + bag_5);
	}
}


////친절한 버전
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt(); // 배달해야하는 설탕의 무게 N 킬로그램
//		int bag_3 = 0;
//		int bag_5 = 0;
//
//		while (N != 0 && N > 0) {
//			if (N % 5 == 3 && N / 3 != 1) {
//				System.out.println("bag_5 added");
//				bag_5++;
//				N = N - 5;
//				System.out.println("Remained : " + N + " Kg");
//			} else {
//				System.out.println("bag_3 added");
//				bag_3++;
//				N = N - 3;
//				System.out.println("Remained : " + N + " Kg");
//			}
//		}
//		System.out.println("3Kg : " + bag_3 + " Packs");
//		System.out.println("5Kg : " + bag_5 + " Packs");
//		System.out.println("Total : " + (bag_3 + bag_5) + "Packs");
//
//	}
//
//}
