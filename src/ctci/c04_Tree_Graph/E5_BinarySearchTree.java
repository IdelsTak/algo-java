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
class E5_BinarySearchTree {
	
	/*
	Solution 1: My solution
	*/
	char min(Td root){
		char value = Character.MAX_VALUE;
		if(root == null) value = Character.MIN_VALUE;
		return value;
	}
	
	char max(Td root){
		char value = Character.MIN_VALUE;
		if(root == null) value = Character.MAX_VALUE;
		return value;
	}
	
	boolean isSt_1(Td root){
		if(root == null) return true;
		boolean st = true;
		if(root.data > max(root.right)) st = false;
		if(root.data < max(root.left)) st = false;
		st = st && isSt_1(root.left) && isSt_1(root.right);
		return st;
	}

	/*
	Solution 2.   left.data <= Data < right.data
		using in-order visit, this solution is genious
	*/
	class WrapChar{
		char val = Character.MIN_VALUE;
	}
	boolean isSt_2(Td root, WrapChar lastVal){
		if (root == null) return true;
		if(!isSt_2(root.left, lastVal)) return false;
		if(lastVal.val > root.data) return false;
		lastVal.val = root.data;
		return isSt_2(root, lastVal);
	}
	
	/*
	Solution 3.  book Solution
	*/
	boolean isSt_3(Td root, char min, char max) {
		if(root == null) return true;
		if(root.data > max || root.data <= min) return false;
		
		boolean isSubSt = isSt_3(root.left, min, root.data) && 
			isSt_3(root.right, root.data, max);
		return isSubSt;		
	}
	
	/*
	Test
	*/
	@Test
	public void test(){
		Td root = new Td('A');
		isSt_1(root);
		WrapChar wc = new WrapChar();
		isSt_2(root, wc);	
		isSt_3(root, Character.MIN_VALUE, Character.MAX_VALUE);
	}
	
}
