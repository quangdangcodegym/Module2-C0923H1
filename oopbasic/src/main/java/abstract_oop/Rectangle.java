package abstract_oop;

public class Rectangle {
    private float width;
    private float height;

    Rectangle(float w, float h) {
        this.width = w;
        this.height = h;
    }

    public float getArea(){
        return this.width * this.height;
    }
}
