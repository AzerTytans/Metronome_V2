package vue;

import command.Command;
import javafx.event.ActionEvent;

public class BoutonStop implements Bouton {
    /**
     * Instance unique pré-initialisée
     */
    private static BoutonStop INSTANCE = new BoutonStop();
    private Command stop;

    private BoutonStop()
    {}

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


