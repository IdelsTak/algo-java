/*
Solutions to  http://www.careercup.com/question?id=5696362200956928
 000000000
 000000000
 00RRRR000
 00R00R000
 00RRRR000
 000000000
 000000000
 */
package google_interview;

import butil.MazeUtil;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author andy
 */
public class E40509_FindShape {

	public static class Sol_1_my {

		public static int find(char[][] a, int i, int j, char color, int method) {
			int nRow = a.length;
			int nCol = a[0].length;
			boolean[][] v = new boolean[nRow][nCol];
			if (method == 0) {
				return find_DFS(a, i, j, color, v);
			} else {
				return find_BFS(a, i, j, color, v);
			}
		}

		private static int visiting(char[][] a, int i, int j, char color, boolean[][] v) {
			if (i < 0 || j < 0 || i > a.length - 1 || j > a[0].length - 1 || v[i][j] || a[i][j] != color) {
				return 0;
			}
			v[i][j] = true;
			int num = 1;
			return num;
		}

		private static int find_DFS(char[][] a, int i, int j, char color, boolean[][] v) {
			int num = visiting(a, i, j, color, v);
			if (num > 0) {
				for (int k = 0; k < MazeUtil.d.length; k++) {
					num += find_DFS(a, i + MazeUtil.d[k][0], j + MazeUtil.d[k][1], color, v);
				}
			}
			return num;
		}

		private static int find_BFS(char[][] a, int i, int j, char color, boolean[][] v) {
			int num = visiting(a, i, j, color, v);
			if (num > 0) {
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				queue.add(j);
				while (!queue.isEmpty()) {
					i = queue.remove();
					j = queue.remove();
					for (int k = 0; k < MazeUtil.d.length; k++) {
						int i1 = i + MazeUtil.d[k][0];
						int j1 = j + MazeUtil.d[k][1];
						int num1 = visiting(a, i1, j1, color, v);
						if (num1 == 1) {
							queue.add(i1);
							queue.add(j1);
						}
						num += num1;
					}
				}
			}
			return num;
		}
	}
	public static void main(String[] argv) {
		char[][] a = {
			"000000000".toCharArray(),
			"00RRRR000".toCharArray(),
			"00R00R000".toCharArray(),
			"00RRRR000".toCharArray(),
			"000000000".toCharArray(),
			"000000000".toCharArray()};
		int i = 1, j = 2, num;
		num = Sol_1_my.find(a, i, j, 'R', 0);//DFS
		System.out.printf("DFS %d\n", num);

		num = Sol_1_my.find(a, i, j, 'R', 1);//BFS
		System.out.printf("BFS %d\n", num);
	}
}
