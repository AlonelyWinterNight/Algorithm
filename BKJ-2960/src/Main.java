//에라토스테네스의 체 : N보다 작거나 같은 소수를 찾는 알고리즘.
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		LinkedList<Integer> all = new LinkedList<Integer>();
		int[] seq = new int[n];
		
		for(int i=2;i<=n;i++){
			all.add(i);
		}
		
		int here = 0;
		while(all.isEmpty()==false){ //4. 모든 숫자가 지워지지 않았다면 아래 2~3을반복함.
			int p = all.getFirst(); // 2. 가장 작은 수 p를 갱신.
			for(int i=0;i<all.size();i++){
				if(all.get(i)%p==0){ // 3. 아직 지우지 않은 P의 배수를 크기 순서로 지움
					seq[here]=all.get(i); // 지우는 수를 seq에 추가.
					here++;
					all.remove(i); // 지우는 수를 완전히 지움.
				}
			}
		}
		System.out.println(seq[k-1]);
	}
}

//에라토스테네스의 체 : N보다 작거나 같은 소수를 찾는 알고리즘.
//아래는 출력이 상냥한 코드
//import java.util.Scanner;
//import java.util.LinkedList;
//
//public class Main {
//	public static void main(String[] args){
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		LinkedList<Integer> all = new LinkedList<Integer>();
//		int[] seq = new int[n];
//		
//		for(int i=2;i<=n;i++){
//			all.add(i);
//		}
//		System.out.println(all);
//		
//		int here = 0;
//		while(all.isEmpty()==false){ //4. 모든 숫자가 지워지지 않았다면 아래 2~3을반복함.
//			int p = all.getFirst(); // 2. 가장 작은 수 p를 갱신.
//			for(int i=0;i<all.size();i++){
//				if(all.get(i)%p==0){ // 3. 아직 지우지 않은 P의 배수를 크기 순서로 지움
//					seq[here]=all.get(i); // 지우는 수를 seq에 추가.
//					here++;
//					all.remove(i); // 지우는 수를 완전히 지움.
//				}
//				System.out.println("Result "+i+" : " + all);
//			}
//		}
//		for(int i=0;i<seq.length;i++){
//			System.out.print(seq[i]+" ");
//		}
//	}
//}
