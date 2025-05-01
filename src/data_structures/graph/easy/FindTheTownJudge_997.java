package data_structures.graph.easy;

public class FindTheTownJudge_997 {

    public int findJudge(int n, int[][] trust) {
        int[] trustScores = new int[n+1];
        for (int[] arr : trust) {
            int a = arr[0];
            int b = arr[1];
            trustScores[a]--;
            trustScores[b]++;
        }
        for (int i=1;i<=n;i++) {
            if (trustScores[i] == n-1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheTownJudge_997 findTheTownJudge997 = new FindTheTownJudge_997();
        int[][] trust = {{1,3},{2,3}};
        System.out.println(findTheTownJudge997.findJudge(3, trust));
    }

}
