class Solution {
    fun canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean {
           //100넘으면 이김 1번에 1~10
        //재사용 못함
        val maxInt = maxChoosableInteger
        val total = desiredTotal
        val dp = IntArray(1 shl maxInt){-1}
        val max = (1 shl maxInt)-1
        if(total<=0)return true
        if(maxInt*(maxInt+1)/2<total)return false
        fun game(mask:Int, currSum:Int):Boolean{
            if(dp[mask]!=-1) return dp[mask]==1
            for(i in 0 until maxInt){
                val currmask = 1 shl i
                if((mask and currmask)==0) 
                    if(currSum+i+1>=total || game(mask or currmask, currSum+i+1)==false){
                        dp[mask]=1; return true
                    }
            }
            dp[mask]=0
            return false
        }
        return game(0,0)
    }
}