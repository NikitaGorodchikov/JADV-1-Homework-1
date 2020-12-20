import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        MyCallable callable1 = new MyCallable(4);
        MyCallable callable2 = new MyCallable(6);
        MyCallable callable3 = new MyCallable(3);
        MyCallable callable4 = new MyCallable(5);

        Collection<MyCallable> collection = new ArrayList<>();
        collection.add(callable1);
        collection.add(callable2);
        collection.add(callable3);
        collection.add(callable4);

        callable1.setName("Миша");
        callable2.setName("Петя");
        callable3.setName("Вася");
        callable4.setName("Гриша");

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try {
            int result = threadPool.invokeAny(collection);
            System.out.println("Номер самого быстрого: " + result);
            threadPool.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
