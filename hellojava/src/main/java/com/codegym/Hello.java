package com.codegym;

import java.util.Arrays;
import java.util.Scanner;

/**
 Cú pháp tạo class: public class Hello
 */
public class Hello {
    // Hàm khởi tạo: giống contructor bên js
    public Hello(){

    }


    public static Scanner scanner = new Scanner(System.in);         // scanner: đặt tên chi cũng được
    // Hàm main: hàm chạy đầu tiên, chạy chính
    public static void main(String[] args) {

        System.out.println(Arrays.toString(args));
        /**
        System.out.println("HELLO 3AE");            //print line: println In ra màn hình
        System.out.print(20);                       // println: xuống dong, print: trên 1 dòng
         **/

        int a = 5;          // let/var/const a = 5;
        // 8 kiểu dữ liệu nguyên thủy:
        // số nguyên: int-4byte, long: 8byte, byte: 1byte
        // số thực: float:4byte, double: 8byte
        // boolean: true/false
        // String: "Chuỗi" , KO phải dấu nháy đơn 'chuoi'
        // char: 'a', 'A', 'Ac'

        // Lưu số 255;
//        int number = 127;           // dư
//        long number1 = 127;         // quá dư
//        byte number2 = 127;         // vừa đủ

        // 1byte = 8bit = [0-1,X,X,X,X,X,X,X]
        // [0,0,0,0,0,0,0,0] => 0
        // [0,0,0,0,0,1,0,1] => 5
        // -128-> 127 : 256 = 2^8 số
        // -2^7 -> 2^7-1

        // 4byte: 32bit
        // -2^31 -> 2^31-1




        /**
         System.out.println("Mời nhập: ");
         int number = scanner.nextInt();
         if(number > 0){
            System.out.println("OK");
         }
         System.out.println("Số mới nhập là: " + number);
         Bài tập: nhập vào 1 số nếu như số đó bé hơn 10 thì nhập lại
         */
        int number = 0;
        do{
            System.out.println("Mời nhập: ");
            number = scanner.nextInt();

        }while (number > 10);


        System.out.println("KẾT THÚC CHƯƠNG TRÌNH");

        /*
        Menu:
            1. Bia
            2. Heo
            3. Bò
        Cho người dùng chọn:
            chon 1: Hiển thị Bạn đang chọn Bia
            chon 2: Hiển thị Bạn đang chọn Heo
            chọn 10,-5 (chọn ko đúng): Thì thông báo không hợp lệ và cho chọn lại
         */


    }

}
