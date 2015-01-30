/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t03_Stack_Queue;

/**
 *
 * @author andy
 */
public class E1_Stack_Fixed {
    static final int stackSize = 100;
    int[] buffer = new int[3 * stackSize];
    int[] pointer = {-1, -1, -1};
    
    public void push(int id, int data) throws Exception{
        if(pointer[id] + 1 > stackSize) throw new Exception("out of space");
        pointer[id]++;
        buffer[absTop(id)] = data;        
    }
    
    public int pop(int id) throws Exception{
        if(pointer[id] == -1){
            throw new Exception("no data");
        }
        int data = buffer[absTop(id)];
        pointer[id]--;
        return data;
    }

    public int absTop(int id){
        return id * stackSize + pointer[id];
    }
}
