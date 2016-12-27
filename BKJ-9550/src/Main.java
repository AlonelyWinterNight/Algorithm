import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i=0;i<T;i++){ // T회의 테스트케이스만큼 반복
			int children = 0; // 참석할 수 있는 애들의 수
			int N = sc.nextInt(); // 사탕의 종류 수 : N개
			int K = sc.nextInt(); // 애들이 먹을 사탕의 수 : K개
			int[] candy = new int[N]; // 현 테스트케이스의 사탕 종류별 수량의 배열.
			for(int j=0;j<N;j++){ // N개의 종류만큼 반복
				int temp = sc.nextInt(); // 사탕 종류별 수량
				children += (temp/K);
			}
			System.out.println(children);
		}
	}
}


/*

애들은 단 한종류만 먹음.
3종류 , 2개씩
종류별 수량 4, 5, 7

나눈 몫만큼의 애들 수

2, 2, 3 = 7명
 
 */