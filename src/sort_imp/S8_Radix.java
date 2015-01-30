/* the training video is very nice by this author @ https://www.youtube.com/watch?v=dHeTp6hO71U
 */
package sort_imp;

/**
 *
 * @author andy
 */
public class S8_Radix extends S0_SortCommon {

	private static final int W = 5;
	private static final int R = 10;

	@Override
	void sort(int[] a) {
		for (int d = 0; d < W; d++) {
			sort(a, d);
		}
	}

	//d is the location of the data
	void sort(int[] a, int d) {
		int digit, ai;
		// set the counter
		int[] c = new int[R];
		for (int i = 0; i < a.length; i++) {
			ai = a[i];
			digit = digit_d_of_x(d, a[i]);
			++c[digit];
		}
		for (int i = 1; i < R; i++) {
			c[i] += c[i - 1];
		}
		//add the data to tmp
		int[] tmp = new int[a.length];
		for (int i = a.length - 1; i >= 0; i--) {
			digit = digit_d_of_x(d, a[i]);
			tmp[--c[digit]] = a[i];
		}
		//copy back to tmp
		for (int i = 0; i < a.length; i++) {
			a[i] = tmp[i];
		}
	}

	int digit_d_of_x(int d, int x) {
		return ((int) (x / Math.pow(R, d))) % R;
	}

	@Override
	int[] getArray() {//get the data from https://www.youtube.com/watch?v=dHeTp6hO71U
		int[] a = {7125, 120, 21171, 31975, 73641, 60433};
		return a;
	}

}
