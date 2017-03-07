import java.util.Random;

public class PokerGame {
	public static void main(String[] args) {
		// ī�� �и� �����θ�, 52���� ī�带 �ѹ��� ������ �� ����.
		long time = System.currentTimeMillis();
		String[] Cards = new String[52]; // ArrayList
		for (int i = 0, j = 0; i < Cards.length; i++, j++) {
			if (j > 12) {
				j = 0;
			}
			if (i < 13) {
				Cards[i] = "S" + (j + 1);
			} else if (i < 26) {
				Cards[i] = "D" + (j + 1);
			} else if (i < 39) {
				Cards[i] = "H" + (j + 1);
			} else if (i < 52) {
				Cards[i] = "C" + (j + 1);
			}
		}
		// 4���� player�� 7���� Cards�� ����.
		String[][] player = new String[4][7];

		// ������ ��������.
		Game(Cards, player);
		System.out.println((System.currentTimeMillis() - time) / 1000.0);
	}
	
	public static void Game(String[] Cards, String[][] player) {
		// ���ڸ� ������ ���� �迭.
		int[] result = new int[4];

		// sorting�� �������� �ع�����, �� ī�� �и� �����ϰ� ������ �Ǵ� ��.
		Random r = new Random();
		for (int i = 0; i < Cards.length; i++) {
			String temp = Cards[i];
			int randomPosition = r.nextInt(Cards.length);
			Cards[i] = Cards[randomPosition];
			Cards[randomPosition] = temp;
		}

		// 4���� player�� 7���� Cards�� ������. ���� �п��� ī�带 �й��Ѵ�.
		int k = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				player[i][j] = Cards[k];
				k++;
			}
		}

		// ���� �� �÷��̾��� ����0 result�� ���Ѵ�.
		int winner = 0;
		int same = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				result[i] += Integer.parseInt(player[i][j].replaceAll("[^0-9]", ""));
			}
		}
		// ���ڸ� ������ �κ�. ������ player�� index�� �����Ѵ�.
		for (int i = 1; i < 4; i++) {
			if (result[winner] == result[i]) {
				same++;
			} else if (result[winner] < result[i]) {
				continue;
			} else {
				winner = i;
			}
		}

		if (same >= 1) { //winner(1��)�� 1�� �̻��̸� ������ �ٽ� �����ϴ� �κ�.
			ShowResult(player, result, winner);
			System.out.println("-------------Drawn Game--------------");
			Game(Cards, player);
		} else {
			ShowResult(player, result, winner);
		}
	}

	//���� ����� ����ϴ� �Լ�.
	public static void ShowResult(String[][] player, int[] result, int winner) {
		System.out.println("---------------Players---------------");
		for (int i = 0; i < 4; i++) {
			System.out.print("Player" + (i + 1) + " : ");
			for (int j = 0; j < 7; j++) {
				System.out.print(player[i][j] + " ");
			}
			System.out.println(": sum = " + result[i]);
		}
		System.out.println("Winner : " + "Player" + (winner + 1));
	}
}