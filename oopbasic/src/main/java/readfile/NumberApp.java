package readfile;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberApp {
    private final static String FILE_NAME = "numbers/numbers.txt";
    public static List<Integer> readFile(String fileName) {
        List<Integer> numbers = new ArrayList<>();
        try {
            Reader reader = new FileReader("numbers/numbers.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return numbers;
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max((o1, o2) -> o1 - o2).get();
    }

    public static void writeFile(List<Integer> numbers, String fileName) {
        try {
            File file = new File(fileName);
            Writer writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (int i = 0; i < numbers.size(); i++) {
                bufferedWriter.write(numbers.get(i) + "\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public static void main(String[] args) {


            /*
            Optional<Integer> max = numbers.stream().max(new ComparatorInteger());
            numbers.stream().max(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            int max = numbers.stream().max((o1, o2) -> o1 - o2).get();
            System.out.println(max);

            Function<Integer, Integer> function;
            List<String> list  = numbers.stream().map(new Function<Integer, String>() {
                @Override
                public String apply(Integer integer) {
                    return integer*2 + "Hello";
                }
            }).collect(Collectors.toList());

            List<String> list1  = numbers.stream().map((i) -> i*2 + " HelloAAA").collect(Collectors.toList());

            System.out.println(list1);


            for (int i = 0; i < numbers.size(); i++) {
                bufferedWriter.write(numbers.get(i));
            }
            numbers.stream().forEach(new Consumer<Integer>() {
                @Override
                public void accept(Integer integer) {
                        bufferedWriter.write(integer);
                }
            });
             */

//            bufferedReader.close();

        List<Integer> numbers = readFile(FILE_NAME);
        int max = findMax(numbers);
        numbers.add(max);

        writeFile(numbers, FILE_NAME);
    }

}
