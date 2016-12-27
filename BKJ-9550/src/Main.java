import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i=0;i<T;i++){ // Tȸ�� �׽�Ʈ���̽���ŭ �ݺ�
			int children = 0; // ������ �� �ִ� �ֵ��� ��
			int N = sc.nextInt(); // ������ ���� �� : N��
			int K = sc.nextInt(); // �ֵ��� ���� ������ �� : K��
			int[] candy = new int[N]; // �� �׽�Ʈ���̽��� ���� ������ ������ �迭.
			for(int j=0;j<N;j++){ // N���� ������ŭ �ݺ�
				int temp = sc.nextInt(); // ���� ������ ����
				children += (temp/K);
			}
			System.out.println(children);
		}
	}
}


/*

�ֵ��� �� �������� ����.
3���� , 2����
������ ���� 4, 5, 7

���� ��ŭ�� �ֵ� ��

2, 2, 3 = 7��
 
 */