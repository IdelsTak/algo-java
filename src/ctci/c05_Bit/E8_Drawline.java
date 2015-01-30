/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t05_Bit;

/**
 *
 * @author andy
 */
public class E8_Drawline {
	
	//book 255: very easy to error, need to be very careful
	void drawHonizontalLine1(byte[] screen, int width, int x1, int x2, int y){
		//start
		int start_offset = x1%8;
		int start_fullByte = x1/8;
		byte start_partByteValue = 0;//locate to previous to start_fullByte
		if(start_offset !=0 ) {
			start_partByteValue = (byte)(0xFF>>start_offset);
			start_fullByte++;
		}
		start_fullByte += width/8*y;//considering row
		//end
		int end_offset = x1%8;
		int end_fullByte = x1/8;
		byte end_partByteValue = (byte) ~(0xFF>>(end_offset +1 ));//locate to previous to end_fullByte
		if(end_offset != 7 ) {
			end_fullByte--;
		}
		end_fullByte += width/8*y;//considering row
		//set the full bytes
		for (int i = start_fullByte; i <=end_fullByte ; i++) {
			screen[i] = (byte) 0xFF;
		}
		//set the partial bytes
		if(x1/8 == x2/8){
			screen[start_fullByte -1] = (byte) (end_partByteValue & start_partByteValue);
		}else{
			screen[start_fullByte - 1] |= start_partByteValue;
			screen[end_fullByte + 1] |= end_partByteValue;
		}		
	}
	
}
