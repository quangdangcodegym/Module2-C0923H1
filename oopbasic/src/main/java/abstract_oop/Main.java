package abstract_oop;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        Bird b = new Bird();
//        b.fly();

        Flyable b = new Flyable() {
            @Override
            public void fly() {
                System.out.println("BAY LEN BAY LEN");
            }
        };


        Flyable b1 = () -> System.out.println("BAY LEN BAY LEN");


        Comparator c = new Comparator<Rectangle>() {
            @Override
            public int compare(Rectangle o1, Rectangle o2) {
                if (o1.getArea() > o2.getArea()) {
                    return 1;
                }else if(o1.getArea() == o2.getArea()){
                    return 0;
                }else{
                    return -1;
                }
            }
        };

        Comparator<Rectangle> c1 = (o1, o2)-> {
            return Float.compare(o1.getArea(), o2.getArea());
        };

        Comparator<Rectangle> c2 = (o1, o2)-> Float.compare(o1.getArea(), o2.getArea());


        System.out.println(Float.compare(13.7f, 3.7f));

        System.out.println("A".compareTo("a"));
    }
}
