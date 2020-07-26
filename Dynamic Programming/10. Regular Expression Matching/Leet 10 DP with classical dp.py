class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        n = len(s)
        m = len(p)
        dp = [[0] * (m + 1) for i in range(n + 1)]

        # when both s and p are empty:
        dp[0][0] = 1
        # when s is empty, but p is not empty, only is true when p is a*b*...(with * represents 0)
        for i in range(m):
            if p[i] == '*' and dp[0][i - 1]:
                dp[0][i + 1] = 1

        for i in range(n):
            for j in range(m):
                # case 1: 两字符匹配
                if p[j] == '.' or s[i] == p[j]:
                    dp[i + 1][j + 1] = dp[i][j]
                if p[j] == '*':
                    # case 2: 出现*
                    if p[j - 1] != '.' and p[j - 1] != s[i]:
                        # case 2.1: 因为p[j-1]与s[i]不匹配，* 作用0次
                        dp[i + 1][j + 1] = dp[i + 1][j - 1]
                    else:
                        # case 2.2: 有三种可能，s[i]与p[j-1]匹配，* 可能作用了1次，多于一次，也可能作用了0次
                        # 应该格外注意第三种情况，即使s[i]于p[j-1]匹配，p[j]的*可能仍然不作用
                        dp[i + 1][j + 1] = dp[i + 1][j] or dp[i][j + 1] or dp[i + 1][j - 1]

        return dp[n][m]