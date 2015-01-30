/*
p244: Do not understand the meaning of this testing.
 */

package t05_Bit;

import org.junit.Test;

/**
 *
 * @author andy
 */
public class E3_Positive_NextNumber {
	String getNextLarger(int n){
		int c0 = 0, 
			c1 = 0;
		//get c0
		int tmp = n;		
		while(	((tmp & 1) == 0)  &&  tmp > 0   ){
			c0++;
			tmp >>= 1;
		}
		if(tmp == 0) return "ERROR";
		//get c1		
		while(  (tmp & 1) == 1) {
			c1++;
			tmp >>= 1;
		}
		//get p
		int p = c0 + c1;
		//Get result
		int result = n & ~((1<<p) - 1);
		result += (1<<p) + (1<<(c1-1)) -1;
		return Integer.toBinaryString(result);
	}
	
	String getNextSmaller(int n){
		int c0 = 0,
			c1 = 0;
		//find c1
		int tmp = n;
		while(  (tmp&1) == 1 ){
			c1++;
			tmp >>= 1;
		}
		if(tmp == 0) return "ERROR";
		//find c0
		while( ((tmp&1) == 0) && tmp>0){
			c0++;
			tmp >>= 1;
		}
		int p = c1 + c0;
		//set the result
		//update the lower bit
		int result = n & (~((1<<(p+1)) - 1));//set bits [0, p] 0
		int all_1 = ((1<<(c1+1)) - 1);
		result |= (all_1 << (c0-1));
		return Integer.toBinaryString(result);
	}
	
	
	@Test
	public void test(){
		System.out.println("\n==============getNextLarger");
		int[] datas = {1123, 5531, 1924};
		for(int data : datas){
			System.out.println(Integer.toBinaryString(data));
			System.out.println(getNextLarger(data));
			System.out.println("");
		}
		System.out.println("\n==============getNextSmaller");		
		for(int data : datas){
			System.out.println(Integer.toBinaryString(data));
			System.out.println(getNextSmaller(data));
			System.out.println("");
		}		
	}
}
