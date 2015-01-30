/*

 */

package t09_Recursion_DynamicProgramming;

import java.util.ArrayList;
import org.junit.Test;

/**
 * This is the code from the book, much less code This method only
 */
public class E9_Chess_bk {
	static final int N = 8;

	void placeQueens(int row, int[] cols, ArrayList<int[]> result) {
		if (row == N) {
			result.add(cols.clone());
		} else {
			for (int j = 0; j < N; j++) {
				if (isValid(row, j, cols)) {
					cols[row] = j;
					placeQueens(row + 1, cols, result);
				}
			}//for
		}//if
	}

	private boolean isValid(int row, int col, int[] cols) {
		boolean valid = true;

		for (int i = 0; i < row; i++) {
			//check is column validate
			if (cols[i] == col) {
				valid = false;
				break;
			}
			//check not in diagonal position of any queen
			int row1 = i;
			int col1 = cols[i];
			if (Math.abs(row1 - row) == Math.abs(col1 - col)) {
				valid = false;
				break;
			}
		}
		return valid;
	}

	@Test
	public void test() {
		ArrayList<int[]> result = new ArrayList<>();
		int[] cols = new int[N];
		placeQueens(0, cols, result);
		System.out.println(result.size());
	}
}
