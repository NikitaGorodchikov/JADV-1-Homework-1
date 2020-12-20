public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2000);
                System.out.printf("Привет! Я поток с именем %s\n", getName());
            }
        } catch (InterruptedException e) {

        } finally {
            System.out.printf("Поток %s завершен.\n", getName());
        }
    }
}
