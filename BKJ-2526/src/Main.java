import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		HashMap hash = new HashMap(); // �ݺ��Ǵ� ����Ŭ�� ���� hash.
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); // ó�� ����ϴ� ���ڴ� N
		int p = s.nextInt(); // �ι�° ���� ����ϴ� ���� P = MOD(N*N,P)
		int result = n;
		
		for(int i = 1;;i++)
		{
			if(hash.containsValue(2)) {
				break;
			}
			result = result*n%p;
			if(hash.containsKey(result)!=true) {
				hash.put(result, 1); // hash�� ������ �߰��ϰ� count=1;
			}
			else {
				hash.put(result, (int) hash.get(result) + 1); //hash�� ������ count++;
			}			
		}
		
		System.out.println(hash.size());
	}

}
