/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort_imp;

import t04_Tree_Graph.Td;

/**
 *
 * @author andy
 */
public class SE_BinaryTreeSort extends S0_SortCommon {

	@Override
	void sort(int[] a) {
		Td root = genHeap(a);
		outputHeap(root);
	}

	void outputHeap(Td root) {
		if (root == null) {
			return;
		}
		outputHeap(root.left);
		System.out.printf("%d, ", root.i);
		outputHeap(root.right);
	}

	Td genHeap(int[] a) {
		Td root = null;
		for (int d : a) {
			root = add(root, d);
		}
		return root;
	}

	Td add(Td root, int d) {
		Td node = new Td(d);
		if (null == root) {
			root = node;
		} else {
			root.addSearchTreeNode(node);
		}
		return root;
	}

}
