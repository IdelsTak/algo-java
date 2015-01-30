/*
Solutions to  http://www.careercup.com/question?id=5680043955060736
Output top N positive integer in string comparison order. For example, let's say N=1000, then you need to output in string comparison order as below:
1, 10, 100, 1000, 101, 102, ... 109, 11, 110, ...
 */

package google_interview;

import static google_interview.E40715_ComparisonOrder.Sol_1_MSD.aux;
import java.util.Stack;

/*
Sol_1:
*/
public class E40715_ComparisonOrder {
	//compare with msd
	public static class Sol_1_MSD{//<editor-fold defaultstate="collapsed" desc="comment">
		static int[] r;
		static int[] aux;

		private static void init(int[] a){
			//set the radix
			r = new int[11];	r[0] = 1;
			for(int i = 1; i<r.length; i++) r[i] = r[i-1]*10;
			//aux
			aux = new int[a.length];
		}

		static void sort(int[] a){
			init(a);
			sort(a, 0, a.length-1, 0);
		}

		static void sort(int[] a, int lo, int hi, int n){
			if(lo>=hi) return;
			//count
			int[] counter = new int[10+2];//-1, 0, 1, ..., 0
			for(int i = lo; i<=hi; i++){
				int dig = getDigit(a[i], n);
				counter[dig+2]++;
			}
			for(int i = 1; i<counter.length;i++) counter[i]+= counter[i-1];
			//
			if(counter[0]==(hi-lo+1)) return;
			for(int i = lo; i<=hi; i++){
				int dig = getDigit(a[i], n);
				aux[lo+counter[dig+1]++] = a[i];
			}
			//copy back
			for(int i = lo; i<=hi; i++) a[i] = aux[i];
			//sort the sub array
			for(int i = 1; i<counter.length - 1; i++){
				int low = lo+counter[i-1];
				int hig = lo+counter[i]-1;
				sort(a, low, hig, n+1);
			}
		}

		//get the highest digit from left to right
		static int getDigit(int data, int n){
			int digits = (int)Math.log10(data) - n;
			if(digits<0) return -1;
			else{
				return((data/r[digits])%10);
			}
		}
	}//</editor-fold>

	//convert to string, sort, convert back
	public static class Sol_2_PQ{//<editor-fold defaultstate="collapsed" desc="comment">
		static void sort(int[] a){
			String[] as = new String[a.length];
			for(int i = 0; i<a.length; i++){
				as[i] = String.valueOf(a[i]);
			}
			java.util.Arrays.sort(as);
			System.out.println(java.util.Arrays.toString(as));
		}
	}//</editor-fold>

	public static class Sol_3_Trie{//<editor-fold defaultstate="collapsed" desc="comment">

		static class Node{//<editor-fold defaultstate="collapsed" desc="comment">
			Node prev;
			Node next;
			Node child;
			int digit;
			int val = Integer.MIN_VALUE;
			public Node(int digit){
				this.digit = digit;
			}

			public static Node getNode(Stack<Integer> stack, int d){
				if(stack.isEmpty()) return null;
				int digit = stack.pop();
				Node root = new Node(digit);
				if(stack.isEmpty()) root.val = d;

				root.child = getNode(stack, d);
				return root;
			}

			private static Stack<Integer> getStack(int d){
				Stack<Integer> s = new Stack<>();
				while(d>0){
					s.push(d%10); d /= 10;
				}
				return s;
			}
		}//</editor-fold>

		static Node addValue(Node r, Stack<Integer> stack, int d){
			if(r==null) {
				r= Node.getNode(stack, d);
				return r;
			}
			int digit = stack.peek();
			if(digit == r.digit){
				stack.pop();
				if(stack.isEmpty())
					r.val = d;//let's support there are no duplicate
				else
					r.child = addValue(r.child, stack, d);
			}else if(digit < r.digit){
				if(r.prev!=null && r.prev.digit < digit){
					Node tmp = Node.getNode(stack, d);
					tmp.prev = r.prev;
					r.prev = tmp;
				}else
					r.prev = addValue(r.prev, stack, d);
			}else{ //r.val < digit
				if(r.next!=null && digit<r.next.digit){
					Node tmp = Node.getNode(stack, d);
					tmp.next = r.next;
					r.next = tmp;
				}else
					r.next = addValue(r.next, stack, d);
			}
			return r;
		}

		static Node addValue(Node r, int d){
			Stack<Integer> stack = Node.getStack(d);
			r = addValue(r, stack, d);
			return r;
		}


		static Node createTree(int[] a){
			Node r = null;
			for(int i = 0; i<a.length; i++)
				r = addValue(r, a[i]);
			return r;
		}

		static void inOrderTrav(Node r){
			if(r==null) return;
			inOrderTrav(r.prev);
			if(r.val != Integer.MIN_VALUE)
				System.out.printf(", %d", r.val);
			inOrderTrav(r.child);
			inOrderTrav(r.next);
		}

		static void sort(int[] a){
			Node r = createTree(a);
			inOrderTrav(r);
		}
	}//</editor-fold>


	public static void main(String[] arg){

		int[] a1 = {210, 1, 11, 1000, 100, 101, 765, 102, 109, 10, 110, 431};
		System.out.printf("Length = %d\n", a1.length);
		//solution 1:
		Sol_1_MSD.sort(a1);
		butil.Print.intArrayPrint(a1);
		//solution 2:
		int[] a2 = {210, 1, 11, 1000, 100, 101, 765, 102, 109, 10, 110, 431};
		Sol_2_PQ.sort(a2);
		//solution 3
		int[] a3 = {210, 1, 11, 1000, 100, 101, 765, 102, 109, 10, 110, 431};
		Sol_3_Trie.sort(a3);
	}
}
