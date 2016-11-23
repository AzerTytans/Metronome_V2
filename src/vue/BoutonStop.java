package vue;

import command.Command;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * Created by tp15009314 on 16/11/16.
 */
public class BoutonStop implements Bouton {
    private Command stop;

    private BoutonStop()
    {}

    /** Instance unique pré-initialisée */
    private static BoutonStop INSTANCE = new BoutonStop();

    /** Point d'accès pour l'instance unique du singleton */
    public static BoutonStop getInstance()
    {	return INSTANCE;
    }

    @Override
    public void setCommand(Command c) {
            this.stop = c;
        }

    public void onStop(ActionEvent e){
            stop.execute();
        }

}


