/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t04_Tree_Graph;

import org.junit.Test;

/**
 *
 * @author andy
 */
public class E3_CreateBinaryTree {
	public Td createMinBST(char[] arr, int first, int last){
		if(first > last) return null;
		int mid = (first + last)/2;
		Td node = new Td(arr[mid]);
		node.left = createMinBST(arr, first, mid - 1);
		node.right = createMinBST(arr, mid + 1, last);
		return node;
	}
	
	Td createMinBST(char[] arr){
		return createMinBST(arr, 0, arr.length -1);
	}
	
	@Test
	public void test(){
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		createMinBST(str.toCharArray());
	}
}
