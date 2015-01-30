/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t01_Arrays_Strings;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author andy
 */
public class E6_E7_matrixTest {
    public class matrix {
        public matrix(int rows){
            this.rows = rows;
            this.matrix = new int[rows][rows];
            init();
        }
        
        private void init(){
            for(int i = 0; i<rows; i++)
                for(int j = 0; j<rows; j++)
                    this.matrix[i][j] = i*10 + j;
        }
        
        public void print(){
            for(int i = 0; i<rows; i++){
                for(int j = 0; j<rows; j++){
                    String str = "0" + this.matrix[i][j];
                    str = str.substring(str.length() - 2) + " ";
                    System.out.print(str);
                }
                System.out.println("");
            }
            System.out.println("");
        }
        
        /*for i = 0 to n
            temp = top[i];
            top[i] = left[i];
            left[i] = bott[i];
            bott[i] = right[i];
            right[i] = tmp;*/
        public void rotate1(){//rotate locally
            for(int layer = 0; layer < rows/2; layer++){
                int first = layer;
                int last = rows - 1 - layer;
                for (int i = first; i < last; i++) {
                    //tmp <- top
                    int tmp = matrix[layer][i];
                    //top <- left
                    matrix[layer][i] = matrix[rows - 1 - i][layer];
                    //left <- bottom
                    matrix[rows - 1 - i][layer] = matrix[last][rows - 1 - i];
                    //bottom <- right
                    matrix[last][rows - 1 - i] = matrix[i][last];
                    //right <- tmp
                    matrix[i][last] = tmp;
                }
            }
        }

        public void rotate2(){//rotate locally
            System.out.println("not implemented");
        }
        
        public void E7_0_row_col(){
            matrix[1][1] = 0;
            matrix[3][3] = 0;
            this.print();
            boolean[] row = new boolean[matrix.length];
            boolean[] col = new boolean[matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = true;
                        col[j] = true;
                    }
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (row[i] || col[j]) {
                       matrix[i][j] = 0;
                    }
                }
            }
            this.print();
        }

        private int rows;
        private int[][] matrix = null;
    }
    
    
    @Test
    public void test() {
        matrix m1 = new matrix(5);  m1.print();
        m1.rotate1();  m1.print();
        
        matrix m2 = new matrix(8);
        m2.E7_0_row_col();
    }
}
