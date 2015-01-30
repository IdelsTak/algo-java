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
public class E1_IsTreeBalanced {
	Td root;
	
	/*
	Solution 1
	*/
	int getDepth(Td node){
		if(null == node) return 0;
		return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
	}
	
	boolean isBalanced1(Td node){
		if(node == null) return false;
		int depthDiff = getDepth(node.left) - getDepth(node.right);
		if (Math.abs(depthDiff)>1){
			return false;
		}else{
			return isBalanced1(node.left) && isBalanced1(node.right);
		}		
	}
	
	
	/*
	Solution 2
	*/
	public class BoolWrapper{
		 boolean isBalanced;
	}
	
	//bool initial is true, whenEver not balanced, set to false
	int isBalanced2(Td root, BoolWrapper bool){
		if(root == null) return 0;
		if(!bool.isBalanced) return -1;//someware not balanced, quit ASAP
		int nl = isBalanced2(root.left, bool);
		int nr = isBalanced2(root.right, bool);
		if(Math.abs(nl - nr) > 1){
			bool.isBalanced = false;
		}
		return Math.max(nl, nr);
	}
	
	/*
	Solution 3
	*/
	public class Depth{
		 int left = 0;
		 int right = 0;
		 Depth(){
		 }
		 void set(int left, int right){
			 this.left = left;
			 this.right = right;
		 }
		 int max(){
			 return Math.max(left, right);
		 }
		 boolean isBalance(){
			 return Math.abs(left - right) <= 1;
		 }
	}
	
	boolean isBalanced3(Td root, Depth depth){
		if(root == null) {
			depth.set(0, 0);
			return true;
		}
		Depth lD = new Depth();
		Depth rD = new Depth();
		if (isBalanced3(root.left, lD) && isBalanced3(root.right, rD)){
			depth.left = lD.max() + 1;
			depth.right = rD.max() + 1;
			return depth.isBalance();
		}
		return false;
	}
}
