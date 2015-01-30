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
public class Td {

	//andy one of it
	char data;
	public int i;//for sort
	
	public Td left;
	public Td right;
	Td parent;//for Ex6

	boolean visited = false;//for tree visit

	Td(char c){
		this.data = c;
	}
	
	public Td(int i) { //for sort
		this.i = i;
	}

	private void initPointers() {
		this.left = null;
		this.right = null;
		this.parent = null;
	}


	void setVisited(){
		visited = true;
	}

	public void addSearchTreeNode(Td node) {
		if (node.i <= i) {
			if (this.left != null) {
				this.left.addSearchTreeNode(node);
			} else {
				this.left = node;
			}
		} else {
			if (this.right != null) {
				this.right.addSearchTreeNode(node);
			} else {
				this.right = node;
			}
		}//if
	}//method

}
