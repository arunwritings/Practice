package data_structures.linkedlists.easy;

public class DesignHashSet_705 {

    public DesignHashSet_705() {
        set = new boolean[1000001];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }

    private boolean[] set = new boolean[1000001];

    public static void main(String[] args) {
        int key = 3;
        DesignHashSet_705 obj = new DesignHashSet_705();
        obj.add(key);
        obj.remove(key);
        boolean param_3 = obj.contains(key);
        System.out.println(param_3);
    }
}
