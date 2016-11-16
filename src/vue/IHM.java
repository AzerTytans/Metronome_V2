package vue;

import command.Command;
import javafx.beans.DefaultProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import model.CommandName;

/**
 * Created by tp15009314 on 09/11/16.
 */
public class IHM {


    @FXML
    private Label tempo;

    @FXML
    private Circle tempoLed;

    @FXML
    private Circle mesureLed;

    @FXML
    private Slider slider;

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    @FXML
    private Button incButton;

    @FXML
    private Button decButton;

    private CurseurImpl cursor;
    private BoutonStart start;
    private BoutonStop stop;
    private BoutonInc inc;
    private BoutonDec dec;

    public IHM() {
    }

    @FXML
    private void initialize(){

    }

    public Label getTempo() {
            return tempo;
        }


    public Circle getTempoLed() {
            return tempoLed;
        }

    public Circle getMesureLed() {
            return mesureLed;
        }

    public int getSliderPosition() {
            return cursor.getPosition();
        }

    public void onSliderChanged(MouseEvent mouseEvent) {
        cursor.onSliderChanged(mouseEvent);
    }

    @FXML
    public void onStart(ActionEvent actionEvent) {
        start.onStart(actionEvent);
    }
    @FXML
    public void onStop(ActionEvent actionEvent) {
        stop.onStop(actionEvent);
    }
    @FXML
    public void onInc(ActionEvent actionEvent) {
        inc.onInc(actionEvent);
    }
    @FXML
    public void onDec(ActionEvent actionEvent) {
        dec.onDec(actionEvent);
    }
}
