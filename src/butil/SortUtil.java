/*

 */
package butil;

import java.util.ArrayList;

public class SortUtil {

	// <editor-fold defaultstate="collapsed" desc="Swap">
	public static void swap(int[] a, int i, int j) {
		if (i != j) {
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}

	public static <T> void swap(T[] a, int i, int j) {
		if (i != j) {
			T tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}

	public static void swap(char[] a, int i, int j) {
		if (i != j) {
			char tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}// </editor-fold>


	// <editor-fold defaultstate="collapsed" desc="getArray">
	public static int[] getArray() {
		return getArray(30);
	}

	public static int[] getArray(int n) {
		if(n<=10){
			int[] a = {7, 4, 9, 1, 6, 3, 5, 8, 2, 0};
			return a;
		}else if(n<=20){
			int[] c = {17, 7, 13, 4, 10, 9, 0, 12, 11, 1, 15, 6, 16, 3, 19, 5, 18, 8, 14, 2};
			return c;
		}else if(n<=30){
			int[] d = {13, 4, 27, 28, 25, 17, 10, 7, 20, 12, 24, 15, 19, 5, 18, 6, 16, 21, 11, 1, 0, 23, 3, 9, 8, 22, 14, 2, 26, 29};
			return d;
		}else if(n<=60){//60
			int[] d = {33, 51, 38, 13, 46, 59, 4, 52, 30, 27, 32, 43, 25, 47, 42, 36, 17, 41, 10, 49, 7, 20, 48, 12, 58, 24, 15, 50, 19, 5, 18, 40, 6, 37, 53, 16, 45, 21, 39, 11, 35, 54, 1, 0, 55, 23, 3, 9, 56, 8, 22, 44, 14, 57, 2, 26, 31, 28, 34, 29};
			return d;
		}else{
			return getArrayRnd(0,n);
		}
	}

	public static int[] getArrayRnd(int lo, int hi){
		Integer[] A = getArrayRndObj(lo, hi);
		int[] a = new int[hi-lo];
		for(int i = 0; i<hi-lo; i++){
			a[i] = A[i];
		}
		return a;
	}
	public static Integer[] getArrayRndObj(int lo, int hi){
		ArrayList<Integer> al = new ArrayList<>(hi);
		for(int i = lo; i<hi; i++) al.add(i);
		java.util.Collections.shuffle(al);
		Integer[] a = new Integer[al.size()];
		al.toArray(a);
		return a;
	}//</editor-fold>
}
