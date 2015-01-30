/*
 my code is not as clear as book code
 TODO: to rewrite my code in the future
 */
package sort_imp;

public class S7_HeapSort_my extends S0_SortCommon {

	@Override
	void sort(int[] a) {
		heapfy(a);
		sortfy(a);
	}

	//In my algorithm, I exchange with the parent, which is not a good appraoch
	void heapfy(int[] a) {
		int n = a.length;//length
		for (int i = 1; i < n; i++) {
			adjustHeap(a, i);
		}
	}

	void adjustHeap(int[] a, int i) {
		int ai = a[i];//keep the child value
		int p = (i - 1) / 2;//parent
 		while (i != 0 && a[p] < ai) {
			a[i] = a[p];
			i = p;
			p = (i - 1) / 2;
		}
		if (p >= 0 & a[p] < ai) {
			a[p] = ai;
		} else {
			a[i] = ai;
		}
	}

	void sortfy(int[] a) {
		int n = a.length - 1;
		for (int i = n; i >= 0; i--) {
			int tmp = a[i];
			a[i] = a[0];//put the mast value to last position
			a[0] = tmp;
			int lastMovedPos = normalize(a, 0, i - 1);
			a[lastMovedPos] = tmp;
		}
	}

	//get max child of node i
	int normalize(int[] a, int i, int lastPos) {
		if (2 * i + 1 > lastPos) {//if there is not children in the range
			return i;
		}

		int lValue = getChildValue(a, 2 * i + 1, lastPos);
		int rValue = getChildValue(a, 2 * i + 2, lastPos);
		int moveUpIdx = i;
		int ai = a[i];
		if (lValue > rValue && lValue > ai) {
			moveUpIdx = 2 * i + 1;
		} else if (rValue > lValue && rValue > ai) {
			moveUpIdx = 2 * i + 2;
		} else {//equal, move any of them
			if (lValue > ai) {
				moveUpIdx = 2 * i + 1;
			}
		}
		if (moveUpIdx != i) {//no value to move up
			a[i] = a[moveUpIdx];
			moveUpIdx = normalize(a, moveUpIdx, lastPos);
		}
		return moveUpIdx;
	}

	int getChildValue(int[] a, int i, int lastPos) {
		int value = Integer.MIN_VALUE;
		if (i <= lastPos) {
			value = a[i];
		}
		return value;
	}
}
