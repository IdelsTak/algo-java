/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t17_ModerateSolutions;

/**
 *
 * @author andy
 */
public class E02_Tic_Tac_Toe {
	//solution 1:
	static boolean isWin_1(char[][] lay, char side) {
		//rows
		for (int i = 0; i < lay.length; i++) {
			boolean rows = true;
			for (int j = 0; j < lay[0].length; j++) {
				rows = rows && (lay[i][j] == side);
			}
			if (rows) {
				return true;
			}
		}
		//cols
		for (int j = 0; j < lay[0].length; j++) {
			boolean cols = true;
			for (int i = 0; i < lay.length; i++) {
				cols &= cols && (lay[i][j] == side);
			}
			if (cols) {
				return true;
			}
		}
		//diagonal
		boolean dia = true;
		for (int i = 0; i < lay.length; i++) {
			dia = dia && lay[i][i] == side;
		}
		if (dia) {
			return true;
		}
		//reverse diagonal
		boolean rdia = true;
		for (int i = 0; i < lay.length; i++) {
			rdia = dia && lay[i][lay.length - i - 1] == side;
		}
		return rdia;
	}

	/*solution 2:
	 ' ' -- 0
	 'x' -- 1
	 'o' -- 2
	 */
	private static int getSideValue(char side) {
		switch (side) {
			case ' ':
				return 0;
			case 'x':
				return 1;
			case 'o':
				return 2;
		}
		return 0;
	}

	private static int getHashIndex(char[][] lay, char side) {
		int n = lay.length;
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (lay[i][j] == side) {
					idx += getSideValue(side) * (int) Math.pow(3, 3 * i + j);
				}
			}
		}
		return idx;
	}

	private static boolean[] getHashTable(int n) {
		boolean[] table = new boolean[(int) Math.pow(3, 9)];
		int[] pow = new int[n * n];	pow[0] = 1;
		for (int i = 1; i < pow.length; i++) {
			pow[i] = 3 * pow[i - 1];
		}
		//rows
		for (int i = 0; i < n; i++) {
			int iRow = 0, iCol = 0, iDia = 0, iRdia = 0;
			for (int j = 0; j < n; j++) {
				iRow += pow[3 * i + j];
			}
			table[iRow] = true;//for player 1
			table[2 * iRow] = true;//for player 2
		}
		//rows
		for (int j = 0; j < n; j++) {
			int iCol = 0;
			for (int i = 0; i < n; i++) {
				iCol += pow[3 * i + j];
			}
			table[iCol] = true;//for player 1
			table[2 * iCol] = true;//for player 2
		}

		//diagonal,reverse diagonal
		int iDia = 0, iRdia = 0;
		for (int i = 0; i < n; i++) {
			iDia += pow[3 * i + i];
			iRdia += pow[3 * i + 3 - i - 1];
		}
		table[iDia] = true;
		table[iRdia] = true;
		return table;
	}

	public static boolean isWin_2(char[][] lay, char side) {
		int n = lay.length;
		int[] pow = new int[n * n];
		pow[0] = 1;
		for (int i = 1; i < pow.length; i++) {
			pow[i] = 3 * pow[i - 1];
		}
		int hIdx = getHashIndex(lay, side);
		boolean[] hTable;
		hTable = getHashTable(lay.length);
		return hTable[hIdx];
	}

	public static void main(String argv[]) {
		char[][] s1 = {
			{'x', ' ', ' '},
			{'x', ' ', ' '},
			{'x', ' ', ' '},};
		char[][] s2 = {
			{'x', ' ', ' '},
			{' ', 'x', ' '},
			{'x', ' ', ' '},};
		System.out.println("isWin_1");
		System.out.println(isWin_1(s1, 'x'));
		System.out.println(isWin_1(s2, 'x'));
		System.out.println("isWin_2");
		System.out.println(isWin_2(s1, 'x'));
		System.out.println(isWin_2(s2, 'x'));
	}
}
