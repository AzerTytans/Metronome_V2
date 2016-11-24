package vue;

import command.Command;
import javafx.event.ActionEvent;


public class BoutonInc implements Bouton {
    /**
     * Instance unique pré-initialisée
     */
    private static BoutonInc INSTANCE = new BoutonInc();
    private Command inc;

    private BoutonInc()
    {}

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
