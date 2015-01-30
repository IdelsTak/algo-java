/*
 Solutions to  http://www.careercup.com/question?id=5147801809846272

 Given a NxN matrix which contains all distinct 1 to n^2 numbers,
 write code to print sequence of increasing adjacent sequential numbers. ex:
 1 5 9
 2 3 8
 4 6 7
 should print: 6 7 8 9     */
package google_interview;

/*
 this is a tree traverse issue, it is easy to handle
 1. step 1: find the largest tree, which the location started from location [i, j, size]
 2. step 2: from this location, print out the path
 */
public class E40714_SeqNumber_Matrix {

    static int[][] Next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static class WrapInt {

        int n;		//size of curr loc
    }

    public static void main(String[] arg) {
        int[][] a = {
            {1, 5, 9},
            {2, 3, 8},
            {4, 6, 7}
        };
        System.out.println("Solution 1:");
        Sol_1.print(a);

        System.out.println("\nSolution 2:");
        Sol_2 sol2 = new Sol_2(a);
        //sol2.print(a);
    }

    public static class Sol_1 {//<editor-fold defaultstate="collapsed" desc="this is a tree issue">

        public static void print(int[][] a) {
            if (a == null) {
                return;
            }
            int n = a.length;
            boolean[][] visited = new boolean[n][n];  //9921 means: size 999, prev next position
            //keep the max location
            int maxN = 0, maxI = -1, maxJ = -1;
            WrapInt curN = new WrapInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        curN.n = 0;
                        dfs(a, visited, i, j, curN);
                        if (curN.n > maxN) {
                            maxN = curN.n;
                            maxI = i;
                            maxJ = j;
                        }//if
                    }//if
                }
            }
            print(maxI, maxJ, a, Integer.MAX_VALUE);
        }

        public static boolean inScope(int i, int j, int[][] a) {
            if (0 <= i && i < a.length && 0 <= j && j < a.length) {
                return true;
            }
            return false;
        }

        private static void dfs(int[][] a, boolean[][] visited, int r, int c, WrapInt wi) {
            visited[r][c] = true;
            wi.n++;
            for (int k = 0; k < 4; k++) {
                int i = r + Next[k][0];
                int j = c + Next[k][1];
                if (inScope(i, j, a) && !visited[i][j]
                        && Math.abs(a[i][j] - a[r][c]) == 1) {
                    dfs(a, visited, i, j, wi);
                }//if
            }//for
        }

        private static void print(int r, int c, int[][] a, int preValue) {
            int prei = -1, prej = -1, nexti = -1, nextj = -1;
            int cur = a[r][c];
            for (int k = 0; k < 4; k++) {
                int i = r + Next[k][0];
                int j = c + Next[k][1];
                if (inScope(i, j, a)) {
                    int dif = a[i][j] - cur;
                    if (dif == -1) {
                        prei = i;
                        prej = j;
                    } else if (dif == 1) {
                        nexti = i;
                        nextj = j;
                    }
                }//if
            }//for
            if (-1 != prei && preValue != a[prei][prej]) {
                print(prei, prej, a, cur);
            }
            System.out.printf("%d ", a[r][c]);
            if (-1 != nexti && preValue != a[nexti][nextj]) {
                print(nexti, nextj, a, cur);
            }
        }
    }//</editor-fold>

    public static final class Sol_2 {//<editor-fold defaultstate="collapsed" desc="Union Finder">

        public static class UI {//union Item

            int i;//pre
            int j;//pre//			int i0;//first			int j0;//first
            int size;

            public UI(int i, int j, int size) {
                this.i = i;
                this.j = j;
                this.size = size;
            }

            public void set(UI ui) {
                this.i = ui.i;
                this.j = ui.j;
                this.size = ui.size;
            }
        }

        private final UI[][] ui;
        private final int N;

        public Sol_2(int[][] a) {
            N = a.length;
            ui = new UI[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ui[i][j] = new UI(i, j, 1);
                }
            }
            print(a);
        }

        public void print(int[][] a) {
            //visit
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visit(a, i, j);
                }
            }
            //set size
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (ui[i][j].size == 1
                            && !(ui[i][j].i == i && ui[i][j].j == j)) {
                        setSize(i, j);
                    }
                }
            }
            //find max size
            int mi = 0, mj = 0;
            UI maxUI = new UI(-1, -1, -1);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (ui[i][j].size > ui[mi][mj].size) {
                        mi = i;
                        mj = j;
                    }
                }
            }
            //print the result from maxUI
            print(a, mi, mj);
        }

        private void visit(int[][] a, int r, int c) {
            for (int k = 0; k < 2; k++) {
                int i = r + Next[k][0];
                int j = c + Next[k][1];
                if (Sol_1.inScope(i, j, a)) {
                    int diff = a[r][c] - a[i][j];
                    if (diff == -1) {
                        ui[r][c].i = i;
                        ui[r][c].j = j;
                    } else if (diff == 1) {
                        ui[i][j].i = r;
                        ui[i][j].j = c;
                    }
                }//scope
            }//for
        }

        private int setSize(int i, int j) {
            if (ui[i][j].size > 1 || (ui[i][j].i == i && ui[i][j].j == j)) {
                return ui[i][j].size;
            } else {
                ui[i][j].size = setSize(ui[i][j].i, ui[i][j].j) + 1;
            }
            return ui[i][j].size;
        }

        private void print(int[][] a, int i, int j) {
            while (ui[i][j].size != 1) {
                System.out.printf("%d ", a[i][j]);
                int ti = i, tj = j;
                i = ui[ti][tj].i;
                j = ui[ti][tj].j;
            }
            System.out.printf("%d ", a[i][j]);
        }
    }//</editor-fold>
}
