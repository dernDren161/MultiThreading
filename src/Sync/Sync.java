package Sync;

// We basically learn the advantages of using the "synchronized" variable type with Java Multi Threading application.
public class Sync {
    int count =0;

    public synchronized void increment(){
        count++;
    }
    public static void main(String[] args) {
        Sync app = new Sync();
        app.doWork();
    }
    public void doWork(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The Count is : "+ count);

    }
}
