//�����佺�׳׽��� ü : N���� �۰ų� ���� �Ҽ��� ã�� �˰���.
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
		while(all.isEmpty()==false){ //4. ��� ���ڰ� �������� �ʾҴٸ� �Ʒ� 2~3���ݺ���.
			int p = all.getFirst(); // 2. ���� ���� �� p�� ����.
			for(int i=0;i<all.size();i++){
				if(all.get(i)%p==0){ // 3. ���� ������ ���� P�� ����� ũ�� ������ ����
					seq[here]=all.get(i); // ����� ���� seq�� �߰�.
					here++;
					all.remove(i); // ����� ���� ������ ����.
				}
			}
		}
		System.out.println(seq[k-1]);
	}
}

//�����佺�׳׽��� ü : N���� �۰ų� ���� �Ҽ��� ã�� �˰���.
//�Ʒ��� ����� ����� �ڵ�
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
//		while(all.isEmpty()==false){ //4. ��� ���ڰ� �������� �ʾҴٸ� �Ʒ� 2~3���ݺ���.
//			int p = all.getFirst(); // 2. ���� ���� �� p�� ����.
//			for(int i=0;i<all.size();i++){
//				if(all.get(i)%p==0){ // 3. ���� ������ ���� P�� ����� ũ�� ������ ����
//					seq[here]=all.get(i); // ����� ���� seq�� �߰�.
//					here++;
//					all.remove(i); // ����� ���� ������ ����.
//				}
//				System.out.println("Result "+i+" : " + all);
//			}
//		}
//		for(int i=0;i<seq.length;i++){
//			System.out.print(seq[i]+" ");
//		}
//	}
//}
