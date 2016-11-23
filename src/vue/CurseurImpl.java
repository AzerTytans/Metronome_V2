package vue;

import command.Command;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

/**
 * Created by tp15009314 on 16/11/16.
 */

public class CurseurImpl implements Curseur{

    private int position;
    private Command updateCurseur;

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setCommand(Command c) {
        this.updateCurseur = c;
    }

    public void onSliderChanged(MouseEvent e){
        updateCurseur.execute();
    }

}
