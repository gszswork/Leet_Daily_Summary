package subStr_subSeq;

public class L392_Is_Sequence {
    public boolean isSubsequence(String s, String t) {
    	int i=0, j=0;
    	int lenS = s.length(), lenT = t.length();
    	
    	while(j<lenT && i<lenS) {
    		if(s.charAt(i) == t.charAt(j)) {
    			i++;
    		}
    		j++;
    	}
    	if(i == lenS)
        	return true;
    	else
    		return false;
    }
}
