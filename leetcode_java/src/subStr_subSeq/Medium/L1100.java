package subStr_subSeq.Medium;

import java.util.HashSet;

// L1100_K-Length_Substrings_No_Repeated_Character
// 给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。
public class L1100 {
    public int numKLenSubstrNoRepeats(String S, int K) {
        int len = S.length();
        int count = 0;
        if (K>len) return 0;
        for(int i=0; i+K<len+1; i++) {
        	HashSet<Character> hash = new HashSet<Character>();
        	for(int j=0; j<K; j++) {
        		if(hash.contains(S.charAt(i+j))) {
        			break;
        		}else {
        			hash.add(S.charAt(i+j));
        		}
        		if(j==K-1) {
        			count ++;
        			System.out.println(S.substring(i,i+K));
        		}
        	}
        }
        return count;
    }
    public static void main(String args[]) {
    	L1100 sol = new L1100();
    	String S = "havefunonleetcode";
    	int K = 5;
    	int res = sol.numKLenSubstrNoRepeats(S, K);
    	System.out.println(res);
    }
}
