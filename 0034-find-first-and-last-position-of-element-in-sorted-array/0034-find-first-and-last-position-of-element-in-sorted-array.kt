class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val start = findFirstIndex(nums,target)
        if(start==-1)return intArrayOf(-1,-1)
        val end= findLastIndex(nums,target)
        return intArrayOf(start,end)
    }
    private inline fun findFirstIndex(A: IntArray, K: Int): Int {
        val N = A.size
        var low = 0
        var high = N - 1
        var ans = -1
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (A[mid] == K) {
                ans = mid
                high = mid - 1 // we might have got a right-most element, so be greedy and do search on the left
            } else if (A[mid] > K) { 
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return ans
    }
    
    private inline fun findLastIndex(A: IntArray, K: Int): Int {
        val N = A.size
        var low = 0
        var high = N - 1
        var ans = -1
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (A[mid] == K) {
                ans = mid
                low = mid + 1 // we might have got a left-most element, so be greedy and do search on the right
            } else if (A[mid] > K) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return ans
    }
}