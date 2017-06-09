package ����4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int numberOfPaths = 0;
	static int rowSize, colSize;

	public static void main(String[] args) throws FileNotFoundException {
		String[] files = { "maze1.txt", "maze2.txt", "maze3.txt", "maze4.txt" };

		for (int f = 0; f < files.length; f++) {
			Scanner sc = new Scanner(new File(files[f]));
			rowSize = Integer.parseInt(sc.next());
			colSize = Integer.parseInt(sc.next());
			char[][] maze = new char[rowSize][colSize];
			LinkedStack<Location> stack = new LinkedStack<Location>();
			Location S = new Location();
			int dist = 0;
			boolean pathOnly = false;
			if (f > 0)
				pathOnly = true;

			sc.nextLine(); // file������ ��ġ ���� (�� �ٲ�)
			for (int i = 0; i < rowSize; i++) { // �̷� �����.
				char[] temp = sc.nextLine().toCharArray(); // char Array��.
				for (int j = 0; j < colSize; j++) {
					maze[i][j] = temp[j];
					if (temp[j] == 'S') {
						S = new Location(i, j); // �������� ã��.
					}
				}
			}

			printMaze(maze);
			findExit(stack, S.getRow(), S.getCol(), maze, dist, pathOnly);
			System.out.println("Number of Paths : " + numberOfPaths);
			numberOfPaths = 0; // ����� �� �ʱ�ȭ.
			sc.close();
		}
	}

	public static void findExit(LinkedStack<Location> stack, int row, int col, char[][] maze, int dist,
			boolean pathOnly) {
		Location currLoc = new Location(row, col);

		if (maze[row][col] != 'E') {
			if (maze[row][col] != 'S')
				maze[row][col] = '.'; // �ⱸ�� �ƴϹǷ� �湮�� ��ġ�� . ǥ��
			stack.push(currLoc);
			dist += 1;
			// �� �� �� �� ������ �� �ִ��� �˻�.
			if (isMovable(row, col + 1, maze, rowSize, colSize)) { // ��
				currLoc = new Location(row, col + 1);
				findExit(stack, row, col + 1, maze, dist, pathOnly);
			}
			if (isMovable(row + 1, col, maze, rowSize, colSize)) { // ��
				currLoc = new Location(row + 1, col);
				findExit(stack, row + 1, col, maze, dist, pathOnly);
			}
			if (isMovable(row, col - 1, maze, rowSize, colSize)) { // ��
				currLoc = new Location(row, col - 1);
				findExit(stack, row, col - 1, maze, dist, pathOnly);
			}
			if (isMovable(row - 1, col, maze, rowSize, colSize)) { // ��
				currLoc = new Location(row - 1, col);
				findExit(stack, row - 1, col, maze, dist, pathOnly);
			}
			if (stack.isEmpty() != true) { // ������ ��� ���� �ʰ�, �ⱸ�� �� ã������
				maze[row][col] = ' '; // ���� ��ġ�� ���ư��鼭 ������ ����.
				currLoc = stack.pop(); // ���� ��ġ�� pop �Ͽ� ���� ��ġ�� ����.
				row = currLoc.getRow();
				col = currLoc.getCol();
			}
		} else if (maze[row][col] == 'E') { // �ⱸ�� ã�Ҵٸ�
			stack.push(currLoc); // E�� �ش��ϴ� Loc�� push
			numberOfPaths++; // ��� ���� �߰��Ѵ�.
			if (!pathOnly) { // ù��° �̷ο� ���ؼ��� ��θ� ����ϱ� ���� ���ǹ�
				System.out.println("Dist : " + dist + "\t" + stack.toString());
				printMaze(maze); // �� ���.
			}
			stack.pop(); // E�� �ش��ϴ� Loc�� pop
		}
	}

	public static boolean isMovable(int row, int col, char[][] maze, int rowSize, int colSize) {
		if (row >= 0 && col >= 0 && row < rowSize && col < colSize) {
			if (maze[row][col] == ' ' || maze[row][col] != '#' && maze[row][col] != '.') {
				return true;
			}
		}
		return false;
	}

	public static void printMaze(char[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
