/*
 */

package t09_Recursion_DynamicProgramming;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class E4_SubSet_bk {

	/*
	 solution 1:
	 */
	//index = -1 ~ indx - 1, -1 - empty set
	ArrayList<ArrayList<Integer>> getSubsets_my(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> subSets;
		if (index == -1) {
			subSets = new ArrayList<>();
			subSets.add(new ArrayList<>());
		} else {
			subSets = getSubsets_my(set, index - 1);
			ArrayList<ArrayList<Integer>> subSetsClone = (ArrayList<ArrayList<Integer>>) subSets.clone();
			for (ArrayList<Integer> list : subSetsClone) {
				ArrayList<Integer> listClone = (ArrayList<Integer>) list.clone();
				listClone.add(set.get(index));
				subSets.add(listClone);
			}
		}
		return subSets;
	}

	//when call this method, the index should be 0
	ArrayList<ArrayList<Integer>> getSubsets_bk(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> subSets;
		if (set.size() == index) {
			subSets = new ArrayList<>();
			subSets.add(new ArrayList<>());
		} else {
			subSets = getSubsets_bk(set, index + 1);
			ArrayList<ArrayList<Integer>> subSetsClone = (ArrayList<ArrayList<Integer>>) subSets.clone();
			for (ArrayList<Integer> list : subSetsClone) {
				ArrayList<Integer> listClone = (ArrayList<Integer>) list.clone();
				listClone.add(set.get(index));
				subSets.add(listClone);
			}
		}
		return subSets;
	}

	/*
	 Soution 2:
	 */
	String getMaxInteger(int len) {
		StringBuffer sb = new StringBuffer(len);
		for (int i = 0; i < len; i++) {
			sb.append(1);
		}
		return sb.toString();
	}

	ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> subS = new ArrayList<>();
		int setLen = set.size();
		BigInteger bigInt = new BigInteger(getMaxInteger(setLen));
		BigInteger smallInt = new BigInteger("0");
		while (!smallInt.equals(bigInt)) {
			subS.add(getSubset(set, smallInt));
			smallInt.add(BigInteger.ONE);
		}
		return subS;
	}

	ArrayList<Integer> getSubset(ArrayList<Integer> set, BigInteger b) {
		int len = b.bitLength();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			if (b.testBit(i)) {
				list.add(set.get(i));
			}
		}
		return list;
	}

	/*
	 Testing
	 */
	@Test
	public void test() {
		Integer[] datas = {1, 2, 3, 4, 5};
		ArrayList<Integer> set = new ArrayList<Integer>(Arrays.asList(datas));
		ArrayList<ArrayList<Integer>> subSets = getSubsets_my(set, set.size() - 1);
		print(subSets);
		//
		System.out.println("\n\n\n");
		subSets = getSubsets_bk(set, 0);
		print(subSets);
	}

	private void print(ArrayList<ArrayList<Integer>> subSet) {
		for (ArrayList<Integer> list : subSet) {
			System.out.println(list.toString());
		}
	}
}
