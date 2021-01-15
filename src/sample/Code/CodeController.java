package sample.Code;

import Interpreter.Commands.Fundation.CodeBlock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

public class CodeController {
    Thread t;
    @FXML
    public RadioButton radioButtonAutoPilot;

    @FXML
    private TextArea textAreaCode;

    private CodeBlock code;

    private void load() {
        this.code = new CodeBlock(textAreaCode.getText());
    }

    private void execute() {
        try {
            load();
            code.execute();
        } catch (Exception e) {

        }
    }

    public void radioButtonAutoPilotClick(ActionEvent actionEvent) {
        if(radioButtonAutoPilot.isSelected()) {
            try {
                t = new Thread(this::execute);
                t.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            t.interrupt();
        }
    }
}
