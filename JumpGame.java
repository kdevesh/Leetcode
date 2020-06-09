class Solution3 {
    public boolean canJump(int[] nums) {
        int dp [] = new int[nums.length];
        if(nums.length>1&&nums[0]==0)
            return false;
        if(nums.length==1)
            return true;
        int k=1;
        while(k<nums.length&&k<=nums[0]){
            dp[k]=1;
            k++;
        }
        for(int i=1;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                    if(dp[i]!=0&&nums[i]>=Math.abs(j-i))
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
        if(dp[dp.length-1]==0)
            return false;
        else
            return true;
    }
}
