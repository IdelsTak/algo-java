
package t03_Stack_Queue;

import java.util.ArrayList;

/**
 *
 * @author andy
 */
public class E3_StackSets {
    ArrayList<Stack<Integer>> stacks = new ArrayList<>();
    static final int CAPACITY = 3;
    
    private Stack<Integer> getLastStack(){
        if(stacks.isEmpty()) return null;
        else return stacks.get(stacks.size() -1);
    }
    
    void push(int data){
        Stack<Integer> last = getLastStack();
        if (null == last || last.isFull()){
            Stack<Integer> stack = new Stack<>(CAPACITY);
            stack.push(data);
            stacks.add(stack);
        }else{
            last.push(data);
        }
    }
    
    int pop(){
        Stack<Integer> last = getLastStack();
        int v = last.pop();
        if (last.size == 0) stacks.remove(v);
        return v;
    }
    
    int popAt_NoShift(int i){
        Stack<Integer> stack = stacks.get(i);
        int value = stack.pop();
        if(0 == stack.size) stacks.remove(i);
        return value;
    }
    
    int popAt_shift(int i){
        return leftShift(i, true);
    }
    
    private int leftShift(int i, boolean removeTop){
        int value;
        Stack<Integer> stack = stacks.get(i); 
        
        if (removeTop)  value = stack.pop();
        else value = stack.removeBottom();
        
        if(0 == stack.size) stacks.remove(i);
        else if(stacks.size() > i + 1){
            stack.push(leftShift(i+1, false));
        }
        return value;
    }
}
