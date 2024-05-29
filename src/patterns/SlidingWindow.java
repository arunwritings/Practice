package patterns;

public class SlidingWindow {
    public static int maxSumSubArray(int[] arr, int k) {
        if (arr.length < k) {
            System.out.println("Invalid input: Array size is smaller than the window size.");
            return -1;
        }
        int maxSum, windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        System.out.println("Maximum sum of a subArray of size " + k + " is " + maxSumSubArray(arr, k));
    }
}
