import java.io.*;

public class ThreadTest4 implements Runnable {
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++)
                System.out.print(" " + i);
        }
    }

    public static void main(String[] args) {
        Runnable r = new ThreadTest4();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }
}