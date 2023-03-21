class Solution {
    fun maxScore(nums: IntArray): Int {
        val m = nums.size
        val n = m/2
        val dp = Array(n+1){IntArray(1 shl m){-1}}
        fun solve(i:Int, mask:Int):Int{
            if(i>n)return 0
            if(dp[i][mask]!=-1)return dp[i][mask]
     
            for(j in 0..m-1){
                for(k in j+1..m-1){
                    val newMask = (1 shl j) + (1 shl k)
                    if(mask and newMask ==0)dp[i][mask] = maxOf(dp[i][mask], i*gcd(nums[j], nums[k])+solve(i+1, mask or newMask))
                }
            }
         
            return dp[i][mask]
        }
        return solve(1, 0)
    }
    tailrec fun gcd(a:Int,b:Int):Int{
        return if(b==0) a else gcd(b, a%b)
    }
}