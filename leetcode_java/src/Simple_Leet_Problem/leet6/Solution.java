package leet6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String convert(String s, int numRows) {
         if(numRows <=1 ){return s;}
         else {

             StringBuilder [] sb = new StringBuilder [numRows];
             for(int i=0; i<numRows; i++) {
                 sb[i] = new StringBuilder();
             }

             int len = s.length(), index = 0, pin = 0;
             boolean reverse = false;
             while(index < len) {
                 sb[pin].append(s.charAt(index));
                 index ++;
                 if (! reverse && pin < (numRows -1)) {
                     pin ++;
                 }
                 if (reverse && pin >0) {
                     pin --;
                 }
                 if (pin == (numRows-1) && !reverse){
                     reverse = true;
                 }
                 if (pin == 0 && reverse) {
                     reverse = false;
                 }
             }
             String res = "";
             for (int i=0; i<numRows; i++) {
                 res += sb[i].toString();
             }
             return res;
         }
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if (hash.containsKey(complement)){
                return new int[] {hash.get(complement), i};
            }
            hash.put(nums[i], i);
        }
		return new int[] {};
    }
    public static void main(String args[]) {
    	int x = 1234;

    }
}
