package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;


public class IHM {
    @FXML
    private Label tempo;

    @FXML
    private Label mesure;

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

    public void onSliderChanged(MouseEvent mouseEvent) {
       double val = slider.getValue();
        cursor.onSliderChanged(mouseEvent, val);
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

    public void marquerMesure(){
        mesureLed.setFill(Paint.valueOf("red"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mesureLed.setFill(Paint.valueOf("blue"));
    }

    public void marquerTempo(){

        tempoLed.setFill(Paint.valueOf("green"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tempoLed.setFill(Paint.valueOf("pink"));

    }
    public void setValeur(int i ){
        tempo.setText(i+"");
    }
    /**
     *
     * Getters/Setters
     *
     */
    public void setStart(BoutonStart start) {
        this.start = start;
    }

    public void setStop(BoutonStop stop) {
        this.stop = stop;
    }

    public void setInc(BoutonInc inc) {
        this.inc = inc;
    }

    public void setDec(BoutonDec dec) {
        this.dec = dec;
    }

    public void setCursor(CurseurImpl c) {this.cursor = c;}

}
