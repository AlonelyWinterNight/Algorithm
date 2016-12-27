import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> N = new ArrayList<Integer>();
		String temp = sc.next();

		for (int i = 0; i < temp.length(); i++) {
			N.add((int) temp.charAt(i) - 48);
		}

		int eraser = sc.nextInt();
		ArrayList<Integer> index = new ArrayList<Integer>();

		if (N.contains(eraser) == true) {
			int count = 0;
			for (int i = 0; i < N.size(); i++) {
				if (eraser == N.get(i)) {
					index.add(i);
					count++;
				}
			}

			ArrayList<Integer> temp_array[] = new ArrayList[count];
			for (int i = 0; i < count; i++) {
				temp_array[i] = new ArrayList<Integer>();
			}

			ArrayList<Integer> temp_N = new ArrayList<Integer>();
			for (int i = 0; i < index.size(); i++) {
				temp_N.removeAll(temp_N);
				temp_N.addAll(N);
				temp_N.remove((int) index.get(i)); // remove는 int값인지 obj인지 명시.
				temp_array[i].addAll(temp_N);
			}

			int[] max = new int[temp_array.length];
			for (int i = 0; i < temp_array.length; i++) {
				StringBuilder temp_value= new StringBuilder("");
				for (int j = 0; j < temp_array[i].size(); j++) {
					temp_value.append(temp_array[i].get(j).toString());
				}
				max[i] = Integer.parseInt(temp_value.toString());
			}
			int result = max[0];
			for (int i = 1; i < max.length; i++) {
				if (result < max[i]) {
					result = max[i];
				}
			}
			System.out.println(result);
		} else {
			N.remove(eraser);
			printValues(N);
		}

	}

	public static void printValues(ArrayList<Integer> N) {
		if (N.isEmpty()) {
			System.out.println("Empty ArrayList.");
		} else {
			for (int i = 0; i < N.size(); i++) {
				System.out.print(N.get(i));
			}
			System.out.println("\n");
		}
	}
}
