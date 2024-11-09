package data_structures.linkedlists.easy;

import java.util.Arrays;

public class DesignHashMap_706 {

    private int[] data = new int[1000001];
    public DesignHashMap_706() {
        Arrays.fill(data, -1);
    }

    public void put(int key, int value) {
        data[key] = value;
    }

    public int get(int key) {
        return data[key];
    }

    public void remove(int key) {
        data[key] = -1;
    }

    public static void main(String[] args) {
        DesignHashMap_706 designHashMap706 = new DesignHashMap_706();
        int key = 3;
        int value = 1;
        designHashMap706.put(key, value);
        System.out.println(designHashMap706.get(key));
        designHashMap706.remove(key);
    }
}
