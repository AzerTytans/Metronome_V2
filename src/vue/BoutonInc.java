package vue;

import command.Command;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * Created by tp15009314 on 16/11/16.
 */
public class BoutonInc implements Bouton {
    private Command inc;

    private BoutonInc()
    {}

    /** Instance unique pré-initialisée */
    private static BoutonInc INSTANCE = new BoutonInc();

    /** Point d'accès pour l'instance unique du singleton */
    public static BoutonInc getInstance()
    {	return INSTANCE;
    }

    @Override
    public void setCommand(Command c) {
        this.inc = c;
    }

    public void onInc(ActionEvent e){
        inc.execute();
    }
}
