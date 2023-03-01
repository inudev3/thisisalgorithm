/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
 data class Result(val min:Int,val max:Int, val size:Int)
class Solution {
    fun largestBSTSubtree(root: TreeNode?): Int {
        fun solve(node:TreeNode? ):Result{
            if(node==null) return Result(Int.MAX_VALUE, Int.MIN_VALUE, 0)
            val left = solve(node!!.left)
            val right = solve(node.right)
            if(left.max<node.`val` && node.`val` <right.min)
                return Result(minOf(node.`val`, left.min), maxOf(node.`val`, right.max), left.size+right.size+1)
            else return Result(Int.MIN_VALUE,Int.MAX_VALUE,maxOf(left.size,right.size))
        }
        val res= solve(root)
        return res.size
    }
}