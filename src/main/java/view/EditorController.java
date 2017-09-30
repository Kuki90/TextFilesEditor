package view;

import data.EditorService;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
    private void loadButtonMouseClicked() {
        EditorService editorService = new EditorService();
        editorService.loadFile(textArea);
    }

    @FXML
    private void saveButtonMouseClicked() {
        EditorService editorService = new EditorService();
        editorService.saveFile(textArea);
    }
}
