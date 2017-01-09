import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());

		if (N >= 1 && N <= 100) {
			int[] HH = new int[N];
			int[] MM = new int[N];
			int[] DD = new int[N];

			for (int i = 0; i < N; i++) {
				String str = sc.nextLine();
				String[] arr = str.split(":| ");
				HH[i] = Integer.parseInt(arr[0]);
				MM[i] = Integer.parseInt(arr[1]);
				DD[i] = Integer.parseInt(arr[2]);
			}
			int totalFee = 0;
			for (int i = 0; i < N; i++) {
				totalFee += CalFee(HH[i], MM[i], DD[i]);
			}
			System.out.println(totalFee);
		}
	}

	public static int CalFee(int HH, int MM, int DD) {
		int fee = 0;
		while(DD-- > 0){
			if (HH >= 7 && HH <= 18) {
				fee += 10;
			} else {
				fee += 5; 
			}

			if (MM + 1 == 60) { // 통화 시작시간에서 통화시간을 점차 더한 값이 60이 되면
				MM = 0; // 0으로 리셋.
				if (HH + 1 == 24) {
					HH = 0;
				} else {
					HH += 1; // 시간은 1 올림.
				}
			} else {
				MM += 1; // 1분씩 증가.
			}
		}
		return fee;
	}
}

/*
 * Test case : 1st - 150 correctly // 2nd - 225 correctly 
1 
18:55 25

1
06:55 25
 */
