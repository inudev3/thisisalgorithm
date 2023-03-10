class Solution {
    fun hIndex(citations: IntArray): Int {
        //
        val n = citations.size
        //
        var l=0
        var r = n-1
        var ans=0
      
        while(l<=r){
            val mid = l+(r-l)/2
            //mid=2, citations[mid]=3
            //n-citations[mid]
            //mid가 커지면 -> h 작아짐
            //mid 작아지면 -> h 
            
            if(n-mid>citations[mid])l = mid+1
            else r = mid-1
        }
        return n-l
    }
}