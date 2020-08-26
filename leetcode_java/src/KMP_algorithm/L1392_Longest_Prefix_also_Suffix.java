package KMP_algorithm;
//	要求一个字符串的最长的既是前缀又是后缀的字串
//	用KMP算法的后半截就可以，求出LPS， 
// 	LPS[i]是pat[0:i]部分既是前缀又是后缀的长度，直接用LPS[len-1]作为索引调用substring函数即可。
public class L1392_Longest_Prefix_also_Suffix {

	   public String longestPrefix(String s) {
	        int [] lps = new int [s.length()];
	        int len = s.length();
	        computeLPSArray(s, len, lps);
	        return s.substring(0, lps[len-1]);
	    }
	    public void computeLPSArray(String pat, int M, int lps[]) 
		{ 
			// length of the previous longest prefix suffix 
			int len = 0; 
			int i = 1; 
			lps[0] = 0; // lps[0] is always 0 

			// the loop calculates lps[i] for i = 1 to M-1 
			while (i < M) { 
				if (pat.charAt(i) == pat.charAt(len)) { 
					len++; 
					lps[i] = len; 
					i++; 
				} 
				else // (pat[i] != pat[len]) 
				{ 
					// This is tricky. Consider the example. 
					// AAACAAAA and i = 7. The idea is similar 
					// to search step. 
					if (len != 0) { 
						len = lps[len - 1]; 

						// Also, note that we do not increment 
						// i here 
					} 
					else // if (len == 0) 
					{ 
						lps[i] = len; 
						i++; 
					} 
				} 
			} 
		} 
}
