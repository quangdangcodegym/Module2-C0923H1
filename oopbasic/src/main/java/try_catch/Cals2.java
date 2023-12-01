package try_catch;

public class Cals2 {
    int root;

    public Cals2(int root) {
        this.root = ++root;
    }

    public static void main(String[] args) {
        Cals2 c = new Cals2(42);
        c.go();
    }
    public void go(){
        System.out.println(++root);
    }
}
