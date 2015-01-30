package google_interview;

/*
 */

/**
 *
 * @author andy
 */
public class CLRS_P29_insertion {
	public static void main(String[] arg){
		int a[] = butil.SortUtil.getArray();
		butil.Print.intArrayPrint(a);
		sort(a);
		butil.Print.intArrayPrint(a);
	}

	public static void sort(int[] a){
		int N = a.length;
		for(int i = 1; i<N; i++){
			int key = a[i], j = i-1;
			for(; j>=0 && a[j]>key; j--)
				a[j+1] = a[j];
			a[j+1] = key;
		}
	}
}
