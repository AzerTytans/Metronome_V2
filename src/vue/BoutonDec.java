package vue;

import command.Command;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * Created by tp15009314 on 16/11/16.
 */
public class BoutonDec implements Bouton {
    private Command dec;

    private BoutonDec()
    {}

    /** Instance unique pré-initialisée */
    private static BoutonDec INSTANCE = new BoutonDec();

    /** Point d'accès pour l'instance unique du singleton */
    public static BoutonDec getInstance()
    {	return INSTANCE;
    }

    @Override
    public void setCommand(Command c) {
        this.dec = c;
    }

    public void onDec(ActionEvent e){
        dec.execute();
    }
}
