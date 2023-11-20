package com.codegym;

import java.util.Arrays;
import java.util.Scanner;

public class Array3 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Bài 1: Tính giai thừa
        // Bài 2: Viết hàm kiểm tra số nguyên tố

//        System.out.println(factorial(3));

        int [] arr = { 12, 11, 8, 6, 3};
        getSubListPrimes(arr);
        System.out.println(Arrays.toString( getSubListPrimes(arr)));

//        System.out.println(checkPrime(15));
    }
    public static int factorial(int number){
        int result = 1;
        for (int i = number; i >= 1; i--) {
            result = result * i;
        }
        return result;
    }
    public static boolean checkPrime(int number) {
        if (number < 0) {
            return false;
        } else {
            for (int i = 2; i < number - 1; i++) {
                if (number % i == 0) {
                    return false;
                }
            }

        }
        return  true;
    }

    public static int [] getSubListPrimes(int [] numbers){
//        int[] results = new int[numbers.length];

        int count = 0;
        for (int i = 2; i < numbers.length; i++) {
            boolean flag = true;
            if (numbers[i] % i < 2){
                flag = false;
            }else{
                for (int j = 2; j < numbers[i] - 1; j++) {
                    if (numbers[i] % j == 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag == true) {
                count++;
            }
        }
        int[] results = new int[count];
        int index = 0;
        for (int i = 0; i < results.length; i++) {
            if(checkPrime(numbers[i]) == true){
                results[index] = numbers[i];
                index++;
            }
        }
        return results;
    }

    public static void reverseArray(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[numbers.length - 1];
        }
    }
}
