package data;

import javafx.scene.control.TextArea;
import javafx.stage.Window;
import view.FileLoader;

import java.io.File;
import java.util.List;

public class EditorService {

    public void saveFile(TextArea textArea) {
        FileLoader fileLoader = createLoaderView(textArea);
        FileIOManager fileIO = new FileIOManager();
        File fileToSave = fileLoader.saveFile();
        String text = textArea.getText();
        if (fileToSave != null) {
            fileIO.writeFile(fileToSave, text);
        }
    }

    public void loadFile(TextArea textArea) {
        FileLoader fileLoader = createLoaderView(textArea);
        FileIOManager fileIO = new FileIOManager();
        File fileToOpen = fileLoader.loadFile();
        if (fileToOpen != null) {
            List<String> text = fileIO.readFile(fileToOpen);
            textArea.clear();
            for (String line : text) {
                textArea.appendText(line + "\n");
            }
        }
    }

    private FileLoader createLoaderView(TextArea textArea) {
        return new FileLoader(getStage(textArea));
    }

    private Window getStage(TextArea textArea) {
        return textArea.getScene().getWindow();
    }
}
