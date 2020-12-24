import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumOfArray extends RecursiveTask<Integer> {
    static final int SEQUENTIAL_THRESHOLD = 5000;

    int low;
    int high;
    int[] array;

    SumOfArray(int[] arr, int low, int high) {
        this.array = arr;
        this.low = low;
        this.high = high;
    }

    protected Integer compute() {
        if (high - low <= SEQUENTIAL_THRESHOLD) {
            int sum = 0;
            for (int i = low; i < high; ++i)
                sum += array[i];
            return sum;
        } else {
            int mid = low + (high - low) / 2;
            SumOfArray left = new SumOfArray(array, low, mid);
            SumOfArray right = new SumOfArray(array, mid, high);
            left.fork();
            int rightAns = right.compute();
            int leftAns = left.join();
            return leftAns + rightAns;
        }
    }

    static int sumArray(int[] array) {
        return ForkJoinPool.commonPool().invoke(new SumOfArray(array, 0, array.length));
    }
}
