package WaitAndNotify;

import java.util.Scanner;

public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome guys!!");
        OS o = new WaitAndNotify().new OS();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    o.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    o.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    public class OS{
        public void producer() throws InterruptedException{
            synchronized (this){
                System.out.println("Producer starting off");
                wait();
                System.out.println("Again started off with Producer!!");
            }
        }

        public void consumer() throws InterruptedException{
            Scanner s = new Scanner(System.in);
            Thread.sleep(2000);
            synchronized (this){
                System.out.println("Consumer started off");
                s.nextLine();
                notify();
            }
        }
    }
}
