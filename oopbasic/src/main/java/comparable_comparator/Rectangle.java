package comparable_comparator;

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

    public float getPrimiter(){
        return (this.width + this.height) *2;
    }

    @Override
    public String toString() {
        return String.format("W: %s, H: %s, Area: %s", this.width, this.height, this.getArea());
    }

//    @Override
//    public int compareTo(Rectangle o) {
//        return Float.compare(this.getArea(), o.getArea());
//    }
}
