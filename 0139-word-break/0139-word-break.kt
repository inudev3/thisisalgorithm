class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length+1)
        val set = wordDict.toHashSet()
        dp[0]=true
        for(i in 1..s.length){
            for(j in i-1 downTo 0 ){
                val word = s.substring(j,i)
                dp[i] = dp[j]&& (word in set)
                
                if(dp[i])break
            }
        }
        return dp[s.length]
    }
    
}