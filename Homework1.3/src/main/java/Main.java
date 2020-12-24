import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        randomArray(arr);

        System.out.println("Результат мейна: " + sumArray(arr) + ". Время: " + System.currentTimeMillis());
        System.out.println("Результат задачи: " + SumOfArray.sumArray(arr) + ". Время: " + System.currentTimeMillis());
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
