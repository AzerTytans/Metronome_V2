package vue;

import command.Command;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * Created by tp15009314 on 16/11/16.
 */
public class BoutonStop extends Button implements Bouton {
        private Command stop;

        @Override
        public void setCommand(Command c) {
            this.stop = stop;
        }

        public void onStop(ActionEvent e){
            stop.execute();
        }

}


