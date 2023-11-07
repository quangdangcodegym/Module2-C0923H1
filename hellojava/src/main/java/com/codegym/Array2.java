package com.codegym;

import java.util.Arrays;

public class Array2 {
    public static void main(String[] args) {
        // float: 0.0f, long: 0,
        int a;      // 0
        boolean flag;   //false


        int[][] arr2 = {
                {1, 2, 5},
                {1, 1, 1},
                {4, 0, 4}
        };

        System.out.println(Arrays.toString(listItemMaxTotal(arr2)));
    }
    public static String fakeDeepToString(int [][] arr2){
        String str = "[";
        for(int i = 0; i< arr2.length;i++){
            str += "[";
            for (int j = 0; j < arr2[i].length; j++) {
                str += arr2[i][j];
                if(j != arr2[i].length -1){
                    str += ",";
                }
            }
            str += "]";
            if (i != arr2.length - 1) {
                str += ",";
            }

        }
        str += "]";
        return str;
    }

    public static boolean checkAllPositive(int[][] numbers2) {
        for (int i = 0; i < numbers2.length; i++) {
            for (int j = 0; j < numbers2[i].length; j++) {
                if (numbers2[i][j] < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] listItemMaxTotal(int[][] arr2) {
        int[] rowTotals = new int[arr2.length];
        int index = 0;

        for (int i = 0; i < arr2.length; i++) {
            int totalRow = 0;
            for (int j = 0; j < arr2.length; j++) {
                totalRow += arr2[i][j];
            }
            rowTotals[index] = totalRow;
            index++;

        }

        // Tim max
        int max = rowTotals[0];
        for (int i = 1; i < rowTotals.length; i++) {
            if (max < rowTotals[i]) {
                max = rowTotals[i];
            }
        }
        // Đếm
        int count = 0;
        for (int i = 0; i < rowTotals.length; i++) {
            if (max ==  rowTotals[i]) {
               count++;
            }
        }
        // Tạo mảng kết quả
        int[] results = new int[count];
        int k = 0;
        for (int i = 0; i < rowTotals.length; i++) {
            if (max ==  rowTotals[i]) {
                results[k] = i;
                k++;
            }
        }
        return results;
    }
}
