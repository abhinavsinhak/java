import java.util.Random;

public class MultiThreadedApp {
    public static void main(String[] args) {
        Random rand = new Random();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                int num = rand.nextInt(100);
                System.out.println("Thread 1: Random number generated: " + num);

                // check if number is even or odd
                if (num % 2 == 0) {
                    Thread t2 = new Thread(new Runnable() {
                        public void run() {
                            int square = num * num;
                            System.out.println("Thread 2: Square of " + num + " is " + square);
                        }
                    });
                    t2.start();
                } else {
                    Thread t3 = new Thread(new Runnable() {
                        public void run() {
                            int cube = num * num * num;
                            System.out.println("Thread 3: Cube of " + num + " is " + cube);
                        }
                    });
                    t3.start();
                }
            }
        });
        t1.start();
    }
}