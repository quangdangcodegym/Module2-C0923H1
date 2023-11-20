package english;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class English {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./english.txt"));


            String line = null;
            Set<String> list = new HashSet<>();
            List<String> lineOKS = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                if(!(line.equals("hey") || line.equals("[Music]") || line.equals("yeah") || line.equals("foreign"))){
                    if (list.add(line)) {
                        lineOKS.add(line + "\n");
                    }
                }
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./english-format.txt"));
            for (String item : lineOKS) {
                bufferedWriter.write(item);
            }

            bufferedReader.close();
            bufferedWriter.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }
}
