/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t04_Tree_Graph;

/**
 *
 * @author andy
 */
public class E6_InOrderSuccessor {


/*
Solution 1: my solution	
	NOTE: this is no the answer to this question, 
	I have not read the questio carefully
*/
	 class WrapNode{
		 Td node = null;
	 }
	 
	 //if found return the node
	 Td search_1(Td root, Td node, WrapNode prev){
		 if(null == root) return null; 
		 //visit left
		 Td left = search_1(root.left, node, prev);		 
		 if(left != null) return left;
		 //visit curr
		 if(prev.node == node) return root;
		 prev.node = node;
		 //visit right
		 Td right = search_1(root.right, node, prev);
		 if(right != null) return right;
		 //not found
		 return null;		 
	 }
/*
Solution 2: from the book
*/
	 Td search_2(Td root){
		 if(null == root) return null;
		 if(null != root.right) return leftMostNode(root.right);
		 
		 Td parent = root.parent;
		 while(parent!=null && parent.right == root){
			 root = parent;
			 parent = parent.parent;
		 }
		 return parent;
	 }
	 
	private Td leftMostNode(Td root) {
		if(root == null) return null;
		while(root.left != null) root = root.left;
		return root;
	}
}
