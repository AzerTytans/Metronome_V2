package vue;

import command.Command;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * Created by tp15009314 on 16/11/16.
 */
public class BoutonInc extends Button implements Bouton {
    private Command inc;

    @Override
    public void setCommand(Command c) {
        this.inc = inc;
    }

    public void onInc(ActionEvent e){
        inc.execute();
    }
}
