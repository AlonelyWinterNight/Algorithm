import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();

		String[] temp_a = a.split("");
		String[] temp_b = b.split("");

		Integer[] parse_a = new Integer[temp_a.length];
		for (int i = 0; i < temp_a.length; i++) {
			parse_a[i] = Integer.parseInt(temp_a[i]);
		}

		Integer[] parse_b = new Integer[temp_b.length];
		for (int i = 0; i < temp_b.length; i++) {
			parse_b[i] = Integer.parseInt(temp_b[i]);
		}

		Set<Integer> unique_a = new LinkedHashSet<Integer>(Arrays.asList(parse_a));
		Set<Integer> unique_b = new LinkedHashSet<Integer>(Arrays.asList(parse_b));
		
		
		
		int fault = 0, friends = 0, nothing = 0;
		
		System.out.println(unique_a.iterator());

		System.out.println(unique_a.size() + " " + unique_b.size());

		for (int i = 0; i < unique_a.size(); i++) {
			if (fault > unique_b.size() - unique_a.size()) {
				break;
			} else {
				if (unique_b.contains(unique_a) == true) {

				}
			}
		}
		System.out.println("Score : " + fault + " " + friends + " " + nothing);

		if (fault == 0 && friends >= 1) {
			System.out.println("friends");
		} else if (fault != 0 && friends > fault) {
			System.out.println("almost Friends");
		} else if (fault != 0 && nothing > fault) {
			System.out.println("nothing");
		}
	}
}
