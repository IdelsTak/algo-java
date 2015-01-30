/*
 */

package t11_Sorting_and_Teaching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class E2_sortAnagrams {

	String getSorted(String s) {
		char[] a = s.toCharArray();
		java.util.Arrays.sort(a);
		return new String(a);
	}

	void sort(String[] a) {
		//put into map
		Map<String, ArrayList<String>> m = new HashMap<>();
		for (String s : a) {
			String ss = getSorted(s);
			ArrayList<String> l;
			if (m.containsKey(ss)) {
				l = m.get(ss);
			} else {
				l = new ArrayList<>();
				m.put(ss, new ArrayList<>());
			}
			l.add(s);
		}
		//pull out of map
		Iterator it = m.entrySet().iterator();
		int i = 0;
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			ArrayList<String> l = (ArrayList<String>) e.getValue();
			for (String s : l) {
				a[i++] = s;
			}
		}
		//
		butil.Print.stringArrayPrint(a);
	}

	@Test
	public void test() {
		String[] a = {"abc", "ac", "bac", "ca", "a"};
		sort(a);
	}
}
