package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileIOManager {

    public void writeFile(File file, String text) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, false))) {
            writer.append(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> readFile(File file) {
        try {
            return Files.readAllLines(file.toPath(), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
