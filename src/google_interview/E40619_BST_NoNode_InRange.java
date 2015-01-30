/*
Solutions to  http://www.careercup.com/question?id=5165570324430848

 */

package google_interview;

import butil.WrapInt;

public class E40619_BST_NoNode_InRange {
    private static class Node {
        private int key;           // sorted by key
        //private int val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

		public Node(int key, int N) {        //public Node(int key, int val, int N) {
            this.key = key;            //this.val = val;
            this.N = N;
        }
    }

	public static void main(String[] arg){
		int[] a = butil.SortUtil.getArray(30);
		Node d = createBST(a);
		WrapInt w1 = new WrapInt();
		Sol_1.count(d, 3, 9, w1);
		WrapInt w2 = new WrapInt();
		Sol_2.count(d, 3, 9, w2);
		WrapInt w3 = new WrapInt();
		Sol_3.count(d, 3, 9, w3);
		System.out.println(w1.n);
		System.out.println(w2.n);
		System.out.println(w3.n);
	}

	private static Node createBST(int[] a){
		Node root = null;
		for(int i : a){
			root = createNode(root, i);
		}
		return root;
	}
	private static Node createNode(Node root, int i){
		if(root == null) root = new Node(i, 1);
		else if(i<=root.key) root.left = createNode(root.left, i);
		else root.right = createNode(root.right, i);
		root.N = getN(root.left) + getN(root.right) + 1;
		return root;
	}
	private static int getN(Node root){
		if(root == null) return 0;
		else return root.N;
	}

	public static class Sol_1{//brute force
		static void count( Node r, int lo, int hi, WrapInt w){
			if(r == null) return;
			if(lo<=r.key && r.key<=hi) w.n++;
			count(r.left, lo, hi, w);
			count(r.right, lo, hi, w);
		}
	}//Sol_1

	public static class Sol_2{//make use of the knowledge that this is BST
		//this method has not used up the additional information
		static void count( Node r, int lo, int hi, WrapInt w){
			if(r== null) return;
			if(r.key<lo) count(r.right, lo, hi, w);
			else if(hi<r.key) count(r.left, lo, hi, w);
			else{
				count(r.left, lo, hi, w);
				count(r.right, lo, hi, w);
				w.n++;
			}
		}
	}//Sol_2

	public static class Sol_3{
		static void count( Node r, int lo, int hi, WrapInt w){
			count(r, lo, hi, w, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		static void count( Node r, int lo, int hi, WrapInt w, int tLo, int tHi){
			if(r == null) return;
			if(lo <= tLo && tHi <= hi) {
				w.n += r.N;
			}else if(!(tHi <lo || hi<tLo)){
				if(lo <= r.key && r.key<=hi) w.n++;
				count(r.left, lo, hi, w, tLo, r.key);
				count(r.right, lo, hi, w, r.key, tHi);
			}
		}//method 1
	}//Sol_3
}
