/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t09_Recursion_DynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class E4_SubSet {

	LinkedList<LinkedList<Integer>> getSubSet(LinkedList<Integer> set) {
		LinkedList<LinkedList<Integer>> sub = new LinkedList<>();
		sub.add(new LinkedList<>());//add an empty set
		getSubSet(set, sub);
		return sub;
	}

	void getSubSet(LinkedList<Integer> set, LinkedList<LinkedList<Integer>> sub) {
		for (Integer i : set) {
			LinkedList<LinkedList<Integer>> subClone = (LinkedList<LinkedList<Integer>>) sub.clone();
			for (LinkedList<Integer> list : subClone) {
				LinkedList<Integer> listClone = (LinkedList<Integer>) list.clone();
				listClone.add(i);
				sub.add(listClone);
			}
		}
	}

	@Test
	public void test() {
		Integer[] datas = {1, 2, 3, 4, 5};
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(datas));
		LinkedList<LinkedList<Integer>> subSet = getSubSet(list);
		printList(subSet);
	}

	private void printList(LinkedList<LinkedList<Integer>> subSet) {
		for (LinkedList<Integer> list : subSet) {
			System.out.println(list.toString());
		}
	}
}
