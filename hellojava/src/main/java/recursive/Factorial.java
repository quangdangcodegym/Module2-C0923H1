package recursive;

public class Factorial {
    public static void main(String[] args) {
//        System.out.println(factorial1(5));
//        System.out.println(factorial1(3));

        int[] arr = {3, 7, 9, 11, 15, 17, 22};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 111));
    }
    public static int factorial(int number){
        int result = 1;
        for (int i = number; i >= 1; i--) {
            result = result * i;
        }
        return result;
    }

    public static int factorial1(int number){
        if (number == 1) {
            return 1;
        }
        return number * factorial1(number - 1);
    }

    public static int binarySearch(int[] numbers, int left, int right, int value) {
        int mid = left + (right - left)/2;

        if(left <= right){
            if (value == numbers[mid]) {
                return mid;
            }else if(numbers[mid] < value){
                return binarySearch(numbers, mid + 1, right, value);
            } else {
                return binarySearch(numbers, left, mid - 1, value);
            }
        }else {
            return -1;
        }
    }

}
