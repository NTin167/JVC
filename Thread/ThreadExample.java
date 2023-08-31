package Thread;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        // T?o v? kh?i ch?y thread in c?c s? ch?n
        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 100000; i += 2) {
                System.out.println("Even: " + i);
            }
        });

        // T?o v? kh?i ch?y thread in c?c s? l?
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 10000; i += 2) {
                System.out.println("Odddddddddddddddddddddddddddddddddddddddd: " + i);
            }
        });

        evenThread.start();
        oddThread.start();

        // ??i cho ??n khi c? hai thread k?t th?c
        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have finished.");
    }
}
