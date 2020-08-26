package subStr_subSeq;

public class L1180_Count_Substrings_with_Only_One_Distinct_Letter {
    public int countLetters(String S) {
    	int len = S.length(), res = 0, cur = 1;
    	
    	for( int i=1; i<len; i++) {
    		if(S.charAt(i) != S.charAt(i-1)) {
    			res += (cur+1)*cur/2;
    			cur = 1;
    		}
    		else {
    			cur ++;
    		}
    	}
    	return res;
    }
}
