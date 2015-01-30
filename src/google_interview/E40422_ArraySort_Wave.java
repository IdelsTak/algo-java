/*
Solutions to http://www.careercup.com/question?id=5145759489982464

 Given an array of integers, sort the array into a wave like array, namely
 a1 >= a2 <= a3 >= a4 <= a5
 */
package google_interview;

import butil.SortUtil;

public class E40422_ArraySort_Wave {

	public static class Sol_1_my_EasySolution {

		public static void waveSort(int[] a) {
			java.util.Arrays.sort(a);
			for (int i = 0; i < a.length / 2; i++) {
				int tmp = a[2 * i];
				a[2 * i] = a[2 * i + 1];
				a[2 * i + 1] = tmp;
			}
			System.out.println(java.util.Arrays.toString(a));
		}
	}


	public static class Sol_2_my_Normal {
		public static void waveSort(int[] a) {
			boolean GE = true;
			for (int i = 0; i < a.length - 1; i++) {
				if (GE && (a[i] < a[i + 1])	|| !GE && (a[i] > a[i + 1])) {
					int tmp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = tmp;
				}
				GE = !GE;
			}//for
			System.out.println(java.util.Arrays.toString(a));
		}//method
	}

	public static void main(String[] argc) {//int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] a1 = SortUtil.getArray(30);//{9, 7, 1, 3, 4, 6, 8, 5, 2};		int[] a2 = SortUtil.getArray(30);//{1, 2, 3, 4, 5, 6, 7, 8};

		System.out.println("Sort method");
		Sol_1_my_EasySolution.waveSort(a1);		//Sol_1_my_EasySolution.waveSort(a2);

		int[] a3 = SortUtil.getArray(30);//{9, 7, 1, 3, 4, 6, 8, 5, 2};		//int[] a4 = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println("Swap method");
		Sol_2_my_Normal.waveSort(a3);		//Sol_2_my_Normal.waveSort(a4);
		//butil.SortUtil.getArray();
	}
}

