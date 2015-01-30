/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_yanWeiMi;

import butil.MazeUtil;
import butil.Print;
import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author andy
 */
public class B324_MazeWalking {

	public static final int VISITED = 2;

	public static void main(String[] argc) {
		int[][] m = getMaze();
		//
		Sol_1_my_onePath.walk(m, 10, 1, 2, 0);
		//
		m = getMaze();
		Sol_2_my_allPath_HaveIssues_not_allPath.walk(m, 10, 1, 2, 0);
		//
		Sol_3_DS_P51.maze m1 = new Sol_3_DS_P51.maze(getMaze());

		Sol_3_DS_P51.walk(m1, new Point(10, 1), new Point(2, 0));
	}

	private static int[][] getMaze() {
		int[][] m = {
			{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
			{1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
			{0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 2},
			{1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 3},
			{1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 4},
			{1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 5},
			{1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 6},
			{1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 7},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 8},
			{1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 9},
			{1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 10},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11},};
		return m;
	}

	public static class Sol_1_my_onePath {// <editor-fold defaultstate="collapsed" desc="Hidden Code">

		public static void walk(int[][] a, int si, int sj, int di, int dj) {
			System.out.println("Solutions 1");
			LinkedList<String> options = new LinkedList<>();
			Sol_1_my_onePath.walk(a, "", si, sj, di, dj, options);
			Print.printListLn(options);
		}

		public static void walk(int[][] a, String path, int si, int sj, int di, int dj, LinkedList<String> pathes) {
			path += String.format("(%d, %d)\n", si, sj);
			if (si == di && sj == dj) {
				pathes.add(path);
				return;
			}
			if (si < 0 || sj < 0 || si >= a.length - 1 || sj > a[0].length || a[si][sj] != 0) {
				return;
			}

			a[si][sj] = 2;

			int[][] d = MazeUtil.d;
			for (int i = 0; i < d.length; i++) {
				walk(a, path, si + d[i][0], sj + d[i][1], di, dj, pathes);
			}
		}
	}// </editor-fold>

	//this code does not print all the path, still have some issues
	public static class Sol_2_my_allPath_HaveIssues_not_allPath {// <editor-fold defaultstate="collapsed" desc="Hidden Code">

		public static void walk(int[][] a, int si, int sj, int di, int dj) {
			System.out.println("Solutions 2");
			LinkedList<String> paths = new LinkedList<>();
			HashMap<String, String> map = new HashMap<>();
			Sol_2_my_allPath_HaveIssues_not_allPath.walk(a, "", si, sj, di, dj, paths, map);
			Print.printListLn(paths);
		}

		private static String getShortestPath(String[] p) {
			int k = -1;
			for (int i = 1; i < p.length; i++) {
				if ((p[i] != null && k == -1)
					|| (p[i] != null && k != -1 && p[i].length() < p[k].length())) {
					k = i;
				}
			}
			if (k == -1) {
				return null;
			} else {
				return p[k];
			}
		}

		public static String walk(int[][] a, String path, int si, int sj, int di, int dj, LinkedList<String> pathes, HashMap<String, String> map) {
			String loc = String.format("(%d, %d)\n", si, sj);
			if (null != map.get(loc)) {
				return map.get(loc);
			}

			path += loc;
			if (si == di && sj == dj) {
				pathes.add(path);
				return path;
			} else if (si < 0 || sj < 0 || si >= a.length - 1 || sj > a[0].length || a[si][sj] != 0) {
				return null;
			}

			a[si][sj] = 2;

			String[] p = new String[4];
			int[][] d = MazeUtil.d;
			for (int i = 0; i < d.length; i++) {
				p[i] = walk(a, path, si + d[i][0], sj + d[i][1], di, dj, pathes, map);
			}

			String shortestPath = getShortestPath(p);
			if (null != shortestPath) {
				map.put(loc, shortestPath);
			}
			return shortestPath;
		}//walk

	}// </editor-fold>

	//use the algorithm from book, much more clear in algorithm, need fully under
	//TODO: rewrite again.
	public static class Sol_3_DS_P51 {	// <editor-fold defaultstate="collapsed" desc="Hidden Code">
		public static class SElem {

			int ord;
			Point p;
			int di;

			public SElem(int ord, Point p, int di) {
				this.ord = ord;
				this.p = p;
				this.di = di;
			}
		}//SElem

		public static class maze {

			int[][] a;

			public maze(int[][] a) {
				this.a = a;
			}

			void footPrint(Point p) {
				a[p.x][p.y] = 2;
			}

			boolean pass(Point p) {
				if (null == p) {
					return false;
				}
				int rows = a.length;
				int cols = a[0].length;
				return p.x >= 0 && p.y >= 0 && p.x <= rows - 1 && p.y <= cols - 1 && a[p.x][p.y] == 0;
			}

			Point nextPos(Point p, int dir) {
				Point nextP = new Point(p.x + MazeUtil.d[dir][0], p.y + MazeUtil.d[dir][1]);
				return nextP;
			}
		}//maze

		public static boolean walk(maze m, Point start, Point end) {
			System.out.println("===============Solution 3===============");
			SElem e;
			Stack<SElem> stack = new Stack<SElem>();
			Point curPos = start;
			int curStep = 1;
			do {
				if (m.pass(curPos)) {
					m.footPrint(curPos);
					Print.intArrayPrint(m.a);//for Debug
					if (curPos.equals(end)) {
						Print.printListLn(stack);
						return true;
					}

					e = new SElem(curStep, curPos, 0);
					stack.push(e);
	
					curPos = m.nextPos(curPos, e.di);
					curStep++;
				} else {//curPoint is not passible
					if (!stack.isEmpty()) {
						e = stack.pop();
						while (e.di == 4 - 1 && !stack.isEmpty()) {
							e = (SElem) stack.pop();
							m.footPrint(e.p);//e.p//markPrint(e.p)
						}
						if (e.di < 4 - 1) {
							e.di++;
							stack.push(e);
							curPos = m.nextPos(e.p, e.di);
						}
					}//if
				}//else
			} while (!stack.isEmpty());
			return false;
		}//walk
	}// </editor-fold>
}
