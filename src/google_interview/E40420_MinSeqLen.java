/*
Solutions to  http://www.careercup.com/question?id=5653018213089280
 Determine minimum sequence of adjacent values in the input parameter array that is greater than input parameter sum.

 Eg
 Array 2,1,1,4,3,6. and Sum is 8
 Answer is 2, because 3,6 is minimum sequence greater than 8.
 */

package google_interview;

public class E40420_MinSeqLen {
	public static void main(String[] arg){
		int[] a = {2,1,1,4,3,6};
		int minLen = minLen(a);
		System.out.println(minLen);
	}

	static int minLen(int[] a){
		int minLen = Integer.MAX_VALUE;
		int SUM = sum(a), N = a.length;
		int s=0, e=-1, sum = 0;
		while(e+1<N){
			sum += a[++e];
			//make the len as short as possible while keep larger
			while(s<e && 2*sum-a[s]>SUM) sum -= a[s++];
			if(2*sum>SUM && (e-s+1)<minLen) minLen = e-s+1;
		}
		return minLen;
	}

	static int sum(int[] a){
		int sum = 0;
		for(int i : a){
			sum += i;
		}
		return sum;
	}
}
