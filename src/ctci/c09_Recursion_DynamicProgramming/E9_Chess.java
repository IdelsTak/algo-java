/*
 */

package t09_Recursion_DynamicProgramming;

import java.awt.Point;
import java.util.LinkedList;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class E9_Chess {

	public static final int N = 8;
	static final int[][] chess = new int[8][8];

	class Usage {
		boolean[] r = new boolean[N];//row
		boolean[] c = new boolean[N];//col
		LinkedList<Point> p = new LinkedList<>();

		public Usage Clone() {
			Usage newUsage = new Usage();
			java.lang.System.arraycopy(r, 0, newUsage.r, 0, N);
			java.lang.System.arraycopy(c, 0, newUsage.c, 0, N);
			newUsage.p = (LinkedList<Point>) p.clone();
			return newUsage;
		}

		public void putQueen(int i, int j) {
			r[i] = true;
			c[j] = true;
			p.add(new Point(i, j));
		}
	}

	/*
	 i, j: should not be in the same row
	 should not be in the angle of any node
	 */
	boolean isValid(int i, int j, Usage u) {
		boolean isValid = true;
		if ((0 <= i && i < N
			&& 0 <= j && j < N)
			&& (u.r[i] || u.c[j])) {
			isValid = false;
		} else {
			for (Point p : u.p) {
				if (Math.abs(p.x - i) == Math.abs(p.y - j)) {
					isValid = false;
					break;
				}
			}
		}
		return isValid;
	}

	int run(Usage u, int nextRow) {
		if (nextRow == N) {
			butil.Print.printList(u.p, true);
			return 1;
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {//check all the locations
			if (isValid(nextRow, i, u)) {//put the ball here
				Usage tmp = u.Clone();
				tmp.putQueen(nextRow, i);
				sum += run(tmp, nextRow + 1);
			}
		}
		return sum;
	}


	@Test
	public void test() {
		Usage usage = new Usage();
		int num = run(usage, 0);
		System.out.println(num);
	}
}
