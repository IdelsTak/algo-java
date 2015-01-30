/*http://www.careercup.com/question?id=5727310284062720
given an 2D matrix M, is filled either using X or O, you need 
to find the region which is filled by O and surrounded by X
and fill it with X.

example 1:

X X X X X
X X O O X
X X O O X
O X X X X

Answer :

X X X X X
X X X X X
X X X X X
O X X X X

example 2:

X X X X X
X X O O X
X X O O O
O X X X X

answer 2:
X X X X X
X X O O X
X X O O O
O X X X X
 */

package google_interview;

import butil.WrapBool;

public class E40214_2D_Matrix {

	public static void main(String[] arg){

		Sol_1.run(a1);
		System.out.println("\n");
		Sol_1.run(a2);
	}

	static int NOT_VISITED = 0;
	static int CHECKING = 1;
	static int DONE = 2;
	public static class Sol_1{
		static void run(char[][] a){
			int M = a.length, N = a[0].length, i = 0, j = 0;
			int[][] v = new int[M][N];
			for (i = 0; i < M; i++)
				for (j = 0; j < N; j++)
					if(v[i][j]==NOT_VISITED && a[i][j]=='O'){
						WrapBool valid = new WrapBool(true);
						visit(a, v, i, j, valid);
						if(valid.b)
							fill(a, v, i, j);
					}//if
			butil.Print.matrix(a);
		}//run

		private static void visit(char[][] a, int[][] v, int i, int j, WrapBool valid) {
			int M = a.length, N = a[0].length;
			if(i<0 || j<0 || i>=M || j>=N) {
				valid.b = false;
				return;
			}
			if(a[i][j]=='X' || v[i][j]!=NOT_VISITED) return;
			v[i][j] = CHECKING;
			int[][] d = butil.MazeUtil.d;
			for(int k = 0; k<d.length; k++)
				visit(a, v, i+d[k][0], j+d[k][1], valid);
		}//visit

		private static void fill(char[][] a, int[][] v, int i, int j) {
			if(v[i][j] != CHECKING) return;
			a[i][j] = 'X';
			v[i][j] = DONE;
			int[][] d = butil.MazeUtil.d;
			for(int k = 0; k<d.length; k++)
				fill(a, v, i+d[k][0], j+d[k][1]);
		}
	}

	//<editor-fold defaultstate="collapsed" desc="testMatrix">
		static char[][] a1 =			{
				{'X', 'X', 'X', 'X', 'X'},
				{'X', 'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'O', 'X'},
				{'O', 'X', 'X', 'X', 'X'}	};

		static char[][] a2 =			{
				{'X', 'X', 'X', 'X', 'X'},
				{'X', 'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'O', 'O'},
				{'O', 'X', 'X', 'X', 'X'},	};
	//</editor-fold>
}
