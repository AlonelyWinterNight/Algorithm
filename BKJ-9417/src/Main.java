import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int testcase = 0; testcase < N; testcase++) {
			String[] str = sc.nextLine().split(" ");
			int[] M = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				M[i] = Integer.parseInt(str[i]);
			}

			int max = 1;
			for (int i = 0; i < M.length; i++) {
				for (int j = 0; j < M.length; j++) {
					if(i==j){
						continue;
					}else{
						int temp = findGCD(M[i], M[j]);
//						System.out.println(M[i]+" and "+M[j]+" : "+temp);
						if (max < temp) {
							max = temp;
						}						
					}
				}
			}
			result.add(max);
		}
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i));			
		}
	}

	public static int findGCD(int a, int b) {
		int GCD = 0;
		if (a % b == 0) { // a<=b
			GCD = b;
		} else if (b % a == 0) { // a>=b
			GCD = a;
		} else {
			if (a > b) {
				while (a % b != 0) {
					GCD = a % b;
					a = b;
					b = GCD;
				}
			} else {
				while (b % a != 0) {
					GCD = b % a;
					b = a;
					a = GCD;
				}
			}
		}
		return GCD;
	}
}
