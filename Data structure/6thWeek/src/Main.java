import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		UnsortedLinkedList<Integer> list = new UnsortedLinkedList<Integer>();
		String command;
		int item, num;

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a command: i(insert), r(emove), s(earch),size, append, ");
		System.out.println("insert, remove, retrieve, reverse, p(rint), or q(uit)");
		System.out.print("> ");
		command = input.next();

		while (true) {
			if (command.equals("i")) {
				item = input.nextInt();
				list.insert(item);
			} else if (command.equals("r")) {
				item = input.nextInt();
				if (list.remove(item))
					System.out.println(item + " removed.");
				else
					System.out.println("No such " + item + "!");
			} else if (command.equals("ra")) {
				item = input.nextInt();
				list.removeAll(item);
				System.out.println("All " + item + "s removed.");
			} else if (command.equals("s")) {
				item = input.nextInt();
				if (list.search(item))
					System.out.println(item + " is in the list.");
				else
					System.out.println("No such " + item + "!");
			} else if (command.equals("size")) {
				System.out.println("size: " + list.size());
			} else if (command.equals("p"))
				System.out.println(list);
			else if (command.equals("reverse")) {
				UnsortedLinkedList<Integer> revList = reverse(list);
				System.out.println(revList);
			} else if (command.equals("insert")) {
				num = input.nextInt();
				item = input.nextInt();
				list.insert(num, item);
			} else if (command.equals("remove")) {
				num = input.nextInt();
				list.remove(num);
			} else if (command.equals("append")) {
				item = input.nextInt();
				list.append(item);
			} else if (command.equals("retrieve")) {
				num = input.nextInt();
				item = list.retrieve(num);
				System.out.println(item);
			} else if (command.equals("q"))
				break;
			System.out.print("> ");
			command = input.next();
		}
		System.out.println("Commands Terminated.");
		input.close();
	}

	private static <T> UnsortedLinkedList<T> reverse(UnsortedLinkedList<T> list) {
		UnsortedLinkedList<T> reverse = new UnsortedLinkedList<T>();
		T tempItem;
		list.reset(); // list의 head로 옮김.
		for (int i = 0; i < list.size(); i++) {
			tempItem = list.next(); // list의 node 값 item을 구해
			reverse.insert(tempItem); // 맨앞에 추가하면 거꾸로 완성
		}

		return reverse;
	}
}
