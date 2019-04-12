import java.io.*;

//implements Runnable
public class ThreadTest1 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.print(" " + i);
    }

    public static void main(String[] args) {
        new ThreadTest1().start();
        new ThreadTest1().start();
    }
}