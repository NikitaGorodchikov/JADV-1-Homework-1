public class Main {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("mainGroup");

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();
        MyThread thread4 = new MyThread();

        Thread threadg1 = new Thread(group, thread1);
        Thread threadg2 = new Thread(group, thread2);
        Thread threadg3 = new Thread(group, thread3);
        Thread threadg4 = new Thread(group, thread4);

        thread1.setName("First");
        thread2.setName("Second");
        thread3.setName("Third");
        thread4.setName("Fourth");

        threadg1.start();
        threadg2.start();
        threadg3.start();
        threadg4.start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        group.interrupt();
    }
}
