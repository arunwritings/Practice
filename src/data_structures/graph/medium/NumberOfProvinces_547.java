package data_structures.graph.medium;

public class NumberOfProvinces_547 {

    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinceCount = 0;
        for (int i=0;i<cities;i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinceCount++;
            }
        }
        return provinceCount;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int current) {
        visited[current] = true;
        for (int neighbour = 0;neighbour<isConnected.length;neighbour++) {
            if (!visited[neighbour] && isConnected[current][neighbour] == 1) {
                dfs(isConnected, visited, neighbour);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces_547 numberOfProvinces547 = new NumberOfProvinces_547();
        int[][] isConnected1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println("Number of Provinces: " + numberOfProvinces547.findCircleNum(isConnected1));
    }
}
