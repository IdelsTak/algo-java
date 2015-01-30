package butil;

import java.util.Collection;
import java.util.Iterator;

public class Print {
	private static <T> int getListSize(Iterable<T> list) {
		int size = 0;
		Iterator<T> iter = list.iterator();
		if (iter != null) {
			size++;
		}
		while (iter.hasNext()) {
			size++;
			iter.next();
		}
		return size;
	}

	public static <T> void printList(Iterable<T> list, boolean isBreakLine) {
		//print list size
		int size = getListSize(list);
		System.out.printf("============== List Size: %d ===============", size);
		//print list content
		String str;
		for (T t : list) {
			str = t.toString();
			str += " ";
			if (isBreakLine) {
				System.out.println(str);
			} else {
				System.out.print(str);
			}
		}
		System.out.println("");
	}

	public static <T> void printListLn(Iterable<T> list) {
		printList(list, true);
	}

	public static <T> void printList(Iterable<T> list) {
		printList(list, false);
	}

	public static <T> String listToString(Collection<T> list) {
		int size = list.size();
		System.out.printf("============== List Size: %d ===============", size);
		String str = "";
		for (T t : list) {
			str += t.toString() + "";
		}
		return str;
	}

	public static void intArrayPrint(int[] a) {
		System.out.println(java.util.Arrays.toString(a));
	}

	public static void intArrayPrint(int[][] a) {
		System.out.println("");
		for (int[] b : a) {
			intArrayPrint(b);
		}
	}

	public static void stringArrayPrint(String[] a) {
		System.out.println(java.util.Arrays.toString(a));
	}

	//<editor-fold defaultstate="collapsed" desc="matrix">
	public static void matrix(char[][] a){
		int M = a.length;
		int N = a[0].length;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%3c", a[i][j]);
			}
			System.out.println();
		}
	}

	public static void matrix(int[][] a){
		int M = a.length;
		int N = a[0].length;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%3d", a[i][j]);
			}
			System.out.println();
		}
	}//</editor-fold>
}
