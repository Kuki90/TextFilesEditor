package view;

import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;

public class FileLoader {

    private FileChooser fileChooser;
    private Window window;

    public FileLoader(Window window) {
        this.window = window;
        fileChooser = new FileChooser();
    }

    public File saveFile() {
        fileChooser.setTitle("Save file");
        return fileChooser.showSaveDialog(window);
    }

    public File loadFile() {
        fileChooser.setTitle("Load file");
        return fileChooser.showOpenDialog(window);
    }
}
