package leet5;
// By Brote Force we can solve the problem but time limit exceeded.
public class Solution_Brute_Force {
    public String longestPalindrome(String s) {

    	String res = "";
    	for(int i=0; i<= s.length(); i++)
    	for(int j=i; j<= s.length(); j++){
    		
    		String str = s.substring(i, j);
    		if(judgePali(str)) {
    			if(str.length() > res.length()) {
    				res = str;
    			}
    
    		}
    		else {

    		}
    	}
   
        return res;
    }
    public boolean judgePali(String s) {
    	int len = s.length();
    	for(int i=0; i<len/2; i++) {
    		if(!(s.charAt(i)==s.charAt(len-i-1))) {
    			return false;
    		}
    	}
    	return true;
    }
   
}
