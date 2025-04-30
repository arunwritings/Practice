package data_structures.graph.easy;

public class FindCenterOfStarGraph_1791 {

    public int findCenter(int[][] edges) {
        int a = edges[0][0], b = edges[0][1], c = edges[1][0], d = edges[1][1];
        if (a==c || a==d) {
            return a;
        } else return b;
    }

    public static void main(String[] args) {
        FindCenterOfStarGraph_1791 findCenterOfStarGraph1791 = new FindCenterOfStarGraph_1791();
        int[][] edges = new int[][]{{1,2},{2,3},{4,2}};
        System.out.println(findCenterOfStarGraph1791.findCenter(edges));
    }
}
