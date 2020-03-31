package demo4;

import java.util.Scanner;

class Runner extends Thread{
    private boolean running=true;

    public void run(){
        int c =0;
        while (running){
            System.out.println("Hello " + c++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown(){
        running = false;
    }

}
public class App {
    public static void main(String[] args) {
        System.out.println("Enter any key to terminate the loop");
        Runner runner1 = new Runner();
        runner1.start();

        Scanner s = new Scanner(System.in);
        s.nextLine();
        runner1.shutdown();



    }
}
