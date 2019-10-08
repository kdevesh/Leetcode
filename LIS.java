/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
import java.util.*;
public class LIS {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        if(N<=1)
            return  N;
        int i=1,j=0;
        int dp [] = new int[N];
        Arrays.fill(dp,1);
        while(i<N){
            if(nums[j]<nums[i]){
                dp[i] = Math.max(dp[i],dp[j]+1);
            }
            j++;
            if(j==i)
            {
                j=0;
                i++;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
