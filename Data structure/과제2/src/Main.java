import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static final int ROW = 5;
	static final int COL = 4;
	static int availableSeat = 20;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List[] list = new List[ROW];
		initList(list); // ������ ����

		while (true) {
			System.out.print("> Enter a command: (r)eserve, c(ancel), f(ind), p(rint), or q(uit) : ");
			String function = sc.nextLine();
			if (function.equals("r")) {
				showCurrentState(list);
				System.out.print("\n> Enter a customer name and desired seat number : ");
				String inform = sc.nextLine();
				makeReservation(list, inform);
			} else if (function.equals("c")) {
				System.out.print("> Enter a customer name : ");
				String name = sc.nextLine();
				cancelReservation(list, name);
			} else if (function.equals("f")) {
				System.out.print("> Enter a customer name : ");
				String name = sc.nextLine();
				findResInfoByName(list, name);
			} else if (function.equals("p")) {
				showCurrentState(list);
				getResInfo(list);
			} else if (function.equals("q")) {
				System.out.println("End of comands !");
				sc.close();
				return; // ���� ����
			}
		}
	}

	public static void makeReservation(List[] list, String inform) { // ����
		StringTokenizer line = new StringTokenizer(inform);
		String name = line.nextToken(" ");
		String requiredSeat = line.nextToken(" ");
		int seatNumber = Integer.parseInt(requiredSeat.split("")[0]); // �� ��ȣ
		String seatSign = requiredSeat.split("")[1];
		if ("ABCD".contains(seatSign) != true || seatNumber > ROW) { // ������ �����
			System.out.println("---Caution : input is wrong. Please try again.---");
			return;
		} else {
			boolean done = false;
			done = list[seatNumber - 1].insert(name, seatNumber, seatSign, true); //�õ�
			if (done == true) {
				availableSeat--;
			} else {
				return;
			}
			showCurrentState(list);
			getResInfo(list);
		}
	}

	public static void cancelReservation(List[] list, String name) { // ���� ���
		boolean found = false;
		for (int i = 0; i < ROW && found != true; i++) {
			found = list[i].cancel(name);
		}
		if (found == true) {
			System.out.println(name + "'s reservation is canceled");
			availableSeat++;
		} else {
			System.out.println("Can't find customer '" + name + "'");
		}
	}

	public static void findResInfoByName(List[] list, String name) { // �̸����� ���� ��ȸ
		boolean found = false;
		for (int i = 0; i < ROW && found != true; i++) {
			found = list[i].find(name);
		}
		if (found == false) {
			System.out.println("Can't find customer '" + name + "'");
		}
	}

	public static void showCurrentState(List[] list) { // ���� ������ ���
		System.out.println("\nSeat Layout");
		System.out.println("-----------");
		for (int i = 0; i < ROW; i++) {
			System.out.print(i + 1);
			list[i].printList();
			System.out.println();
		}
	}

	public static void getResInfo(List[] list) { // ������� ����� ���� ���
		System.out.println("\nReservation Information");
		System.out.println("Name\tSeat");
		System.out.println("----\t----");
		for (int i = 0; i < ROW; i++) {
			list[i].info();
		}
		System.out.println("\nAvailable number of seats : " + availableSeat + "\n");
	}

	public static void initList(List[] list) { // ������ �ʱ�ȭ
		for (int i = 0; i < ROW; i++) {
			list[i] = new List();
			String str = "";
			char seatSign = 65;
			for (int j = 0; j < COL; j++) {
				str = String.valueOf(seatSign);
				list[i].insert(" ", i + 1, str, false);
				seatSign++;
			}
		}
	}
}
