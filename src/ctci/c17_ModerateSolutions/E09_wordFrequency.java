/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t17_ModerateSolutions;

import java.util.HashMap;

/**
 *
 * @author andy
 */
public class E09_wordFrequency {

	HashMap<String, Integer> map = new HashMap<>();

	int getFrequency(String word) {
		if (word == null || word.trim() == "") {
			return -1;
		}
		int frequency = 0;
		if (map.containsKey(word)) {
			frequency = map.get(word);
		}
		return frequency;
	}

	void setupDictionary(String[] book) {
		for (String word : book) {
			word = word.toLowerCase();
			if (null != word && word.trim() != "") {
				if (map.containsKey(word)) {
					map.put(word, map.get(word) + 1);
				} else {
					map.put(word, 1);
				}
			}//if
		}//for
	}

}
