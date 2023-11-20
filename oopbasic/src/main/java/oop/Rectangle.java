package oop;

public class Rectangle extends Geometric{
    private long width;   // 0
    private long height;  //0

    public Rectangle(long w, long h) {
        this.width = w;
        this.height = h;
    }
    public Rectangle(){

    }
    public long getArea(){
        return this.width * this.height;
    }

    @Override
    public String toString(){
        // oop.Square@61443d8f
        return String.format("width: %s height: %s", this.width, this.height);
    }

    public long getHeight() {
        return height;
    }

    public long getWidth() {
        return width;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public void setWidth(long width) {
        this.width = width;
    }
}
