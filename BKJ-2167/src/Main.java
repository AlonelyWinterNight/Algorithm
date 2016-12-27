import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 1<=N
		int M = sc.nextInt();// M<=300
		int[][] arr = new int[N][M];

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				arr[n][m] = sc.nextInt();
			}
		}

		int K = sc.nextInt(); // 합을 구할 부분의 개수 (1<=K<=10,000)
		int[] result = new int[K];
		int i, j, x, y = 0; // i<=x , j<=y

		for (int n = 0; n < K; n++) {
			i = sc.nextInt() - 1;
			j = sc.nextInt() - 1;
			x = sc.nextInt() - 1;
			y = sc.nextInt() - 1;
			if (i == x && j == y) {
				result[n] = arr[i][j];
			} else {
				for (int row = i; row <= x; row++) {
					for (int col = j; col <= y; col++) {
						result[n] = result[n] + arr[row][col];
					}
				}
			}
		}

		for (int n = 0; n < result.length; n++) {
			System.out.println(result[n]);
		}
	}
}
