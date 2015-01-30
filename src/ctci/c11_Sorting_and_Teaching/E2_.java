/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t11_Sorting_and_Teaching;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author andy
 */
public class E2_ {
	public class AnagramComaror implements Comparator<String> {

		public String sortChars(String s) {
			char[] content = s.toCharArray();
			Arrays.sort(content);
			return new String(content);
		}

		@Override
		public int compare(String s1, String s2) {
			return sortChars(s1).compareTo(s2);
		}
	}
}
