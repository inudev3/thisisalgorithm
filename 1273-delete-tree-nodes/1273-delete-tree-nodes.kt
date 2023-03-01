class Solution {
    fun deleteTreeNodes(nodes: Int, parent: IntArray, value: IntArray): Int {
        //합이 0인 subtree 제거해라
        val n = nodes
        val graph = hashMapOf<Int,MutableList<Int>>()
        for(i in 0..n-1){
            val list = graph.getOrDefault(parent[i], mutableListOf())
            if(parent[i]!=-1)list.add(i)
            graph[parent[i]] = list
        }
        var count= n
        fun findSum(cur:Int):Pair<Int,Int>{
            var res = value[cur]
            val children =graph.getOrDefault(cur, mutableListOf())
            var count=1
            for(node in children){
                val (sum, cnt) = findSum(node)
                res+=sum
                count+=cnt
            }

            return res to if(res==0) 0 else count
        }
        return findSum(0).second
    }
}