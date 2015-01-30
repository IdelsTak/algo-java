/*
Solutions to  http://www.careercup.com/question?id=5837582990573568

 given a board with black (1) and white (0), black are all connected.
 find the min rectangle that contains all black.

 example:
 0 0 0 0 0
 0 1 1 1 0
 0 1 1 0 0
 0 1 0 0 0
 0 0 0 0 0

 the min rectangle contains all black (1) is the
 rectangle from (1,1) - (3, 3)

 */
package google_interview;

/**
 * TODO: Not optimized, to do optimize
 */
public class E40321_maxRect {

	static int[][] a = {
		{0, 0, 0, 0, 0},
		{0, 1, 1, 1, 0},
		{0, 1, 1, 0, 0},
		{0, 1, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};
	static int rs;
	static int cs;

	public static class Area {

		int x1, y1;
		int x2, y2;
		int s = 0;

		@Override
		public String toString() {
			String str = String.format("(%d, %d) -- (%d, %d) = %d",
				x1, y1, x2, y2, s);
			return str;
		}
	}

	public static void main(String[] arg) {
		Area maxArea = new Area();

		rs = a.length;
		cs = a[0].length;

		for (int i = 0; i < rs; i++) {
			for (int j = 0; j < cs; j++) {
				if (a[i][j] == 1) {
					Area area = max(i, j);
					maxArea = (maxArea.s > area.s) ? maxArea : area;
				}//if
			}//for i
		}//for j
		System.out.println(maxArea);
	}//main

	//find the max size start with current location
	//by increase different row
	public static Area max(int x, int y) {
		Area max = new Area();
		int i, j;
		int lastCol = cs;
		for (i = x; i < rs; i++) {
			if (a[i][y] == 1) {
				for (j = y + 1; j < lastCol; j++) {
					if (a[i][j] == 0) {
						break;
					}
				}
				lastCol = y;
				int curSize = (i - x + 1) * (j - y);
				if (curSize > max.s) {
					max.s = curSize;
					max.x1 = x;
					max.y1 = y;
					max.x2 = i;
					max.y2 = j - 1;
				}
				lastCol = j;
			} else {
				break;
			}
		}
		return max;
	}
}
