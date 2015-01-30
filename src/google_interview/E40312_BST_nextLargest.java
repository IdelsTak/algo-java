/*
Solutions to next largest in BST

 */

package google_interview;

public class E40312_BST_nextLargest {
	public static void main(String[] arg){
	}

    private class Node {
        private int key;           // sorted by key
        private Node left, right;  // left and right subtrees
    }

	public static Node nextLargest(Node pre, Node n){
		//find node
		if(pre == null || n==null) return null;

		while(n!=null && n.key != pre.key){
			if(n.key < pre.key) {
				n = pre.left;
			}else{
				n = pre.right;
			}
			pre = n;
		}//while
		if(n==null) return null;
		else if(n.right==null) return pre;
		else{
			Node next = n.right;
			while(next.left!=null) next = next.left;
			return next;
		}
	}
}
