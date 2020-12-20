import java.util.concurrent.RecursiveTask;

public class SumOfArray extends RecursiveTask<Integer> {
    int[] arr;

    public SumOfArray(int[] arr) {
        this.arr = arr;
    }


    @Override
    protected Integer compute() {
        int sum = 0;
        for (int j : arr) {
            sum = sum + j;
        }
        System.out.println("Результат потока: " + sum + ". Время: " + System.currentTimeMillis());
        return sum;
    }
}
