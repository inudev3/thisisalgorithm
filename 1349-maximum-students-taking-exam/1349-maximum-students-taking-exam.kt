class Solution {
    fun maxStudents(seats: Array<CharArray>): Int {
        val m = seats.size
        val n = seats[0].size
        val validRows = IntArray(m)
        for(i in 0..m-1){
            for(j in 0..n-1)validRows[i] = (validRows[i] shl 1) + if(seats[i][j]=='.') 1 else 0
        }
        val dp = Array(m){IntArray(1 shl n){-1}}
        val max= (1 shl n)
        var ans = 0
        for(i in 0..m-1){
            
            for(mask in 0..max-1){
                if(mask and validRows[i] == mask &&mask and(mask shr 1) ==0) {
                    if(i==0)dp[i][mask] = Integer.bitCount(mask)
                    else {
                        for(prevMask in 0..max-1){
                            if(mask and (prevMask shr 1)==0 && (mask shr 1) and prevMask==0 && dp[i-1][prevMask]!=-1)dp[i][mask] = maxOf(dp[i][mask], dp[i-1][prevMask]+Integer.bitCount(mask))
                        }
                    }
                    ans = maxOf(ans, dp[i][mask])
                }
            
            }
        }
        return ans
    }
}