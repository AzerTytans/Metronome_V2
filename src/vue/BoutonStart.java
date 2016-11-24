package vue;

import command.Command;
import javafx.event.ActionEvent;

public class BoutonStart implements Bouton {
    /**
     * Instance unique pré-initialisée
     */
    private static BoutonStart INSTANCE = new BoutonStart();
    private Command start;

    private BoutonStart()
    {}

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
