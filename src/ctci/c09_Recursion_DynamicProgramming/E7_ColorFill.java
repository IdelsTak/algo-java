/*
Comment: First don't understand the problem. after look into solution, then start to understand the problem
 */

package t09_Recursion_DynamicProgramming;

/**
 *
 * @author andy
 */
public class E7_ColorFill {
	public enum Color {
		green, red, black, yellow;
	}

	void fillColor(Color[][] scr, int x, int y, Color oColor, Color nColor) {
		if (x < 0 || x > scr[0].length
			|| y < 0 || y > scr.length) {
			return;
		}
		if (scr[x][y] == oColor) {
			scr[x][y] = nColor;
			fillColor(scr, x - 1, y, oColor, nColor);
			fillColor(scr, x, y - 1, oColor, nColor);
			fillColor(scr, x + 1, y, oColor, nColor);
			fillColor(scr, x, y + 1, oColor, nColor);
		}

	}

	void fillColor(Color[][] scr, int x, int y, Color nColor) {
		Color oColor = scr[x][y];
		if (oColor == nColor) {
			return;
		}

		fillColor(scr, x, y, oColor, nColor);
		scr[x][y] = nColor;
	}
}
