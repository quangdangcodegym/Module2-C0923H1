package utils;

import model.Product;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtils {
    public static void writeFile(List<Product> products, String fileName) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            for (Product p : products) {
                bufferedWriter.write(p + "\n");
            }
        } catch (Exception e) {

        }finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean checkFileExits(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }
}
