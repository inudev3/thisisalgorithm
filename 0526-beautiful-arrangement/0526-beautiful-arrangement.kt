class Solution {
    fun countArrangement(n: Int): Int {
        var count=0
        val nums = IntArray(n){it+1}
        fun backtrack(idx:Int){
            if(idx==n)count++
            for(i in idx until n){
                swap(nums,i,idx)
                if(nums[idx]%(idx+1)==0 || (idx+1)%nums[idx]==0)backtrack(idx+1)
                swap(nums,idx,i)
            }
        }
        backtrack(0)
        return count
    }
    inline fun swap(arr:IntArray, i:Int,j:Int){
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }
}