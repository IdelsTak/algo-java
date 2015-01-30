/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t11_Sorting_and_Teaching;

import java.awt.Point;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class E6_2D_Matrix {

	public class My_NotDone {

		int getVal(int[][] m, Point p) {
			return m[p.x][p.y];
		}

		//binary search
		public Point search_binary(int[][] m, Point pL, Point pH, int value) {
			Point p = new Point();
			p.x = (pL.x + pH.x) / 2;
			p.y = (pL.y + pH.y) / 2;
			if (m[p.x][p.y] == value) {
				return p;
			} else {

			}
			return null;
		}
	}

	public class my_iterSearch {
		//go throught all elements, O(M*N)
	}

	public class Bk_1_BinarySearch {

		public Point search(int[][] m, int value) {
			int rows = m.length;
			int cols = m[0].length;
			for (int i = 0; i < rows; i++) {
				//binary search on m[i][0-cols]
			}
			return null;
		}
	}

	/* find area: (i1, j1) ~ (i2, j2)
	 //find j1, j2
	 if a[m-1][j1] <v, j1 += 1;  j~ (0 ~ m-2)
	 if a[0][j2] > v,  j2 -= 1;  j~ (m-1 ~ 1)
	 //find i1, i2
	 if a[i1][j2] < v, i1+ = 1;  i ~ (0 ~ n-2)
	 if a[i2][j1] > v, i2 -= 1;  i ~ (n-1 ~ 1)

	 */
	static public class BK_2_StepAnalysis {

		public static boolean findElement(int[][] matrix, int elem) {
			int col = matrix[0].length;
			int row = 0;
			while (row < matrix.length && col >= 0) {
				if (matrix[row][col] == elem) {
					return true;
				} else if (matrix[row][col] > elem) {
					col--;
				} else {
					row++;
				}
			}
			return false;
		}
	}

	static public class BK_3_BinarySearch_ {
		//TODO: book p369
	}

	@Test
	public void test() {
		int[][] m = {
			{15, 21, 70, 85},
			{20, 35, 80, 95},
			{30, 55, 96, 105},
			{40, 82, 100, 120}
		};
	}

}
