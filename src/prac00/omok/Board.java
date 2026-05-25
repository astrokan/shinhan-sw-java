package prac00.omok;

public class Board {
	
	int size;
	String[][] map;
	boolean[][][] visited; // 방문 여부 판단 배열(y좌표, x좌표, 방향)
	final int[] dy = { 0, 1, 1, 1 };
	final int[] dx = { 1, 1, 0, -1 };

	Board(int size) {
		this.size = size;
		map = new String[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				map[row][col] = ".";
			}
		}
	}

	// 오목판 출력
	public void print() {
		for (int row = 0; row < size; row++) {
			System.out.print(row);
			if (row < 10) System.out.print(" ");
			
			for (int col = 0; col < size; col++) {
				System.out.print(" " + map[row][col]);
			}
			System.out.println();
		}
		
		System.out.print("  ");
		for (int row = 0; row < size; row++) {
			System.out.print(" " + (char) (65 + row));
		}
		System.out.println();
	}

	// 마킹
	public boolean mark(String stone, int y, int x) {
		if (map[y][x].equals(".")) {
			map[y][x] = stone;
			return true;
		} else return false;
	}

	// 탐색 후 연속된 돌의 개수 리턴
	private int dfs(int y, int x, int dir, String stone) {

		// sol 1. 한 방향으로만 탐색하는 dfs

//    	visited[y][x][dir] = true;
//    	
//		int ny = y + dy[dir];
//		int nx = x + dx[dir];
//		
//		// 인덱스 밖 제외
//		if (ny < 0 || ny >= size || nx < 0 || nx >= size) return 1;
//		if (!map[ny][nx].equals(stone)) return 1;
//		
//		return dfs(ny, nx, dir, stone) + 1;

		// sol 2. while문 활용한 선형 탐색 (dfs 아님)

		int cnt = 1;

		while (true) {
			visited[y][x][dir] = true;

			y += dy[dir];
			x += dx[dir];

			if (y < 0 || y >= size || x < 0 || x >= size) return cnt;
			if (!map[y][x].equals(stone)) return cnt;
			
			cnt++;
		}
	}

	// 스캔 안된 방향으로 탐색 시작
	public int search(int y, int x, String stone) {
		int ret = -1;

		for (int i = 0; i < 4; i++) {
			// 이미 스캔된 방향 + 좌표
			if (visited[y][x][i]) continue;
			
			int cnt = dfs(y, x, i, stone);
			if (cnt == 5) return 5;

			ret = Math.max(ret, cnt);
		}
		
		return ret;
	}
}
