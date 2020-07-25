class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        res = ""
        dp = [[0] * n for i in range(n)]
        for i in range(n):
            dp[i][i] = 1
            res = s[i:i+1]
        
        #for i in range(n-1, -1, -1):
        #for j in range(i, n):
        for j in range(n):
            for i in range(0, j):
                if s[i] == s[j] and (j-i <2 or dp[i+1][j-1] ==1):
                    dp[i][j] =1
                    if j-i+1 > len(res):
                        res = s[i:j+1]
        return res

# Summary: If we solve this in dynamic programming. The size of  dynamic matrix is n*n.
# And the value of the diagonal of the matrix is initialized to 1.

