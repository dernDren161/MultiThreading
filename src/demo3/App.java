package demo3;

public class App {
    public static void main(String[] args) {
        // Two methods of creating threads in Java
        // 1) implement the Runnable method and create the instance and pass a Thread instance to a Runnable constructor.
        // 2) Extend thread and create its instance.

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i< 10;i++){
                    System.out.println("Hello "+ i);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
    }
}
