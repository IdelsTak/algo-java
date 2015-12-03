package com.epi;

import java.util.ArrayList;
import java.util.List;

public class E0505_PowerSet {
   public static final double LOG_2 = Math.log(2);
   
   /*
   Solution 1
   */
   public static List<List<Integer>> genPowerSet(List<Integer> inputSet){
       List<List<Integer>> powerSet  = new ArrayList<>();
       for (int iSubset = 0; iSubset < 10; iSubset++) {
           int bitA = iSubset;
           List<Integer> subSet = new ArrayList<>();
           while(bitA != 0){
               int leastBit = bitA & ~(bitA -1);
               int leastBitIdx = (int) (Math.log(leastBit) / LOG_2);
               subSet.add(inputSet.get(leastBitIdx));
               bitA &= bitA - 1;
           }
           powerSet.add(subSet);
       }
       return powerSet;
   }
   
   /*
   Solution 2
   */
   public static List<List<Integer>> genPowerSet2(List<Integer> inputSet){
       List<List<Integer>> powerSet = new ArrayList<>();
       List<Integer> currSet = new ArrayList<>();
       genHelper(inputSet, 0, currSet, powerSet);
       return powerSet;
   }
   
   private static void genHelper(
           List<Integer> inputSet, int nToSel, 
           List<Integer> currSet,
           List<List<Integer>> powerSet){
       
       if(nToSel == inputSet.size()){
           powerSet.add(new ArrayList<>(currSet));
           return;
       }
       genHelper(inputSet, nToSel+1, currSet, powerSet);
       currSet.add(inputSet.get(nToSel));
       genHelper(inputSet, nToSel+1, currSet, powerSet);
   }   
}
