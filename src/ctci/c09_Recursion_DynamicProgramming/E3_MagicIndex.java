/*
 */
package t09_Recursion_DynamicProgramming;

/**
 */
public class E3_MagicIndex {

	int find_slow(int a[]) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == i) {
				return i;
			}
		}
		return -1;
	}

	int find_log(int[] a) {
		int l = 0,
			h = a.length - 1,
			m = (l + h) / 2;
		while (l <= h) {
			if (a[m] == m) {
				return m;
			} else if (m > a[m]) {
				l = m + 1;
			} else {
				h = m - 1;
			}
		}
		return -1;
	}

	int find_log_bk(int[] a, int l, int h) {
		if (l > h) {
			return - 1;
		}
		int m = (l + h) / 2;
		if (m == a[m]) {
			return m;
		} else if (m > a[m]) {
			l = m + 1;
		} else {
			h = m - 1;
		}
		return find_log_bk(a, l, h);
	}

	//TODO: Book 320: Follow: don't understand the code.
}
