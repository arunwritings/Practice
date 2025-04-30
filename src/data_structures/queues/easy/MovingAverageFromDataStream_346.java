package data_structures.queues.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream_346 {

    private final Queue<Integer> queue;
    int size;
    int sum;

    public MovingAverageFromDataStream_346(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        queue.add(val);
        sum += val;
        return (double) sum / queue.size();
    }

    public static void main(String[] args) {
        MovingAverageFromDataStream_346 movingAverage = new MovingAverageFromDataStream_346(3);
        System.out.println(movingAverage.next(1));  // Output: 1.0
        System.out.println(movingAverage.next(10)); // Output: (1 + 10) / 2 = 5.5
        System.out.println(movingAverage.next(3));  // Output: (1 + 10 + 3) / 3 = 4.6667
        System.out.println(movingAverage.next(5));  // Output: (10 + 3 + 5) / 3 = 6.0
    }
}
