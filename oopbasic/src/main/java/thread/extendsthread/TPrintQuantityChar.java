package thread.extendsthread;

public class TPrintQuantityChar extends Thread{

    private int quantity;
    private char c;

    public TPrintQuantityChar(int q, char c) {
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
