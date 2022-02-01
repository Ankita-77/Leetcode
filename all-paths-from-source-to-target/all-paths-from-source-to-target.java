class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return ans;
        }

        dfs(graph, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> ans){
        path.add(node);
        if(node == graph.length-1){
            ans.add(new ArrayList<>(path));
            return;
        }
    
        for(int it : graph[node]){
            dfs(graph, it, path, ans);
            path.remove(path.size()-1);
        }
    }
}