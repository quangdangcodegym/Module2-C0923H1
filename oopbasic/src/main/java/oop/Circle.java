package oop;

public class Circle extends Geometric {
    private float radius;
    public Circle(){

    }

    public Circle(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }


    public float getAreaCircle(){
        return (float) (Math.PI * this.radius * this.radius);
    }
    @Override
    public String toString() {
        return super.toString() + " " +  String.format("Circle: %s ", this.radius);
    }
}
