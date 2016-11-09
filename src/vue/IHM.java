package vue;

import command.Command;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import model.CommandName;

/**
 * Created by tp15009314 on 09/11/16.
 */
public class IHM {

        private Command inc;
        private Command dec;
        private Command start;
        private Command stop;
        private Command updateCurseur;

        @FXML
        private Label tempo;

        @FXML
        private Circle tempoLed;

        @FXML
        private Circle mesureLed;

        @FXML
        private Slider slider;

        @FXML


        public Label getTempo() {
            return tempo;
        }

        public Circle getTempoLed() {
            return tempoLed;
        }

        public Circle getMesureLed() {
            return mesureLed;
        }

        public Slider getSlider() {
            return slider;
        }

    public void setCommand(Command c, CommandEnum evt) {
        switch(evt){
            case START:
                start = c;
                break;
            case STOP:
                stop = c;
                break;
            case INC:
                inc = c;
                break;
            case DEC:
                dec = c;
                break;
            case UPDATE_CURSEUR:
                updateCurseur = c;
            default :
                break;
        }
    }
        @FXML
        private void onStart(ActionEvent e){
            start.execute();
        }

        @FXML
        private void onStop(ActionEvent e){
            stop.execute();
        }

        @FXML
        private void onDec(ActionEvent e){
            dec.execute();
        }

        @FXML
        private void onInc(ActionEvent e){
            inc.execute();
        }

        @FXML
        private void onSliderChanged(MouseEvent e){
         updateCurseur.execute();
        }


}
