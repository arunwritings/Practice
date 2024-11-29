package data_structures.graph.medium;

public class IsGraphBipartite_785 {

    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) return false;
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0) {
                if (dfs(graph, i, colors, 1)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int node, int[] colors, int color) {
        colors[node] = color;
        for (int neighbor : graph[node]) {
            if (colors[neighbor] == color) {
                return true;
            }
            if (colors[neighbor] == 0 && dfs(graph, neighbor, colors, -color)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsGraphBipartite_785 isGraphBipartite785 = new IsGraphBipartite_785();
        int[][] graph = new int[][]{
                {1,3},
                {0,2},
                {1,3},
                {0,2}
        };
        System.out.println(isGraphBipartite785.isBipartite(graph));
    }
}
