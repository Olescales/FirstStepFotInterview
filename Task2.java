import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task2 {
    public static void main(String[] args) {

        try (BufferedReader fileReader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("output.txt"))) {

            String strNumber = fileReader.readLine();
            int number = Integer.parseInt(strNumber);
            int sum;
            if (number > 0) {
                sum = (1 + number) * number / 2;
            } else {
                sum = (1 + number) * (Math.abs(number) + 2) / 2;
            }

            fileWriter.write(Integer.toString(sum));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
