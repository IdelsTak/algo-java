/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t09_Recursion_DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class EA_StackBox {

	public class Box {
		double w;
		double d;
		double h;

		boolean larger(Box box) {
			return (w > box.w) && (d > box.d) && (h > box.h);
		}
	}

	/*
	 Solution 1: from the book
	 */
	public double stackHeight(ArrayList<Box> list) {
		return 0;
	}

	public ArrayList<Box> createStack(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> map) {
		if (map.containsKey(bottom)) {
			return map.get(bottom);
		}

		ArrayList<Box> maxList = null;
		double maxHeight = 0;
		for (Box box : boxes) {
			if (bottom.larger(box)) {
				ArrayList<Box> list = createStack(boxes, box, map);
				double stackHeight = stackHeight(list);
				if (stackHeight > maxHeight) {
					maxHeight = stackHeight;
					maxList = list;
				}
			}
		}

		if (null == maxList) {
			maxList = new ArrayList<>();
		}
		maxList.add(0, bottom);

		map.put(bottom, maxList);

		return (ArrayList<Box>) maxList.clone();//the last sencentence is very important
	}

	@Test
	public void test() {
		Box[] boxes = new Box[20];
		Box bottom = new Box();
		HashMap<Box, ArrayList<Box>> map = new HashMap<>();
		ArrayList<Box> boxList = createStack(boxes, bottom, map);
	}

}
