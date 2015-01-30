/*
Solutions to http://www.careercup.com/question?id=5636238631501824
 Code for computing a^b and optimize it.
 */
package google_interview;

/**
 *
 * @author andy
 */
public class E40425_Pow {

	public static void main(String[] argv) {
		System.out.printf("Sol_1 %d", Sol_1_myMultiply.multiply(7, 9));
		System.out.printf("Sol_2 %d", Sol_2_myMultiply.multiply(7, 9));
	}

	//Time complicity O(n)
	public static class Sol_1_myMultiply {//<editor-fold defaultstate="collapsed" desc="comment">
		static long multiply(int m, int n) {
			long result = 1;
			for (long i = 0; i < n; i++)
				result *= m;
			return result;
		}
	}//</editor-fold>

	public static class Sol_2_myMultiply {

		//Time complicity O(log(n))
		static int multiply(int m, int n) {
			if (n == 0) {
				return 1;
			}
			if (n == 1) {
				return m;
			}
			int half = n / 2;
			int mHalf = multiply(m, half);
			if (n % 2 == 0) {
				return mHalf * mHalf;
			} else {
				return m * mHalf * mHalf;
			}
		}
	}

	public static class Sol_3_dynamicProgramming {
		static long multiply(int m, int n) {
			long[] memo = new long[n + 1];
			return multiply(m, n, memo);
		}

		static long multiply(int m, int n, long[] memo) {
			if (n == 0) {
				return 1;
			}
			if (n == 1) {
				return m;
			}
			if (memo[n] != 0) {
				return memo[n];
			}
			int half = n / 2;
			memo[half] = multiply(m, n, memo);
			if (n % 2 == 0) {
				memo[n] = memo[half] * memo[half];
			} else {
				memo[n] = memo[half] * memo[half] * m;
			}
			return memo[n];
		}
	}

	public static class Sol_4_noIterative {
		static long multiply(int m, int n) {
			int[] halfs = new int[n];
			int nHalfs = 0;
			int tmp = n;
			while (tmp >= 2) {
				tmp /= 2;
				halfs[nHalfs] = tmp;
			}
			long result = 1;
			for (int i = nHalfs - 1; i >= 0; i--) {
				if (halfs[i] % 2 == 0) {
					result = result * result;
				} else {
					result = m * result * result;
				}
			}
			return result;
		}
	}//
}
