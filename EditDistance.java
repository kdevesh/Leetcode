/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        char [] w1 = word1.toCharArray();
        char [] w2 = word2.toCharArray();
        int [] [] dp = new int [w2.length+1][w1.length+1];
        for(int i=0;i<=w1.length;i++)
            dp[0][i] = i;
        for(int i=0;i<=w2.length;i++)
            dp[i][0] = i;
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(w2[i-1]==w1[j-1])
                    dp[i][j]=dp[i-1][j-1];
                else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[w2.length][w1.length];
    }
}