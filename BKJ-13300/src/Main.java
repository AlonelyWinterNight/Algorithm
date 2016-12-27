import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int room = 0;
		HashMap<HashMap<Integer, Integer>, Integer> student = new HashMap<HashMap<Integer, Integer>, Integer>();
		for (int i = 0; i < N; i++) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			HashMap<Integer, Integer> key = new HashMap<Integer, Integer>();
			key.put(s, y);

			if (student.containsKey(key)) {
				student.put(key, student.get(key) + 1);

			} else {
				student.put(key, 1);
			}
		}
		
		Iterator<HashMap<Integer, Integer>> it = student.keySet().iterator();
		
		while (it.hasNext()) {
			HashMap<Integer, Integer> temp = it.next();
			if (student.get(temp) <= K) {
				room++;
			}else if (student.get(temp) > K) {
				int i = student.get(temp);
				while (i > 0) {
					room++;
					i = i - K;
				}
			}
		}
		
		System.out.println(room);
	}
}