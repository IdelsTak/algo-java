/*
Solutions to http://www.careercup.com/question?id=5644198027984896

if both negative and positive, then N^2/2
else:

O(N^2)/2 is the only solution
 */
package google_interview;

import java.util.Stack;

/*
TODO:
	have given two solution, but have some small issue
*/
public class E40321_SubSeq_in_Range {
	//int num = 0, steps = 0;
	//int lo = 40000, hi = 40020, N = 1000;
	static int lo = 500, hi = 514, N = 60;

	static int[][] numStep = new int[3][2];
	static int NUM = 0, STEP = 1;
	static int algo;
	boolean ISDEBUGMODE = true;
	boolean isSumChanged = false;

	public static void main(String[] arg){
		int[] a = butil.SortUtil.getArray(N);		//System.out.println(java.util.Arrays.toString(a));
		E40321_SubSeq_in_Range runner=new E40321_SubSeq_in_Range();

		runner.run1(a, lo, hi);System.out.println("\n");
		algo++; runner.run2_DBG(a, lo, hi);
		//algo++; run3_SameAsPrev_MoreVerbose(a, lo, hi);

		for(int algor = 0; algor<numStep.length; algor++)
			System.out.printf("\n num = %d, steps = %d",
				numStep[algor][NUM], numStep[algor][STEP]);
		System.out.println();
	}

	Stack<String> stack = new Stack<>();
	void run2_DBG(int[] a, int lo, int hi){//<editor-fold defaultstate="collapsed" desc="comment">
		int i = 0, j = -1, sum = 0;
		while(i<N){
			int oldI = i;
			while(j<N){		//print all list from a[i]
				int oldJ = j;
				while(sum < hi && j<N-1){
					if(j!=-1 && lo < sum && sum < hi)
						print(a, i, j, sum, "F");
					sum = addS(sum, a[++j]);
				}

				if(i<N){//<editor-fold defaultstate="collapsed" desc="moveBack">
					stack.clear();
					sum = subS(sum, a[i++]);
					int sum1 = sum, j1 = j;
					while(hi<=sum1)
						sum1 = subS(sum1, a[j1--]);

					for(; lo < sum1 && sum1 < hi && i<=j1; sum1 = subS(sum1, a[j1--]))
						print(a, i, j1, sum1, "B", stack);

					print(stack);
				}//</editor-fold>
				if(oldJ == j){j++; if(j<N-1) sum = addS(sum, a[j]);}
			}//while j
			if(oldI == i){if(i<N) sum = subS(sum, a[i]);	i++;}
		}//for
	}//</editor-fold>

	//suppose all is >0
	void run3_SameAsPrev_MoreVerbose(int[] a, int lo, int hi){//<editor-fold defaultstate="collapsed" desc="comment">
		int i = 0, j = 0, sum = a[0];
		while(i<N){
			int oldI = i;
			while(j<N){		//print all list from a[i]
				int oldJ = j;
				while(sum<=lo && j<N-1)
					sum = addS(sum, a[++j]);

				while((lo < sum && sum < hi) && j<N-1){
					print(a, i, j, sum, "F");
					sum = addS(sum, a[++j]);
				}
				if(i<N){//<editor-fold defaultstate="collapsed" desc="moveback">
					sum = subS(sum, a[i++]);
					int sum1 = sum, j1 = j;
					while(hi<=sum1) {
						sum1 = subS(sum1, a[j1--]);
					}
					for(; lo < sum1 && sum1 < hi && i<=j1; sum1 -= a[--j1]) {
						print(a, i, j1, sum1,"B");
					}
				}//</editor-fold>
				if(oldJ == j){j++; if(j<N-1) sum = addS(sum, a[j]);}
			}//while j
			if(oldI == i){if(i<N) sum = subS(sum, a[i]);	i++;}
		}//for
	}//</editor-fold>


	void run1(int[] a, int lo, int hi){
		for(int i = 0; i<N; i++){
			int sum = 0;
			for(int j = i; j<N; j++){
				sum = addS(sum, a[j]);
				if(lo < sum && sum < hi)
					print(a, i, j, sum, "F");
				else if ( hi<=sum) break;
			}//for
		}//for
	}//run


	int addS(int a, int b){
		isSumChanged = true;
		numStep[algo][STEP]++;
		return a+b;
	}

	int subS(int a, int b){
		isSumChanged = true;
		numStep[algo][STEP]++;
		return a-b;
	}

	String getStr(int[] a, int i, int j, int sum, String dir){
		if(ISDEBUGMODE && isSumChanged){
			numStep[algo][NUM]++;
			//				  dir num  len start-end  sum
			String str = String.format("%s%3d, (%2d)%3d-%3d = %d : ", dir, numStep[algo][NUM], j-i+1, i, j, sum);
			for(int k = i; k<=j; k++) str += String.format("+%d", a[k]);
			str += "\n";
			isSumChanged = false;
			return str;
		}else{
			return null;
		}
	}

	void print(int[] a, int i, int j, int sum, String dir, Stack<String> stack){
		String str = getStr(a, i, j, sum, dir);
		if(str!=null) stack.push(str);
	}

	void print(Stack<String> stack){
		while(!stack.isEmpty())
			System.out.print(stack.pop());
	}

	void print(int[] a, int i, int j, int sum, String dir){
		String str = getStr(a, i, j, sum, dir);
		if(null!=str)	System.out.print(str);
	}

}
