package subStr_subSeq;

public class L459_Repeated_Substring_Pattern {
    public boolean repeatedSubstringPattern1(String s) {
    	String str = s + s;
    	return str.substring(1, str.length()-1).contains(s);
    }
    
    public boolean repeatedSubstringPattern(String s) {
    	for(int i=1; i<s.length(); i++) {
    		String res = s.substring(0, i);
    		res = repeatString(res, (s.length()/res.length()));
    		if(res.equals(s)) {
    			return true;
    		}
    	}
    	return false;
    }
    public String repeatString(String str, int n) {
    	if( n==1) {
    		return str;
    	}
    	else {
    		String ret = str;
    		while(n>1) {
    			ret += str;
    			n --;
    		}
    		return ret;
    	}
    }
}
