package thread.runnable;

public class PrintQuantityChar implements Runnable{
    private int quantity;
    private char c;

    public PrintQuantityChar(int q, char c) {
        this.quantity = q;
        this.c = c;
    }

    @Override
    public void run() {
        for (int i = 1; i <= quantity; i++) {
            System.out.println(" " + c);
        }
    }
}
