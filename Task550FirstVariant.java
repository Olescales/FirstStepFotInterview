import java.io.*;
import java.nio.charset.StandardCharsets;


public class Task550FirstVariant {

    public static void main(String[] args) throws IOException {

            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8));
                 BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"),StandardCharsets.UTF_8))) {
                int year = Integer.parseInt(fileReader.readLine());

                int dayOfProgrammer = isBissextileYear(year) ? 12 : 13;

                String day = String.format("%02d/09/%04d", dayOfProgrammer, year);
                fileWriter.write(day);
            }
    }

    public static boolean isBissextileYear (int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}
