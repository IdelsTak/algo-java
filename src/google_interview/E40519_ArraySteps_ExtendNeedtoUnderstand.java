/*
Solutions to http://www.careercup.com/question?id=5677781199355904

 Find minimum number of steps to reach the end of array from start (array value shows how much you can move).
 Comment: this problem is not clear, when working on an test, first understand fully.
 */
/*
https://github.com/rohitsinha54/ArrayHopper
http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
http://stackoverflow.com/questions/23301358/linear-time-algorithm-for-minimum-number-of-jumps-required-to-reach-end
 there is some problem with this test, maybe it is array hopper issue, like:

Problem: Minimum number of jumps to reach end

Given an array of integers where each element represents the max number of steps
that can be made forward from that element. Write a function to return
the minimum number of jumps to reach the end of the array
(starting from the first element). If an element is 0,
then cannot move through that element.

Example:

Input:
    arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output:
    3 (1-> 3 -> 8 ->9)

    First element is 1, so can only go to 3.
    Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.

 */
package google_interview;

import java.util.ArrayList;
import java.util.LinkedList;

public class E40519_ArraySteps_ExtendNeedtoUnderstand {

	public static class Sol_1_graphTraverse {//<editor-fold defaultstate="collapsed" desc="comment">

		public static class Pos {

			int pos;
			int maxStep;

			public Pos(int pos, int maxStep) {
				this.pos = pos;
				this.maxStep = maxStep;
			}
		}

		public static Iterable<Integer> run(int[] a) {//<editor-fold defaultstate="collapsed" desc="comment">
			System.out.println("Tree Solution");
			int N = a.length;
			int[] pathTo = new int[N + 1];			//for (int i = 0; i <= N; i++)				pathTo[i] = -1;
			boolean[] visited = new boolean[N];

			LinkedList<Pos> queue = new LinkedList<>();
			queue.addLast(new Pos(0, a[0]));

			while (!queue.isEmpty()) {
				Pos p = queue.removeFirst();
				for (int i = p.maxStep; i > 0; i--) {
					int nextPos = p.pos + i;
					if (nextPos >= N) {//<editor-fold defaultstate="collapsed" desc="find the result">
						LinkedList<Integer> s = new LinkedList<>();
						for (int j = p.pos; j != 0; j = pathTo[j])
							s.addFirst(j);
						s.addFirst(0);
						return s;
					}//</editor-fold>
					else if (!visited[nextPos]) {
						visited[nextPos] = true;
						pathTo[nextPos] = p.pos;
						queue.addLast(new Pos(nextPos, a[nextPos]));
					}
				}
			}
			return null;
		}//</editor-fold>
	}//</editor-fold>

	public static class Sol_2_recusiveCall {//<editor-fold defaultstate="collapsed" desc="comment">

		public static void run(int[] a){
			System.out.println("recursive");
			int steps = run(a, 0);
			System.out.printf("\nsteps %d", steps);
		}

		static int run(int[] a, int start){
			if(start + a[start] >= a.length) return 1;
			else{
				int minSteps = Integer.MAX_VALUE;
				int minStepsIndex = -1;
				for(int i = a[start]+start; i>=start+1; i--) {
					int curStep = run(a, i);
					if(curStep<minSteps){
						minStepsIndex = i;
						minSteps = curStep;
					}
				}//for
				if(minStepsIndex>0) {
					System.out.printf("%d: %d --> %d \n", minSteps, start, minStepsIndex);
				}
				return minSteps == Integer.MAX_VALUE? Integer.MAX_VALUE : minSteps + 1;
			}//if
		}
	}//</editor-fold>

	public static class Sol_3_mostEfficient {//<editor-fold defaultstate="collapsed" desc="comment">

		public static ArrayList<Integer> run(int[] a) {
			ArrayList<Integer> hops = new ArrayList<>();
			int lReach = 0;   //last index already saved in path
			int selIndex = 0; //the index to reach to curReach
			int curReach = 0; //by current i, the furthest distance reached
			int i;
			for (i = 0; i < a.length; i++) {
				if (i > curReach) break;  //means can not reach here
				if (i > lReach) {
					lReach = curReach; // update last reach
					hops.add(selIndex);
				}

				int sum = i + a[i];
				if (sum > curReach){//the distance and how to reach the current position
					selIndex = i;
					curReach = sum;
				}	//curReach = curReach;
			}

			if ((i > lReach) && (hops.size() > 0) && (hops.get(hops.size() - 1) != selIndex)) {
				// if i was beyond last reach and hops are present then add the last selected index
				hops.add(selIndex);
			}

			if (lReach >= a.length - 1)
                            // if last reachable index was greater than or equal to last index of array
				return hops;// then return the hop indices as hopping is possible
			else
				return null;
		}
	}//</editor-fold>

	public static class Sol_4_dynamicProgramming{
		//from http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
		int minJumps(int[] a){
			int[] jumps = new int[a.length];
			int n = a.length;
			int i, j;
			if(n==0 || a[0]==0) return Integer.MAX_VALUE;
			jumps[0] = 0;
			//find the minimum number of jumps to reach arr[i] from arr[0],
			//and assign this value to jump[i]
			for(i=1; i<n; i++){
				jumps[i] = Integer.MAX_VALUE;
				for(j = 0; j<i;j++)
					if(j+a[j]<=i && jumps[j] != Integer.MAX_VALUE && jumps[j]+1<jumps[i])
						jumps[i] = jumps[j]+1;
			}
			return jumps[n-1];
		}
	}

	public static void main(String[] arg) {		//  int[] a = {1, 1, 2, 3, 4, 5, 6, 7, 8, 9};		//  int[] a = {3, 9, 0, 1, 2, 4, 1, 0, 0, 4};
		  int[] a = {5, 2, 2, 1, 2, 4, 1, 0, 0, 4};		//int[] a = {5, 6, 0, 4, 2, 4, 1, 0, 0, 4};

		//solution 1
		Iterable<Integer> steps1 = Sol_1_graphTraverse.run(a);
		butil.Print.printList(steps1);

		//solution 2
		//Sol_2_recusiveCall.run(a);

		Iterable<Integer> steps2 = Sol_3_mostEfficient.run(a);
		butil.Print.printList(steps2);
	}

}