import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[9999999];
        randomArray(arr);

        System.out.println("Результат мейна: " + sumArray(arr) + ". Время: " + System.currentTimeMillis());
        new ForkJoinPool().invoke(new SumOfArray(arr));
        // Поток в любом случае работает чуть дольше
    }

    public static void randomArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    public static int sumArray(int[] array) {
        int sum = 0;
        for (int j : array) {
            sum = sum + j;
        }
        return sum;
    }
}
