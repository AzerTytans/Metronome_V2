package vue;

import command.Command;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * Created by tp15009314 on 16/11/16.
 */
public class BoutonDec extends Button implements Bouton {
    private Command dec;

    @Override
    public void setCommand(Command c) {
        this.dec = dec;
    }

    public void onDec(ActionEvent e){
        dec.execute();
    }
}
