import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		UnsortedLinkedList<Integer> list = new UnsortedLinkedList<Integer>();
		String command;
		int item, num;

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a command: if(insert first), s(earch), size, il(insert last), rf(remove first),");
		System.out.println("ra(remove all),n(th item), c(opy), p(rint), rp(reverse print), or q(uit)");
		System.out.print("> ");
		command = input.next();

		while (!command.equals("q")) {
			if (command.equals("if")) {
				item = input.nextInt();
				list.insertFirst(item);
			} else if (command.equals("il")) {
				item = input.nextInt();
				list.insertLast(item);
			} else if (command.equals("n")) {
				num = input.nextInt();
				if (num <= 0 || num > list.size())
					System.out.println("Out of list range.");
				else
					System.out.println(list.getNthItem(num));
			} else if (command.equals("s")) {
				item = input.nextInt();
				if (list.search(item))
					System.out.println(item + " is in the list.");
				else
					System.out.println("No such " + item + "!");
			} else if (command.equals("rp")) {
				list.reversePrint();
			} else if (command.equals("rf")) {
				item = input.nextInt();
				if (list.removeFirst(item))
					System.out.println(item + " removed.");
				else
					System.out.println("No such " + item + "!");
			} else if (command.equals("ra")) {
				item = input.nextInt();
				if (list.removeAll(item))
					System.out.println(item + " removed.");
				else
					System.out.println("No such " + item + "!");
			} else if (command.equals("rp")) {
				list.reversePrint();
			} else if (command.equals("c")) {
				UnsortedLinkedList<Integer> copyList;
				copyList = list.copy();
				System.out.println("size: " + copyList.size());
				copyList.print();
				copyList.clear();
			} else if (command.equals("size")) {
				System.out.println("size: " + list.size());
			} else if (command.equals("p"))
				list.print();

			System.out.print("> ");
			command = input.next();
		}
		input.close();
		System.out.println("Commands Terminated.");
	}
}
