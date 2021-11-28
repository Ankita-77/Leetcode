class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        discover(0, graph, paths, new ArrayList<>());
        return paths;
    }
    
    private void discover(int v, int[][] graph, List<List<Integer>> paths, List<Integer> path) {
        path.add(v);
        if (v == graph.length - 1) {
            paths.add(new ArrayList<>(path));
        } else {
            for (int u : graph[v]) {
                discover(u, graph, paths, path);
            }
        }
        path.remove(path.size() - 1);
    }
}