import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // Test caseÀÇ È½¼ö
		
		int[] a = new int[T];
		int[] b = new int[T];
		int[] c = new int[T];
		
		for(int i=0;i<T;i++){
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			c[i] = sc.nextInt();
		}
		
		for(int j=0;j<T;j++){
			System.out.println("Scenario #"+(j+1)+":");
			if((a[j]*a[j])+(b[j]*b[j])==(c[j]*c[j]) || (a[j]*a[j])==(b[j]*b[j])+(c[j]*c[j])|| (b[j]*b[j])==(a[j]*a[j])+(c[j]*c[j])){
				System.out.println("yes");
			}
			else{
				System.out.println("no");
			}
			System.out.print("\n");
		}
	}
}
