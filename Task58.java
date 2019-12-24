import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task58 {

    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8));
             BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), StandardCharsets.UTF_8))) {


            int numberOfMatrix = Integer.parseInt(fileReader.readLine().trim());


            String[] result = new String[numberOfMatrix];

            while (fileReader.ready()) {
                for (int i = 0; i < numberOfMatrix; i++) {
                    String lineContainsWidthAndLength = fileReader.readLine();
                    String[] widthAndLength = lineContainsWidthAndLength.split("\\s+");
                    int sizeOfMatrix = Integer.parseInt(widthAndLength[0]);
                    String[][] array = new String[sizeOfMatrix][];
                    for (int j = 0; j < sizeOfMatrix; j++) {
                        String lineContainsNumbers = fileReader.readLine();
                        String[] numbers = lineContainsNumbers.split("\\s+");
                        array[j] = numbers;
                    }
                    result[i] = isMatrixSympathetic(array);
                }
            }

            for (String string : result) {
                fileWriter.write(string + System.lineSeparator());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String isMatrixSympathetic(String[][] multyDimArray) {
        String result = "YES";
        if (multyDimArray.length == 1 || multyDimArray[0].length == 1) {
            return result;
        } else {
            for (int i = 0; i < multyDimArray.length - 1; i++) {
                for (int j = 0; j < multyDimArray[i].length - 1; j++) {
                    if (multyDimArray[i][j].equals(multyDimArray[i + 1][j])
                            && multyDimArray[i][j].equals(multyDimArray[i][j + 1])
                            && multyDimArray[i][j].equals(multyDimArray[i + 1][j + 1])) {
                        result = "NO";
                        break;
                    }
                }
            }
        }
        return result;
    }
}
