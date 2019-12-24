import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task195 {

    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8));
             BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"),StandardCharsets.UTF_8))) {

            String dataLine = fileReader.readLine();
            String [] inputData = dataLine.split("\\s+");
            int numberOfPanel = Integer.parseInt(inputData[0].trim());
            int panelLength = Integer.parseInt(inputData[1].trim());
            int panelWidth = Integer.parseInt(inputData[2].trim());
            int resultSquare = panelLength * panelWidth * numberOfPanel * 2;
            fileWriter.write(Integer.toString(resultSquare));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
