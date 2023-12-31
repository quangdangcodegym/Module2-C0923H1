package com.codegym;

public class ArrayMain {
    public static void main(String[] args) {
        /*
        int a = 5;
        // [6,7,1]        => int
        // ["Quang", "Minh", "Khoa"]    => String

        // numbers = [0,0,0]
        int [] numbers = new int[3];        // khởi mảng với 3 phần tử
        numbers[0]  = 6;
        numbers[1]  = 7;
        numbers[2]  = 1;

        int [] number1s = {7,6,1};          // khởi tạo nhanh 1 mảng


        System.out.println(numbers.length);

        String[] names = {"Quang", "Minh", "Khoa"};
                for (int i = 0; i < names.length; i++) {
                    System.out.println(names[i]);
         }

         // Biến mảng: numbers, names
         // Đối tượng mảng: new int[3],  {"Quang", "Minh", "Khoa"};

         int [] numbers = new int[3];
         numbers = null;            // khong gắn tham chiếu thì giá trị sẽ là null
         System.out.println(numbers.length);


         // Duyệt bằng foreach
        String[] names = {"Quang", "Minh", "Khoa"};
        for (String name : names) {
            System.out.println(name);
        }
         */

        /**
         B1: Tìm số lớn nhất trong mảng
         B2: Tìm số lớn thứ 2 trong mảng
         B3: Tìm vị trí số chẵn đầu tiên trong mảng
         B4: Tính tổng các số chẵn trong mảng
         */
        int [] numbers = {13, 6, 2, 9, 7};

        printArray(numbers);
        System.out.println(findMax(numbers));
        System.out.println(findFirstIndexEven(numbers));

    }
    public static void printArray(int [] arr){
        for(int i = 0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static int getTotal(int [] numbers){
        int  total= 0;      // biến cục bô: chỉ có phạm vi trong hàm, ra khỏi hàm ko có ton tại

        for(int i=0;i<numbers.length;i++){
            total += numbers[i];
        }
        return total;
    }

    public static int findMax(int [] numbers){
        if (numbers.length == 0) {
            throw new RuntimeException("Mảng ko hợp lệ");
        }
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static int findFirstIndexEven(int [] numbers){
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                return i;
            }
        }
        return -1;
    }

}
