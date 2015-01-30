/* 
 Solution for http://www.careercup.com/question?id=6031783804010496

given 2 Dimensional array
I/P -- String[][] input = { { "abc", "def", "gh" },
{ "f", "g" },
{ "qrt","xyz","pqr" } };

Program shd return a 2-D Array with
O/P -- { { "abcfqrt", "abcfxyz", "abcfpqr" ,abcgqrt and so on ..
 */
package google_interview;

public class E40130_2D_2d {

    public static void main(String[] args) {
        String[][] a = {{"abc", "def", "gh"}, {"f", "g"}, {"qrt", "xyz", "pqr"}};
        print(a);

    }

    public static void print(String[][] a) {

        if (a == null) {
            return;
        }

        int x = a[0].length;
        int y = 0;

        for (int i = 0; i < x; i++) {
            if (y < a.length) {
                printMore(a, a[0][i], y + 1);
            }
        }

    }

    public static void printMore(String[][] a, String str, int yIndex) {

        int x = a[yIndex].length;

        for (int i = 0; i < x; i++) {
            if (yIndex < a.length - 1) {
                printMore(a, str + a[yIndex][i], yIndex + 1);
            } else {
                System.out.println(str + a[yIndex][i]);
            }

        }
    }

}
