package thread.extendsthread;

public class TPrintChar extends Thread{
    private char c;

    public TPrintChar(char c) {
        this.c = c;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(c);
        }
    }
}
