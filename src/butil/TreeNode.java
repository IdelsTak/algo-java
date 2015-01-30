/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package butil;

public class TreeNode<T> {

	public T data;

	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;

	public TreeNode(T d) {
		this(d, null, null);
	}

	public TreeNode(T d, TreeNode left, TreeNode right) {
		this.data = d;
		this.left = left;
		this.right = right;
	}

	public final void equal(TreeNode<T> tn) {
		this.data = tn.data;
		this.left = tn.left;
		this.right = tn.right;
	}

	public static TreeNode<Integer> getIntTree_post() {
		Integer[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		TreeUtil.Icreate<Integer> creater = (new TreeUtil()).new Creator_myOptimized_post<>();
		TreeNode<Integer> root = creater.create(ints);
		return root;
	}


}