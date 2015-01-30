/*
Solutions to http://www.careercup.com/question?id=6271724635029504

 */

package google_interview;

public class E403219_sumOfSortedArray {
	public static void main(String[] arg){
		int[] a1 = butil.SortUtil.getArrayRnd(10, 100); 		java.util.Arrays.sort(a1);
		int[] a2 = butil.SortUtil.getArrayRnd(30, 200); 		java.util.Arrays.sort(a2);
		Sol_1 sol = new Sol_1(a1, a2, 60);
		sol.find();
	}//main


	static class Sol_1{//<editor-fold defaultstate="collapsed" desc="">
		int[] a1, a2;
		int n;
		int i1, i2;

		public Sol_1(int[] a1, int[] a2, int n){
			this.a1 = a1;			this.a2 = a2;			this.n = n;
		}

		void find() {
			boolean exist;
			exist = findFromStart();
			if(!exist) exist = findFromEnd();

			if(!exist){
				swap(); exist = findFromStart();
			}
			if(!exist) exist = findFromEnd();

			if(exist)
				findValue();
		}//find

		private void setIndex(int j1, int j2, int v){
			if(v==n){
				i1 = j1+1;
				i2=j2-1;
			}else if(v>n){
				i1 = j1+1;
				i2 = j2-1;
			}else if(OUT_OF_RANGE !=v && v<n){
				i1 = j1+1;
				i2 = j2;
			} else if(v == OUT_OF_RANGE){
				i2=0;
			}
		}

		private void findValue(){
			while(i1<a1.length && 0<=i2){
				int v = calcValue(i1, i2);
				if(v==n){
					i1++;
					i2--;
				}else if(v!=n){
					int k = i2;
					if(v<n){
						while(v<n) {
							v = calcValue(i1, ++k);
							if(v == OUT_OF_RANGE) break;
						}
						setIndex(i1, k-1, v);
					}else{
						while(v>n) {
							v = calcValue(i1, --k);
							if(v < OUT_OF_RANGE) break;
						}
						setIndex(i1, k+1, v);
					}
				}//if
				i1++;
			}//while
		}


		static final int OUT_OF_RANGE = Integer.MIN_VALUE;//only j2 will less than 0
		private int calcValue(int k1, int k2){
			if(k2<0) return OUT_OF_RANGE;

			int result = a1[k1] + a2[k2];
			if(result == n)
				System.out.printf("%d = %d + %d\n", n, a1[k1], a2[k2]);
			return result;
		}

		private boolean findFromStart(){
			i1 = 0;
			i2 = binary(a2, n-a1[i1], true);
			boolean exist = (0<i2 || i2<a2.length);
			return exist;
		}

		private boolean findFromEnd(){
			i2 = a2.length;
			i1 = binary(a1, n - a2[i2-1], false);
			boolean exist = (0<i1 || i1<a1.length);
			return exist;
		}

		private void swap(){
			int[] t = a1; 	a1 = a2;  a2 = t;
		}

		private int binary(int[] a, int n, boolean fromStart){
			int lo = 0, hi = a.length - 1;
			if(n<a[lo]) return -1;
			else if(a[hi]<n) return hi+1;
			while(lo < hi){
				int m = (lo + hi)/2;
				if(a[m]<n) lo = m+1;
				else if(n<a[m]) hi = m - 1;
				else return m;
			}
			if(fromStart) return hi;
			else return lo;
		}//binary
	}//</editor-fold>
}
