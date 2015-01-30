/*
Solutions to  http://www.careercup.com/question?id=5171150330003456

Given k integers i_0, i_1, i_2, i_3,...i_k,
 find all possible expressions which uses
 + - * / and () to generate a result equals to target X.
 () has the highest priority.
 */

package google_interview;

import butil.WrapInt;
import java.util.ArrayList;
import java.util.Arrays;

/* This is only part of solution
		To find all combination

andy:
	1. find all combinations, without ()
	2. add ( )
	3. calculate
*/
public class E40321_expr_allCombination {

	public static void main(String[] arg) {//char[] digt = {'1', '2', '3', '4', '5', '6'};
		int[] digt = {1, 2, 3, 4, 5, 6};
		ArrayList<Integer> a = new ArrayList(digt.length);
		char[] oper = "+-*/".toCharArray();
		//step 1: all combination			//Sol.allCombination(Arrays.copyOf(digt, digt.length), digt.length, new WrapInt());
		//step 2: calc all form {1 -- 6} and +-*/ ()
			//only test:
			Sol.calc(digt, oper, 24);
	}

	static class Sol{

		public static void calc(int[] a, char[] oper, int X){
			ArrayList<Integer> ai = getList(a);
			ArrayList<String> as = getListStr(a);
			calc(ai, as, oper, X, new WrapInt());
		}

		public static void calc(ArrayList<Integer> a, ArrayList<String> f,
			char[] oper, int X, WrapInt wi){

			if(a.size() == 1){
				if(a.get(0) == 24){
					wi.n++;
					System.out.printf("%d : %d == %s\n",wi.n++, X, f);
				}
				return;
			}
			for(int i = 0; i<a.size()-1; i++){
				for(int j = 0; j<oper.length; j++){
					ArrayList<Integer> a0 =(ArrayList<Integer>) a.clone();
					ArrayList<String> f0 = (ArrayList<String>)f.clone();
					a0.set(i, butil.Calc.Int(a0.get(i), oper[j], a0.get(i+1)));
					f0.set(i, String.format("(%s%c%s)", f0.get(i), oper[j], f0.get(i+1)));
					a0.remove(i+1);
					f0.remove(i+1);
					calc(a0, f0, oper, X, wi);
				}
			}
		}

		//list of all combination in different order
		public static void allCombination(int[] a, int n, WrapInt wi){
			if(n==0) {
				wi.n++;
				System.out.print(wi.n);
				butil.Print.intArrayPrint(a);
				return;
			}
			for(int i = 0; i<n; i++){
				int[] b = Arrays.copyOf(a, a.length);
				butil.SortUtil.swap(b, i, n-1);
				allCombination(b, n-1, wi);
			}
		}

		public static ArrayList<Integer> getList(int[] a){
			ArrayList<Integer> al = new ArrayList<>(a.length);
			for(int i : a) al.add(i);
			return al;
		}

		public static ArrayList<String> getListStr(int[] a){
			ArrayList<String> al = new ArrayList<>(a.length);
			for(int i : a) al.add(String.valueOf(i));
			return al;
		}
	}


	static class Sol_1_allComb_practise{//<editor-fold defaultstate="collapsed" desc="comment">
		public static void run(char[] digt, char[] oper, int x){
			char[] expr = new char[digt.length * 2 - 1];
			//fill in digits
			for(int i = 0; i<digt.length; i++)
				expr[2*i] = digt[i];

			butil.WrapInt wi = new butil.WrapInt();
			run(expr, oper, 1, wi);
			System.out.println(wi.n);
		}

		public static void run(char[] expr, char[] oper,
			int n, butil.WrapInt wi){

			if(n > expr.length-1){
				wi.n++;
				System.out.println(String.valueOf(expr));
				return;
			}
			expr[n] = '+';
			run(expr, oper, n+2, wi);
			expr[n] = '-';
			run(expr, oper, n+2, wi);
			expr[n] = '*';
			run(expr, oper, n+2, wi);
			expr[n] = '/';
			run(expr, oper, n+2, wi);
		}
	}//</editor-fold>

}
