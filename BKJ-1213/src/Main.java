import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] pel = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			pel[i] = str.charAt(i);
		}

		Pelindrome(pel);
	}

	public static void Pelindrome(char[] pel) {
		if (isPossible(pel) == true) {
			while (isPel(pel) != true) {
				shuffle(pel);
			}
			if (isPel(pel) == true) {
				System.out.println(pel);
			}
		} else {
			System.out.println("I'm Sorry Hansoo");
		}
	}

	public static void shuffle(char[] pel) {
		Random rnd = new Random();
		for (int i = pel.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			char temp = pel[index];
			pel[index] = pel[i];
			pel[i] = temp;
		}
	}

	public static boolean isPel(char[] pel) {
		boolean isPel = false;
		for (int i = 0; i < pel.length; i++) {
			if (pel[i] != pel[pel.length - 1 - i]) {
				isPel = false;
				break;
			} else {
				isPel = true;
				continue;
			}
		}
		return isPel;
	}

	public static boolean isPossible(char[] pel) {
		boolean isPel = false;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < pel.length; i++) {
			char key = pel[i];
			int count = 0;
			for (int j = 0; j < pel.length; j++) {
				if (key == pel[j]) {
					count++;
					map.put(pel[i], count);
				} else {
					continue;
				}
			}
		}

		Set<Character> set = map.keySet();
		Iterator<Character> it = set.iterator();
		char[] key = new char[set.size()];
		for (int i = 0; i < set.size(); i++) {
			key[i] = it.next();
		}

		int count_odd = 0;
		for (int i = 0; i < key.length; i++) {
			if (map.get(key[i]) % 2 == 1) {
				count_odd++;
			}
		}
		if (count_odd <= 1) {
			isPel = true;
		}
		return isPel;
	}
}
