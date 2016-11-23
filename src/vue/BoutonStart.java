package vue;

import command.Command;
import javafx.beans.DefaultProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * Created by tp15009314 on 16/11/16.
 */

public class BoutonStart implements Bouton {
    private Command start;

    private BoutonStart()
    {}

    /** Instance unique pré-initialisée */
    private static BoutonStart INSTANCE = new BoutonStart();

    /** Point d'accès pour l'instance unique du singleton */
    public static BoutonStart getInstance()
    {	return INSTANCE;
    }

    @Override
    public void setCommand(Command c) {
        this.start = c;
    }

    public void onStart(ActionEvent e){
        start.execute();
    }

}
