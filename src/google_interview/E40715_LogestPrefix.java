/*
 Solutions to http://www.careercup.com/question?id=5162680650301440
 Find the longest sequence of prefix shared by all the words in a string.
 "abcdef abcdxxx abcdabcdef abcyy" => "abc"
 */
package google_interview;

/*
 1. use brute force
 2. use trie

 I can split word, or not split workd
 has many solutions
 */
public class E40715_LogestPrefix {

    //best solution
    public static class Sol1_BruteForce_StringArray {//<editor-fold defaultstate="collapsed" desc="comment">
    }//</editor-fold>

    //modified version of trie
    public static class Sol2_Trie {

        public static class Node {

            int pos;//point to position in string
            int N;	//num of child
            Node next;
            Node misMatch;
            int c;
        }

    }
}
