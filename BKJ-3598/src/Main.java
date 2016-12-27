import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int[] f = new int[3];
		int[] f_temp = new int[3];
		f_temp[0] = f[0] = sc.nextInt();
		f_temp[1] = f[1] = sc.nextInt();
		f_temp[2] = f[2] = sc.nextInt();
		ArrayList<Integer> count = new ArrayList<>();

		int position = 1;

		for (int i = 0; i < f.length; i++) {
			if (position + f[i] > h) {
				position = 1;
			} else {
				position += f[i];
				count.add(position);
			}
		}

		HashSet<Integer> result = new HashSet<>(count);
		System.out.println(result);
		System.out.println(result.size());
	}

	// 백트래킹으로 해결할 수 있겠다.
	public static ArrayList<Integer> floor(int h, int[] f, ArrayList<Integer> count) {
		int position = 1;

		for (int i = 0; i < f.length; i++) {
			if (position + f[i] > h) {
				position = 1;
			} else {
				position += f[i];
				count.add(position);
			}
		}
		return count;
	}
}