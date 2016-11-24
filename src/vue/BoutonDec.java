package vue;

import command.Command;
import javafx.event.ActionEvent;

public class BoutonDec implements Bouton {
    /**
     * Instance unique pré-initialisée
     */
    private static BoutonDec INSTANCE = new BoutonDec();
    private Command dec;

    private BoutonDec()
    {}

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
