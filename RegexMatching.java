public class RegexMatching {
    public boolean isMatch(String s, String p) {
        char str[] = s.toCharArray();
        char pat[] = p.toCharArray();
        boolean dp[][] = new boolean[str.length + 1][pat.length + 1];
        dp[0][0] = true;
        for (int i = 1; i <= pat.length; i++) {
            if (pat[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];
        }
        for (int i = 1; i <= str.length; i++) {
            for (int j = 1; j <= pat.length; j++) {
                if (str[i - 1] == pat[j - 1] || pat[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pat[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (pat[j - 2] == '.' || str[i - 1] == pat[j - 2])
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                } else
                    dp[i][j] = false;
            }
        }
        return dp[str.length][pat.length];
    }
}