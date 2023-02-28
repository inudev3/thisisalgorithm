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
class Solution {
    
   
    fun longestConsecutive(root: TreeNode?): Int {
        return solve(root, root!!.`val`, 0)
    }
    fun solve(node:TreeNode?,parentVal:Int, len:Int):Int{
        if(node==null) return len
        val newlen = if(node.`val` == parentVal+1) len+1 else 1
        val left = solve(node?.left, node?.`val`, newlen)
        val right = solve(node?.right, node?.`val`, newlen)
        
        return maxOf(len, left,right)
    }
}