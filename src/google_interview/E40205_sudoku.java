/*
Solutions for http://www.careercup.com/question?id=5975394641510400

Implement a sudoku solution verifier function.  The rules for sudoku is this:

You have a 9 by 9 board.  This board is divided into nine rows, nine columns, and nine 3x3 blocks.  In a solved puzzle, every row, every column, and every 0 block has to contain each of the digits from 1 to 9.  This is an example of a solved puzzle:

248|395|716
571|628|349
936|741|582
---+---+---
682|539|174
359|174|628
714|862|953
---+---+---
863|417|295
195|286|437
427|953|861
 */

package google_interview;

public class E40205_sudoku {
	public static void main(String[] arg){

	}

	public static boolean isValid(int[][] a){
		boolean[] h = new boolean[9];
		boolean status = false;
		//check rows
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++)
				if(!isValid(h, a[i][j]-1, status))
					return false;
			status = !status;
		}
		//check cols
		for(int j = 0; j<9; j++){
			for(int i = 0; i<9; i++)
				if(!isValid(h, a[i][j]-1, status))
					return false;
			status = !status;
		}
		//check zones
		for(int i0 = 0; i0 <= 6; i0 += 3)
			for(int j0 = 0; j0 <= 6; j0 += 3){
				for(int i = 0; i<3; i++)
					for(int j = 0; j<3; j++)
						if(!isValid(h, a[i0+i][j0+j]-1, status))
							return false;
				status = !status;
			}
		return true;
	}

	private static boolean isValid(boolean[] h, int v, boolean status){
		if(v<0 || v>8) return false;
		if(h[v]!=status) return false;
		h[v] = !h[v];
		return true;
	}


}
