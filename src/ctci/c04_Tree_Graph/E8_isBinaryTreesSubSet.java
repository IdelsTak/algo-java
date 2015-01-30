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
public class E8_isBinaryTreesSubSet {
	
	/*
	Solutions 1: find Node x in T1, which x == T2
		Check by: isSubWithSameRoot(Tnode x, Tnode T2)
		continue
	*/
	boolean isSub(Td T1, Td T2){
		if(T2 == null) return true;
		//Find node T2 in T1
		boolean result = false; 		
		if (T1 == T2) result = isSubHelper(T1, T2);		
		result |= isSub(T1.left, T2);
		result |= isSub(T1.right, T2);		
		return result;
	}
	
	boolean isSubHelper(Td T1, Td T2){
		boolean result;
		if(T2 == null) result = true;
		else{//T2!=null
			if(T1 == null) result = false;
			else
				result = (T1 == T2) && 
					isSubHelper(T1.left, T1.left) &&
					isSubHelper(T1.right, T1.right);
		}
		return result;
	}
}
