import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int k = sc.nextInt(); // 1 <= k <= 14
			int n = sc.nextInt(); // 1 <= n <= 14
			int[][] residents = new int[k+1][n]; // 0층 1호부터 있고 , 0층 i호에는 i명이 산다.
			for (int i = 0; i < residents.length; i++) {
				for (int j = 0; j < n; j++) {
					if (i == 0) {
						residents[i][j] = j + 1;
					}else{
						for(int t = 0; t<j+1 ; t++){
							residents[i][j] += residents[i-1][t];
						}
					}
				}
			}
			System.out.println(residents[k][n-1]);
		}
	}
}
