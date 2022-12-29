class Solution {
    fun jump(nums: IntArray): Int {
        val dp = IntArray(nums.size){10001}
       
       
        return solve(nums,dp,0)
    }
    fun solve(nums:IntArray, dp:IntArray,pos:Int):Int{
        if(pos>=nums.lastIndex)return 0
        if(dp[pos]!=10001)return dp[pos]
        for(j in 1..nums[pos])//가능한 점프 위치
            dp[pos] = minOf(dp[pos], 1 + solve(nums, dp, pos + j));        
        return dp[pos];
    }
}