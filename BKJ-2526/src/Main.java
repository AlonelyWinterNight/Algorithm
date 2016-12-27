import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		HashMap hash = new HashMap(); // 반복되는 사이클을 담을 hash.
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); // 처음 출력하는 숫자는 N
		int p = s.nextInt(); // 두번째 이후 출력하는 숫자 P = MOD(N*N,P)
		int result = n;
		
		for(int i = 1;;i++)
		{
			if(hash.containsValue(2)) {
				break;
			}
			result = result*n%p;
			if(hash.containsKey(result)!=true) {
				hash.put(result, 1); // hash에 없으면 추가하고 count=1;
			}
			else {
				hash.put(result, (int) hash.get(result) + 1); //hash에 있으면 count++;
			}			
		}
		
		System.out.println(hash.size());
	}

}
