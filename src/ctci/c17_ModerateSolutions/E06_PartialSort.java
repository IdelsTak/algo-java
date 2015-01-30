package t17_ModerateSolutions;

/**
 *
 * @author andy
 */
public class E06_PartialSort {
	public static class Range {

		int m;
		int n;

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		@Override
		public String toString() {
			return String.format("(%d, %d)", m, n);
		}
	}

	public static boolean getMinMax(int[] a, Range r) {
		if (r.m > r.n) {
			return false;
		}
		for (int i = r.m; i <= r.n; i++) {
			if (a[i] < r.min) {
				r.min = a[i];
			}
			if (a[i] > r.max) {
				r.max = a[i];
			}
		}
		return true;
	}

	public static Range calc(int[] a) {
		Range r = new Range();
		//look for m
		for (r.m = 1; r.m < a.length; r.m++) {
			if (a[r.m - 1] > a[r.m]) {
				break;
			}
		}
		//look for n
		for (r.n = a.length - 2; r.n > r.m; r.n--) {
			if (a[r.n] > a[r.n + 1]) {
				break;
			}
		}
		System.out.println(r);
		//adjust
		boolean adjusted = true;

		while (adjusted) {
			r.min = Integer.MAX_VALUE;
			r.max = Integer.MIN_VALUE;
			if (!getMinMax(a, r)) {
				break;
			}
			adjusted = false;
			if (r.m >= 1 && r.min < a[r.m - 1]) {
				r.m--;
				adjusted = true;
			}
			if (r.n < a.length - 1 && r.max > r.n + 1) {
				r.n++;
				adjusted = true;
			}
		}
		System.out.println(r);
		return r;
	}

	public static void main(String[] argv) {
		int[] a = {1, 2, 4, 7, 3, 9, 6, 8};
		calc(a);
	}
}
