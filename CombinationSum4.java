public class CombinationSum4 {
    public static int combinationSum4(int[] nums, int target) {
        int[][] dp = new int[nums.length+1][target+1];
        for(int i=0;i<dp[0].length;i++)
            dp[0][i] = 0;
        for(int i=0;i<dp.length;i++)
            dp[i][0] = 1;
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(j-nums[i-1]>=0)
                    dp[i][j] += dp[i-1][j]+dp[i][j-nums[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[dp.length-1][target];
    }

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1,2,3},4));
    }
}
