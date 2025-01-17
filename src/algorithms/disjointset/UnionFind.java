package algorithms.disjointset;

public class UnionFind {

    private final int[] parent;
    private final int[] size;
    private final int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        this.size = new int[size];
        for (int i=0;i<size;i++) {
            parent[i] = i;
            rank[i] = i;
            this.size[i] = 1;
        }
    }

    public int find(int element) {   //Time Complexity = O(α(n)), where α(n) is the inverse Ackermann function, which grows very slowly and is nearly constant for all practical purposes.
        if (parent[element] != element) {
            parent[element] = find(parent[element]);
        }
        return parent[element];
    }

    public void unionByRank(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    //Time Complexity: Union operation (by Rank or Size): O(α(n)), as union operations depend on the height or size of the trees.
    public void unionBySize(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (size[rootX] > size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);

        // Union using Rank
        uf.unionByRank(1, 2);
        uf.unionByRank(2, 3);
        uf.unionByRank(4, 5);

        // Check if 1 and 3 are connected (should return true)
        System.out.println(uf.connected(1, 3)); // true

        // Check if 1 and 4 are connected (should return false)
        System.out.println(uf.connected(1, 4)); // false

        // Union using Size
        uf.unionBySize(3, 5);
        uf.unionBySize(1, 5);

        // Check again if 1 and 4 are connected (should return true now)
        System.out.println(uf.connected(1, 4)); // true

    }
}
