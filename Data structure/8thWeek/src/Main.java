import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		String command;
		int item;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a command: push,pop,peek,size,b(find big) "
				+ "m(test matching parenthesis), p(rint), or q(uit)");
		System.out.print("> ");
		command = in.next();
		while (!command.equals("q")) {
			if (command.equals("push")) {
				item = in.nextInt();
				stack.push(item);
			} else if (command.equals("pop"))
				stack.pop();
			else if (command.equals("peek")) {
				item = stack.peek();
				System.out.println("Top element is " + item);
			} else if (command.equals("size"))
				System.out.println("size: " + stack.size());
			else if (command.equals("p"))
				System.out.println(stack);
			else if (command.equals("m")) // 문제 2
				checkParenthesis();
			else if (command.equals("b")) { // 문제 3
				int[] data = { 10, 5, 7, 2, 9, 15, 12, 3, 5, 14 };
				int[] big = getLastAsBig(data);
				int i;
				System.out.print("[");
				for (i = 0; i < big.length - 1; i++)
					System.out.print(big[i] + ", ");
				System.out.println(big[i] + "]");
			}
			System.out.print("> ");
			command = in.next();
		}
		System.out.println("Commands terminated.");
		in.close();
	}

	private static void checkParenthesis() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input.txt"));
		while (sc.hasNextLine()) {
			LinkedStack<Character> tempStack = new LinkedStack<Character>();
			char[] line = sc.nextLine().toCharArray();
			for (int i = 0; i < line.length; i++) {
				if (line[i] == '(') {
					tempStack.push(line[i]);
				}
				if (line[i] == ')') {
					if (tempStack.isEmpty()) {
						tempStack.push(line[i]); // 마지막 불일치 괄호를 스택에 쌓고
						break; // 불일치 오류이므로 종료.
					} else {
						tempStack.pop();
					}
				}
			}
			for (int i = 0; i < line.length; i++) {
				System.out.print(line[i]); // 앞서 사용한 line배열 재사용하여 출력.
			}
			System.out.println();
			if (tempStack.isEmpty()) {
				System.out.println("Parentheses are matched\n");
			} else if (tempStack.peek() == '(') {
				System.out.println("Opening Parentheses are not matched\n");
			} else if (tempStack.peek() == ')') {
				System.out.println("Closing Parentheses are not matched\n");
			}
		}
		sc.close();
	}

	private static int[] getLastAsBig(int[] data) {
		int[] temp = new int[data.length];

		for (int i = 0; i < data.length; i++) {
			LinkedStack<Integer> tempStack = new LinkedStack<>();
			int flag = data[i];
			for (int j = 0; j < i + 1; j++) {
				tempStack.push(data[j]);
			}
			while (tempStack.isEmpty() != true) {
				if (tempStack.pop() > flag) {
					temp[i] = tempStack.size();
					break;
				} else {
					temp[i] = -1;
				}
			}
		}
		return temp;
	}
}
