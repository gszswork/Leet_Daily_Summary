package leet3;
import java.util.ArrayList;
public class Solution {
	 public int lengthOfLongestSubstring(String s) {
		 int max = 0;
		 for(int i=0; i<s.length(); i++) {
			 ArrayList<Character> charList = new ArrayList<Character>();
			 int accumulator = 0;
			 for (int j=i; j<s.length(); j++) {
				 if (! charList.contains(s.charAt(j))) {
					 accumulator ++;
					 charList.add(s.charAt(j));
				 }
				 else {
					 
					 break;
				 }
			 }
			 max = max>accumulator? max:accumulator;
		 }
		 return max;
	 }

}
