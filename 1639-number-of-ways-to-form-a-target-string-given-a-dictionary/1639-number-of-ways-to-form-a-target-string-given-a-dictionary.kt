class Solution {
    fun numWays(words: Array<String>, target: String): Int {
        val len = words[0].length
        val n = target.length
        val memo = Array(n) { IntArray(len) { -1 } }
        val mod = 1000000007
        val freq = Array(len) { IntArray(26) }
        for (word in words) {
            for (i in word.indices) {
                freq[i][word[i] - 'a']++
            }
        }
        fun solve(idx: Int, k: Int): Int {
            if (idx == n) return 1
            if (k == len) return 0        
            if (memo[idx][k] != -1) return memo[idx][k]
            val ch = target[idx]
            var res = solve(idx, k + 1).toLong() 
            val count = freq[k][ch - 'a']
            if (count > 0) 
                res = (res + solve(idx + 1, k + 1) * count.toLong() %mod ) % mod
            
            memo[idx][k] = res.toInt()
            return memo[idx][k]
        }
        return solve(0, 0)
    }
}
