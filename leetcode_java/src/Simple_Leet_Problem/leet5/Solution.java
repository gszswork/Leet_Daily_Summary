package leet5;
// DP
public class Solution {
	 public String longestPalindrome(String s) {
		 int len = s.length();
		 String res = "";
		 boolean [][] dp = new boolean[len][len];
		 
		 for(int i=0; i<len; i++) {
			 dp[i][i] = true;
		 }
		 for (int i=len-1; i>=0; i--) {
			 for (int j=i; j<len; j++) {
				 if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1])) {
					 //System.out.println(i + " "+ j+"true");
					 dp[i][j] = true;
					 if(res.length() < (j-i+1)) {
						 res = s.substring(i, j+1);
					 }
				 }
				 

			 }
		 }
		 return res;
		 
	 }
	 public static void main(String args[]) {
		 String str = "babad";
		 Solution sol = new Solution();
		 System.out.println(sol.longestPalindrome(str));
	 }
}
