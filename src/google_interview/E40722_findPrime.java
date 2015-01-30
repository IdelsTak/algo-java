/*
 Solutions to   http://www.careercup.com/question?id=5763123118080000

 Solutions:
 I have done this, use dynamic programming, better than solutions on the site
 */
package google_interview;

import java.util.LinkedList;

public class E40722_findPrime {

    static LinkedList<Long> list = new LinkedList<>();
    static long lastAuxHi = 1;

    public static void findPrime() {
        long LA = (long) Math.pow(10, 9) + 1;
        long LB = (long) Math.pow(10, 10);
        int n = 0;
        for (long i = LA; i < LB && n < 5; i++) {
            long sqrt = (long) Math.sqrt(i);
            createAuxPrimeList(sqrt);
            if (isPrime(i)) {
                System.out.printf(" <%d> ", i);
                n++;
            }
        }
    }

    public static void createAuxPrimeList(long hi) {
        for (long i = lastAuxHi + 1; i <= hi; i += 2) {
            if (isPrime(i)) {
                list.add(i);
                System.out.printf("%d ", i);
            }
        }//for
        lastAuxHi = hi;
    }

    public static boolean isPrime(long d) {
        for (long t : list) {
            if (d % t == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] arg) {
        list.add((long) 2);
        lastAuxHi = 2;
        findPrime();
    }

}
