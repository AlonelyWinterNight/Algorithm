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
		System.out.println("Total Fee for the Call which took at "+HH+":"+MM+" "+DD);
		int fee = 0;
		for (int min = 0; min < DD; min++) {
			if (MM + 1 == 60) { // 통화 시작시간에서 통화시간을 점차 더한 값이 60이 되면
				MM = MM + 1 - 60; // 0으로 리셋.
				if (HH + 1 == 24) {
					HH = HH + 1 - 24;
				} else {
					HH = HH + 1; // 시간은 1 올림.
				}
			} else {
				MM = MM + 1; // 1분씩 증가.
			}

			if ((HH >= 07 && HH < 19 && MM > 01) || (HH == 19 && MM == 00) || (HH == 07 && MM == 00)) {
				fee += 10;
				System.out.println("Fee : " + fee + " until " + HH + ":" + MM + " (" + (min + 1) + "min)");
			} else if ((HH <= 07) || (HH >= 19 && HH <= 24) || (HH == 19 && MM == 00) || (HH == 07 && MM == 00)) {
				// else if (HH >= 19 || (HH < 07 && MM < 60) || (HH == 07 && MM
				// == 00)) {
				fee += 5;
				System.out.println("Fee : " + fee + " until " + HH + ":" + MM + " (" + (min + 1) + "min)");
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

/*
 * 
 * if (Integer.parseInt(arr[0]) <= 9) { HH[i][0] = 0; HH[i][1] =
 * Integer.parseInt(arr[0]); } else { String[] temp = arr[0].split(""); for (int
 * temp_i = 0; temp_i < temp.length; temp_i++) { HH[i][temp_i] =
 * Integer.parseInt(temp[temp_i]); } }
 * 
 * if (Integer.parseInt(arr[1]) <= 9) { MM[i][0] = 0; MM[i][1] =
 * Integer.parseInt(arr[1]); } else { String[] temp = arr[1].split(""); for (int
 * temp_i = 0; temp_i < temp.length; temp_i++) { MM[i][temp_i] =
 * Integer.parseInt(temp[temp_i]); } } DD[i] = Integer.parseInt(arr[2]);
 */