/*
Solutions to http://www.careercup.com/question?id=5709186067333120
 How many occurrences of a given search word can you find in a two-dimensional array of characters given that the word can go up, down, left, right, and around 90 degree bends?

 Ex:
 Count of occurrences of SNAKES
 S N B S N
 B A K E A
 B K B B K
 S E B S E

 The answer is 3.

 Write a program for that question
 */
package google_interview;

public class E40607_SnakeCounting {

	public static class Sol_1_my {//<editor-fold defaultstate="collapsed" desc="comment">

		public static class SearchLoc {//<editor-fold defaultstate="collapsed" desc="comment">
			int i, j, b;//i j: location in a,,,,,, b: is the current indx in sting index
			public SearchLoc() {}

			public SearchLoc(int i, int j, int b) {
				this.i = i;
				this.j = j;
				this.b = b;
			}

			public SearchLoc(SearchLoc s) {
				this(s.i, s.j, s.b);
			}

			public static SearchLoc[] getNextLocs(SearchLoc curr) {
				SearchLoc[] locs = new SearchLoc[4];
				for (int i = 0; i < 4; i++) {
					locs[i] = new SearchLoc(curr);
					locs[i].b++;
				}
				locs[0].i += 1;
				locs[1].i -= 1;
				locs[2].j += 1;
				locs[3].j -= 1;
				return locs;
			}

			@Override
			public String toString() {
				return String.format("(%s %s)   %s", i, j, b);
			}
		}//</editor-fold>

		//search from every location, to find the match
		public static int search(char[][] a, String txt) {
			int num = 0;
			char[] b = txt.toCharArray();
			for (int i = 0; i < a.length; i++)
				for (int j = 0; j < a[0].length; j++)
					num += search(a, b, new SearchLoc(i, j, 0));
			return num;
		}

		private static int search(char[][] a, char[] b, SearchLoc s) {
			int matches = 0;
			if (s.b == b.length || (s.b == b.length - 1 && isCurMatch(a, b, s))) {
				matches = 1;
			} else
				if (isCurMatch(a, b, s)) {
					SearchLoc[] locs = SearchLoc.getNextLocs(s);
					for (SearchLoc loc : locs) matches += search(a, b, loc);
				}
			return matches;
		}

		private static boolean between(int a, int b, int c) {
			return a <= b && b <= c;
		}

		private static boolean isCurMatch(char[][] a, char[] b, SearchLoc s) {
			//System.out.println(s);
			if (!between(0, s.i, a.length - 1)
				|| !between(0, s.j, a[0].length - 1)
				|| !between(0, s.b, b.length - 1)) {
				return false;
			} else {
				return a[s.i][s.j] == b[s.b];
			}
		}

	}//</editor-fold>

	/*
	 this code is much neat
	 */
	public static class sol_2_my_basedOnWebSolution {

		private static String[] path;

		public static int search(char[][] a, String txt) {//search from every start location
			path = new String[txt.length()];
			int count = 0;
			for (int i = 0; i < a.length; i++)
				for (int j = 0; j < a[0].length; j++)
					count += search(a, i, j, txt, 0);
			return count;
		}

		private static int search(char[][] a, int i, int j, String txt, int txtIndex) {	//search termination condition
			if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || txtIndex >= txt.length())
				return 0;
			int count = 0;
			path[txtIndex] = String.format("(%d,%d)", i, j);
			if (txtIndex == txt.length() - 1 && a[i][j] == txt.charAt(txtIndex)) {//the result is found
				count = 1;
				butil.Print.stringArrayPrint(path);
			} else if (a[i][j] == txt.charAt(txtIndex)) {//search different directions
				count += search(a, i + 1, j, txt, txtIndex + 1);
				count += search(a, i, j + 1, txt, txtIndex + 1);
				count += search(a, i - 1, j, txt, txtIndex + 1);
				count += search(a, i, j - 1, txt, txtIndex + 1);
			}//if
			return count;
		}
	}

	public static void main(String[] argv) {
		char[][] a = {
			{'S', 'N', 'B', 'S', 'N'},
			{'B', 'A', 'K', 'E', 'A'},
			{'B', 'K', 'B', 'B', 'K'},
			{'S', 'E', 'B', 'S', 'E'}};
		String b = "SNAKES";
		int n;
		n = Sol_1_my.search(a, b);
		System.out.println(n);
		//

		n = sol_2_my_basedOnWebSolution.search(a, b);
		System.out.println(n);
	}
}
