package thread.runnable;

public class PrintChar implements Runnable{
    private char c;

    public PrintChar(char c) {
        this.c = c;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(c);
        }
    }
}
