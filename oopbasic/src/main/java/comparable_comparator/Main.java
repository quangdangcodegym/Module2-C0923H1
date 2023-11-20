package comparable_comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Rectangle[] list = new Rectangle[3];

        list[0] = new Rectangle(3, 2);
        list[1] = new Rectangle(1, 6);
        list[2] = new Rectangle(2, 2);

//        Arrays.sort(list);

//        Arrays.sort(list, new ComparatorArea());

//        Arrays.sort(list, new Comparator<Rectangle>() {
//            @Override
//            public int compare(Rectangle o1, Rectangle o2) {
//                return Float.compare(o1.getPrimiter(), o2.getPrimiter());
//            }
//        });

        Arrays.sort(list, (o1, o2) -> Float.compare(o1.getPrimiter(), o2.getPrimiter()));
        printArray(list);
    }

    public static void printArray(Rectangle[] rectangles) {
        for (int i = 0; i < rectangles.length; i++) {
            System.out.println(rectangles[i]);
        }
    }

    /*
    public static void mySort(Rectangle[] rectangles){
        for (int i = 0; i < rectangles.length - 1; i++) {
            for (int j = i + 1; j < rectangles.length; j++) {
                if(rectangles[j].compareTo(rectangles[j]) < 0 ){
                    // code doi cho
                }
//                if(rectangles[j].getArea() < rectangles[i].getArea()){
                    // code doi cho
//                }
            }
        }
    }
    public static void mySort(Rectangle[] rectangles, Comparator<Rectangle> comparator){
            for (int i = 0; i < rectangles.length - 1; i++) {
                for (int j = i + 1; j < rectangles.length; j++) {
                    if(comparator.compare(rectangles[j], rectangles[i]) < 0){
                        // code doi cho
                    }
    //                if(rectangles[j].getArea() < rectangles[i].getArea()){
                    // code doi cho
    //                }
                }
            }
        }

     */


}
