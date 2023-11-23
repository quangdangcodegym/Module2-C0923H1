package stack_queue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {

        /*
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(10);
        stack.push(5);

        stack.pop();
        stack.peek();


        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        Integer [] arr = {5, 1, 7, 9, 3};

        reverseArray(arr);
        System.out.println(Arrays.toString(arr));

        int a = 8;
        System.out.println(recursiveToBinary(a));
         */

        Queue<Integer> queue = new PriorityQueue<>();


//        queue.remove();
        System.out.println(queue.poll());

        System.out.println("HELLO QUOC PHU");


    }

    public static void reverseArray(Integer[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.add(arr[i]);
        }
        int index = 0;
        while (!stack.isEmpty()) {
            arr[index] = stack.pop();
            index++;
        }
    }

    public static String convertToBinary(int number) {
        Stack<Integer> stack = new Stack<>();
        while (number != 0) {
            stack.push(number % 2);
            number = number / 2;
        }
        String str = "";
        while (!stack.isEmpty()) {
            str += stack.pop();
        }
        return str;
    }
    public static String recursiveToBinary(int number) {
        if (number == 0) {
            return "";
        }
        return recursiveToBinary(number / 2) + (number % 2);
    }

}
