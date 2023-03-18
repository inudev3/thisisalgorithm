class Solution {
    fun shortestPathLength(graph: Array<IntArray>): Int {
        //
        val n = graph.size
        val adj = Array(n){mutableListOf<Int>()}
        for(i in 0..n-1){
            adj[i].addAll(graph[i].toList())
        }
        val max = 1 shl n
        val dist = Array(max){IntArray(n){-1}}
        val queue = ArrayDeque<Pair<Int,Int>>()
        for(i in 0..n-1){
            val mask = 1 shl i
            queue.add(i to mask)
            dist[mask][i] = 0
        }
        while(queue.isNotEmpty()){
            for(i in queue.indices){
                val (lead, path) = queue.poll()
                if(path==max-1)return dist[path][lead]
                for(next in adj[lead]){
                    val newpath = path or (1 shl next)
                    if(dist[newpath][next]!=-1)continue
                    dist[newpath][next] = dist[path][lead] +1
                    queue.add(next to newpath)
                }
            }
        }
        return Int.MAX_VALUE
    }
}