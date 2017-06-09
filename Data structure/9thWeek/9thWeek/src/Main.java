import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
		String command;
		int item;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a command: e(nqueue), d(equeue), s(ize), peek, sort, p(rint), or q(uit)");
		System.out.print("> ");
		command = input.next();
		while (!command.equals("q")) {
			if (command.equals("e")) {
				item = input.nextInt();
				queue.enqueue(item);
			} else if (command.equals("d"))
				queue.dequeue();
			else if (command.equals("s"))
				System.out.println("size: " + queue.size());
			else if (command.equals("peek"))
				System.out.println("Front of the queue: " + queue.peek());
			else if (command.equals("p"))
				System.out.println(queue);
			else if (command.equals("sort"))
				radixSort();
			System.out.print("> ");
			command = input.next();
		}
		System.out.println("Commands Terminated.");

	}

	public static void radixSort() {
		final int MAX_ITEMS = 20;
		Integer[] items = new Integer[MAX_ITEMS];
		for (int i = 0; i < items.length; i++)
			items[i] = (int) (10000.0 * Math.random());
		System.out.print("정렬되지 않은 데이터: ");
		for (int i = 0; i < items.length; i++)
			System.out.print(items[i] + " ");
		System.out.println();

		for (int r = 10; r != 10000; r = r * 10) {
			Integer[] tempItems = new Integer[MAX_ITEMS];
			int radix = 10;
			ArrayQueue<Integer>[] queues = new ArrayQueue[radix];
			for (int i = 0; i < radix; i++)
				queues[i] = new ArrayQueue<Integer>();

			System.out.print((r / 10) + " 의 자리 : "); // 각 자릿수 0~9 큐에 넣기.
			for (int i = 0; i < items.length; i++) {
				int pos = (items[i] % r) / (r / 10);
				queues[pos].enqueue(items[i]);
			}
			int item_num = 0;
			for (int i = 0; i < queues.length; i++) {
				while (!queues[i].isEmpty()) {
					tempItems[item_num] = queues[i].dequeue();
					item_num++;
				}
			}
			for (int i = 0; i < tempItems.length; i++)
				System.out.print(tempItems[i] + " ");
			System.out.println();
		}
	}
}
