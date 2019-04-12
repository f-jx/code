import java.io.*;

public class ThreadTest3 implements Runnable {
    public synchronized void run() {
        for (int i = 0; i < 10; i++)
            System.out.print(" " + i);
    }

    public static void main(String[] args) {
        Runnable r = new ThreadTest3();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }
}