package thread.runnable;

public class ThreadMain {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new PrintChar('C'));
        thread1.start();



        Thread thread2 = new Thread(new PrintQuantityChar(10000, 'E'));
        thread2.start();

    }
}
