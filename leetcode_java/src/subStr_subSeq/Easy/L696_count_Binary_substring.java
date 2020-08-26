package subStr_subSeq;

public class L696_count_Binary_substring {
    public int countBinarySubstrings(String s) {
    	int res = 0, pre = 0, cur = 1;
    	for (int i=1;i<s.length(); i++) {
    		if (s.charAt(i) != s.charAt(i-1)){
    			int count = pre<cur?pre:cur;
    			res += count;
                pre = cur;
                cur = 1;
    		}
            else{
    		    cur ++;
            }
    	}
    	int count = pre<cur?pre:cur;
    	res += count;
    	
    	return res;
    	
    }
}
