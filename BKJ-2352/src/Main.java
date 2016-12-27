//¹ÝµµÃ¼
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int result = 0;
		Scanner n = new Scanner(System.in);
		int size = n.nextInt();
		int[] a = new int[size];
		int[] b = new int[size];
			
		for(int i=0;i<a.length;i++){
			a[i]=i+1;
		}

		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<b.length;i++){
			b[i]=sc.nextInt();
		}
		
		for(int i=0;i<a.length;i++){
			for(int j=0;j<b.length;j++){
				if((i==j) && ((a[i] == b[j] || (a[i] == b[j]+1) || (a[i] == b[j]-1)))){
					result++;
				}
			}
		}		
		System.out.println(result);
	}
}
