class Solution {
    public int jump(int[] nums) {
        int dp [] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                    if(nums[i]>=Math.abs(j-i))
                    {
                        if(dp[j]==0)
                            dp[j] = dp[i]+1;
                        else
                            dp[j] = Math.min(dp[j],dp[i]+1);
                    }
                    else
                        break;
                
            }
                
        }
        return dp[dp.length-1];
    }
}
