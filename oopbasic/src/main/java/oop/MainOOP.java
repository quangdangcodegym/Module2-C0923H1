package oop;

public class MainOOP {
    public static void main(String[] args) {
        /*
        int a = 5;
        g: biến
        Geometric: kiểu dữ liệu
        new Circle(); đối tượng của lớp con

        Geometric: hình
        Geometric g = new Circle();
        Geometric g2 = new Rectangle();

        Animal a = new Tiger();
        a = new Chicken();
         */


        /*
        Biên dịch - compiler (java-> .class):
        c.toString() : JVM hiểu la cua Geometric

        Chạy - Runtime (Goi lệnh java run file .class có hàm main)
        c.toString() : JVM hiểu là của Circle
         */
        Geometric c;


        c = new Rectangle(5, 5);
        c = new Circle(10);




        if (c instanceof Geometric) {
            Circle temp = (Circle) c;
            System.out.println(temp.getAreaCircle());
        }
        if (c instanceof Rectangle) {
            Rectangle temp = (Rectangle) c;
            System.out.println(temp.getArea());
        }






    }
}
