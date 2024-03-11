package algorithms.search_algos;

public class JumpSearch {

    public static int jumpSearch(int[] arr, int key) {
        int array_size = arr.length;
        int block_size = (int) Math.floor(Math.sqrt(array_size));
        int prev = 0;
        while (arr[Math.min(block_size, array_size)-1] < key) {   //Time Complexity = O(?n)
            prev = block_size;
            block_size += (int) Math.floor(Math.sqrt(array_size));
            if (prev >= array_size) return -1;
        }
        while (arr[prev] < key) {
            prev ++;
            if (prev == Math.min(block_size, array_size)) return -1;
        }
        if (arr[prev] == key)
            return prev;
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        int key = 13;
        int index = jumpSearch(array, key);
        System.out.println(key + " is found at index "+index);
    }
}
