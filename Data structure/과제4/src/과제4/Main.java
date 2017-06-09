package 과제4;

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

			sc.nextLine(); // file포인터 위치 변경 (줄 바꿈)
			for (int i = 0; i < rowSize; i++) { // 미로 만들기.
				char[] temp = sc.nextLine().toCharArray(); // char Array로.
				for (int j = 0; j < colSize; j++) {
					maze[i][j] = temp[j];
					if (temp[j] == 'S') {
						S = new Location(i, j); // 시작점을 찾음.
					}
				}
			}

			printMaze(maze);
			findExit(stack, S.getRow(), S.getCol(), maze, dist, pathOnly);
			System.out.println("Number of Paths : " + numberOfPaths);
			numberOfPaths = 0; // 경로의 수 초기화.
			sc.close();
		}
	}

	public static void findExit(LinkedStack<Location> stack, int row, int col, char[][] maze, int dist,
			boolean pathOnly) {
		Location currLoc = new Location(row, col);

		if (maze[row][col] != 'E') {
			if (maze[row][col] != 'S')
				maze[row][col] = '.'; // 출구가 아니므로 방문한 위치는 . 표시
			stack.push(currLoc);
			dist += 1;
			// 상 하 좌 우 움직일 수 있는지 검사.
			if (isMovable(row, col + 1, maze, rowSize, colSize)) { // 우
				currLoc = new Location(row, col + 1);
				findExit(stack, row, col + 1, maze, dist, pathOnly);
			}
			if (isMovable(row + 1, col, maze, rowSize, colSize)) { // 하
				currLoc = new Location(row + 1, col);
				findExit(stack, row + 1, col, maze, dist, pathOnly);
			}
			if (isMovable(row, col - 1, maze, rowSize, colSize)) { // 좌
				currLoc = new Location(row, col - 1);
				findExit(stack, row, col - 1, maze, dist, pathOnly);
			}
			if (isMovable(row - 1, col, maze, rowSize, colSize)) { // 상
				currLoc = new Location(row - 1, col);
				findExit(stack, row - 1, col, maze, dist, pathOnly);
			}
			if (stack.isEmpty() != true) { // 스택이 비어 있지 않고, 출구를 못 찾았으면
				maze[row][col] = ' '; // 이전 위치로 돌아가면서 흔적을 지움.
				currLoc = stack.pop(); // 이전 위치를 pop 하여 현재 위치로 설정.
				row = currLoc.getRow();
				col = currLoc.getCol();
			}
		} else if (maze[row][col] == 'E') { // 출구를 찾았다면
			stack.push(currLoc); // E에 해당하는 Loc을 push
			numberOfPaths++; // 경로 수를 추가한다.
			if (!pathOnly) { // 첫번째 미로에 대해서만 경로를 출력하기 위한 조건문
				System.out.println("Dist : " + dist + "\t" + stack.toString());
				printMaze(maze); // 맵 출력.
			}
			stack.pop(); // E에 해당하는 Loc을 pop
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
