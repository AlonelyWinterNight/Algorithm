import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap; // TreeMap은 key 기준으로 Tree 정렬돼있음.

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] card = new long[N];
		TreeMap<Long, Integer> hash = new TreeMap<Long, Integer>();
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextLong();
		}

		int maxCnt = 0;
		for (int i = 0; i < card.length; i++) {
			if (hash.containsKey(card[i]) != true) {
				hash.put(card[i], 1);
			} else {
				int cnt = hash.get(card[i]) + 1;
				hash.put(card[i], cnt);
			}
		}
	
		Set<Long> key_set = hash.keySet();
		Long[] key = key_set.toArray(new Long[key_set.size()]);
		long maxKey = key[0];
		for (int i = 1; i < key.length; i++) {
			if (hash.get(maxKey) < hash.get(key[i])) {
				maxKey = key[i];
			}
			else if (hash.get(maxKey) == hash.get(key[i]) && maxKey > key[i]) {
				maxKey = key[i];
			}
		}
		System.out.println(maxKey);
	}
}
