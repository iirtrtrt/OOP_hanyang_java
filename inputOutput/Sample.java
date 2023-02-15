package inputOutput;

import java.io.FileOutputStream;
import java.io.IOException;

public class Sample {
    public static void main(String[] args) throws IOException {
        FileOutputStream output = new FileOutputStream("out.txt");
        output.close();
    }
}