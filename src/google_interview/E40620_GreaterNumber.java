/*
Solutions to http://www.careercup.com/question?id=5094709806497792

Given an unsorted array of integers, you need to return maximum possible n such that the array consists at least n values greater than or equals to n. Array can contain duplicate values.
Sample input : [1, 2, 3, 4] -- output : 2
Sample input : [900, 2, 901, 3, 1000] -- output: 3


Sol 1:
	sort the array: O(NlogN)
	iterate from last item

Sol 2:
	partial sort:  [d<=0  1~N  d>M]
	go through 1~M Part
 */

package google_interview;

/**
 *
 * @author andy
 */
public class E40620_GreaterNumber {
	/*Lets say the array has M numbers. For the purpose of this problem, negative values and 0s are irrelevant. Also, numbers larger than M can be treated as M because the answer is never larger than M.

So, we can count the number of existing values between 1 and M. Then, process the values backwards (M to 1) to find the answer, adding the counts of the values processed so far.

This yields an O(M) algorithm with extra O(M) memory.
	*/
	public static int count(int[] a){
		int N = a.length;
		int[] m = new int[N+1];
		for(int i : a){
			if(i>=N) m[N]++;
			else if(i>=0) m[i]++;
		}

		int am = 0;
		for(int i = N; i>0; i--){
			am += m[i];
			if(am>=i) return i;
		}
		return 0;
	}
}
