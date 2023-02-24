class Solution {
    fun PredictTheWinner(nums: IntArray): Boolean {
        val N = nums.size
        if(N==1)return true
        val sum = nums.sum()
        fun game(left:Int,right:Int):Int{
            if(left>right)return 0
            val both = game(left+1,right-1)
            val choice1 =nums[left]+minOf(game(left+2, right), both)
            val choice2 = nums[right]+minOf(both, game(left, right-2))
            return maxOf(choice1,choice2)
        }
        val res = game(0,N-1)
        if(res<sum-res)return false
        return true
        /// 0 1    n-1
    }
}