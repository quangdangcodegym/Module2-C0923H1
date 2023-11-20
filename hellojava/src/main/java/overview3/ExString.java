package overview3;

public class ExString {
    public static void main(String[] args) {
        // BÀI TẬP: Viết hàm in ra các số toàn lẻ?
        int [] arr = { 23, 35, 1, 779, 36};
        printOdd(arr);
    }

    public static void printOdd(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            String item = String.valueOf(numbers[i]);
            String [] items = item.split("");       // [ "2", "3"]
            boolean flag = true;            // mới đầu gia su toan le
            for (int j = 0; j < items.length; j++) {
                int n = Integer.parseInt(items[j]);     // "2" => 2
                if (n % 2 == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                System.out.println(numbers[i]);
            }

        }
    }
}
