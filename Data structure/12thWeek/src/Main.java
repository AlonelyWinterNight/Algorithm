import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BSTree tree = new BSTree();
		String command;
		int data;

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a command: i(insert), r(emove), s(earch), inorder,\n"
				+ "p(rint), h(eight), lc(leaf count), nc(node count), \nf(ull count),"
				+ "hps(has path sum), pp(print paths),or q(uit)");
		
		while (true) {
			System.out.print("> ");
			command = input.next();
			if (command.equals("i")) {
				data = input.nextInt();
				if (tree.insert(data))
					System.out.println(data + " inserted.");
				else
					System.out.println(data + " is in the tree.");
			} else if (command.equals("r")) {
				data = input.nextInt();
				if (tree.remove(data))
					System.out.println(data + " removed.");
				else
					System.out.println("No such " + data + "!");
			} else if (command.equals("s")) {
				data = input.nextInt();
				if (tree.search(data))
					System.out.println(data + " is in the tree.");
				else
					System.out.println("No such " + data + "!");
			} else if (command.equals("inorder"))
				tree.inorderTraverse();
			else if (command.equals("h"))
				System.out.println("Tree height: " + tree.height());
			else if (command.equals("nc"))
				System.out.println("Node count: " + tree.countNodes());
			else if (command.equals("lc"))
				System.out.println("Leaf count: " + tree.countLeaves());
			else if (command.equals("f"))
				System.out.println(tree.fullTree());
			else if (command.equals("pp")) {
				tree.printPaths();
			} else if (command.equals("hps")) {
				data = input.nextInt();
				if (tree.hasPathSum(data))
					System.out.println("yes");
				else
					System.out.println("no");
			} else if (command.equals("p"))
				tree.print();
			else if (command.equals("q")) {
				System.out.println("Commands terminated.");
				break;
			}
		}
		input.close();
	}
}
