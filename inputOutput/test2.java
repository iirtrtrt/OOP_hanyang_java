package inputOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) throws IOException {
        Scanner inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new Scanner(new FileInputStream("original.txt"));
            outputStream = new PrintWriter(new FileOutputStream("numbered.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Problem opening files");
            System.exit(0);
        }

        String line = null;
        int count = 0;

        while (inputStream.hasNextLine()) {
            line = inputStream.nextLine();
            count++;
            outputStream.println(count + " " + line);
        }

        inputStream.close();
        outputStream.close();
    }
}
