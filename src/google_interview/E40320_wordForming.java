/* 
Solutions to http://www.careercup.com/question?id=5841660122497024

Given a dictionary of words, and a set of characters, judge if all the characters can form the words from the dictionary, without any characters left.
 For example, given the dictionary {hello, world, is, my, first, program},
 if the characters set is "iiifrssst", you should return 'true' because you can form {is, is, first} from the set;
 if the character set is "eiifrsst", you should return 'false' because you cannot use all the characters from the set.

 P.S. there may be tens of thousands of words in the dictionary, and the chars set length could be up to hundreds, so I really need some efficient algorithm.
 */

package google_interview;

public class E40320_wordForming {

	public static void main(String[] arg) {
		Sol_1.init();
		System.out.printf("can extract  %s", Sol_1.canExtract());
	}

	public static final class Sol_1 {

		static final String extractStr = "iiifrssst";
		static final String[] words = {"hello", "world", "is", "my", "first", "program"};
		static int[] chars;

		public static boolean canExtract() {
			return canExtract(words, chars, "");
		}

		private static boolean canExtract(String[] words, int[] str, String path) {
			for (String word : words) {
				int[] newStr = str.clone();
				boolean result = subtract(newStr, word);
				if (result) {
					if (isMatching(newStr)) {
						System.out.println(path + ", " + word);
						return true;
					} else {
						result = canExtract(words, newStr, path + ", " + word);
						if (result) {
							return true;
						}
					}//if
				}//if
			}//for
			return false;
		}//canExtract

		private static boolean isMatching(int[] str) {
			boolean result = true;
			for (int i : str) {
				result = result && (i == 0);
			}
			return result;
		}


		private static boolean subtract(int[] str, String word) {
			for (char c : word.toCharArray()) {
				if (--str[c - 'a'] < 0) {
					return false;
				}
			}
			return true;
		}

		public static void init() {
			String str = "iiifrssst".toLowerCase();
			chars = new int[26];
			for (char c : str.toCharArray()) {
				int idx = c - 'a';
				chars[idx]++;
			}
		}//Sol_1
	}
}
