package leet3;
import java.util.ArrayList;
class Solution1 {
    ArrayList<Character> arr = new ArrayList<Character>();
    public int lengthOfLongestSubstring(String s) {
        
        int count = 0;
        char [] charList = s.toCharArray();
        for (int i=0; i<charList.length; i++){
            if(!containIn(charList[i])){
                arr.add(charList[i]);
                count ++;
            }
        }
        return count;
    }
    public boolean containIn(char c){
        for(int i=0; i< arr.size(); i++){
            if (c == arr.get(i)){
                return true;
            }
        }
        return false;
    }
}