import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task254 {

    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8));
             BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), StandardCharsets.UTF_8))) {

            int numberOfCountyes = Integer.parseInt(fileReader.readLine().trim());
            int[] result = new int[numberOfCountyes];

            String lineOfApplications = fileReader.readLine();
            String[] applications = lineOfApplications.split("\\s+");
            int numberOfIterations = Integer.parseInt(fileReader.readLine());
            Map<String, String> replacementMap = new HashMap<>();
            for (int i = 0; i < numberOfIterations; i++) {
                String pair = fileReader.readLine();
                String[] keyAndvalue = pair.split("\\s+");
                replacementMap.put(keyAndvalue[0],keyAndvalue[1]);
            }

            String[] output = Arrays.copyOf(applications,applications.length);
            for (int i = 0; i < applications.length; i++) {
                for (String key: replacementMap.keySet()) {
                    if (applications[i].equals(key)) {
                        output[i] = replacementMap.get(key);
                        break;
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (String application: output) {
                stringBuilder.append(application).append(" ");
            }
            fileWriter.write(stringBuilder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
