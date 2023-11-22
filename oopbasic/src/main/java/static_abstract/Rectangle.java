package static_abstract;

public class Rectangle {
    private static float width;
    private static float height;

    public Rectangle(){

    }

    public Rectangle(float w, float h) {
        this.width = w;
        this.height = h;
    }

    public static String showHang() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
