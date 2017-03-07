import java.util.Random;

public class PokerGame {
	public static void main(String[] args) {
		// 카드 패를 만들어두면, 52장의 카드를 한번에 관리할 수 있음.
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
		// 4명의 player가 7장의 Cards를 가짐.
		String[][] player = new String[4][7];

		// 게임을 시작하지.
		Game(Cards, player);
		System.out.println((System.currentTimeMillis() - time) / 1000.0);
	}
	
	public static void Game(String[] Cards, String[][] player) {
		// 승자를 가리기 위한 배열.
		int[] result = new int[4];

		// sorting을 랜덤으로 해버리면, 즉 카드 패를 랜덤하게 섞으면 되는 일.
		Random r = new Random();
		for (int i = 0; i < Cards.length; i++) {
			String temp = Cards[i];
			int randomPosition = r.nextInt(Cards.length);
			Cards[i] = Cards[randomPosition];
			Cards[randomPosition] = temp;
		}

		// 4명의 player가 7장의 Cards를 가진다. 섞은 패에서 카드를 분배한다.
		int k = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				player[i][j] = Cards[k];
				k++;
			}
		}

		// 현재 각 플레이어의 점수0 result를 구한다.
		int winner = 0;
		int same = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				result[i] += Integer.parseInt(player[i][j].replaceAll("[^0-9]", ""));
			}
		}
		// 승자를 가리는 부분. 승자인 player의 index를 갱신한다.
		for (int i = 1; i < 4; i++) {
			if (result[winner] == result[i]) {
				same++;
			} else if (result[winner] < result[i]) {
				continue;
			} else {
				winner = i;
			}
		}

		if (same >= 1) { //winner(1등)가 1명 이상이면 게임을 다시 시작하는 부분.
			ShowResult(player, result, winner);
			System.out.println("-------------Drawn Game--------------");
			Game(Cards, player);
		} else {
			ShowResult(player, result, winner);
		}
	}

	//게임 결과를 출력하는 함수.
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