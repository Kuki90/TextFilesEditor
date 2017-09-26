package view;

import data.FileIOManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;

import java.io.File;
import java.util.List;

public class EditorController {

    @FXML
    TextArea textArea;

    @FXML
    private ImageView saveButton;

    @FXML
    private ImageView loadButton;

    @FXML
    private void mouseOverOn(MouseEvent e) {
        e.getPickResult().getIntersectedNode().setEffect(new Glow(0.4));
    }

    @FXML
    private void mouseOverOff(MouseEvent e) {
        loadButton.setEffect(null);
        saveButton.setEffect(null);
    }

    @FXML
    private void mouseClicked(MouseEvent e) {
        String buttonType = buttonPressedType(e);
        if ("saveButton".equals(buttonType)) {
            saveFile();
        } else {
            loadFile();
        }
    }

    private String buttonPressedType(MouseEvent e) {
        return e.getPickResult().getIntersectedNode().getId();
    }

    private void loadFile() {
        FileLoader fileLoader = createLoaderView();
        FileIOManager fileIO = new FileIOManager();
        File fileToOpen = fileLoader.loadFile();
        List<String> text = fileIO.readFile(fileToOpen);
        textArea.clear();
        for (String line : text) {
            textArea.appendText(line + "\n");
        }
    }

    private void saveFile() {
        FileLoader fileLoader = createLoaderView();
        FileIOManager fileIO = new FileIOManager();
        File fileToSave = fileLoader.saveFile();
        String text = textArea.getText();
        fileIO.writeFile(fileToSave, text);
    }

    private FileLoader createLoaderView() {
        return new FileLoader(getStage());
    }

    private Window getStage() {
        return textArea.getScene().getWindow();
    }
}
