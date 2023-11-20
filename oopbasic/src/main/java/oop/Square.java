package oop;

public class Square extends Rectangle {
    private boolean filled;

    public Square(){
        super();
    }

    @Override
    public String toString(){

        return String.format("Geometric: color - %s, filled - %s, dateCreated: %s. Side %s x %s",this.getColor(), this.isFilled(), this.getDateCreated(), this.getWidth(), this.getHeight());
    }

    public Square(long side) {
        /*
        this.width = side;
        this.height = side;

        // từ khóa super: dùng để gọi đến hàm khởi tạo và phương thức, thuộc tính của lop cha
        super(side, side);
         */
        super();
        setHeight(side);
        setWidth(side);

    }
    public static void main(String[] args) {
        Square square1 = new Square(5);

        System.out.println(square1.toString());
    }
}
