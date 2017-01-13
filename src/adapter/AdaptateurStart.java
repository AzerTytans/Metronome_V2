package vue;

import command.CheckStart;
import command.Command;
import javafx.event.ActionEvent;
import tools.Horloge;
import tools.HorlogeImpl;

/**
 * Created by ce on 12/01/17.
 */
public class AdaptateurStart implements Bouton {
    /**
     * Instance unique pré-initialisée
     */
    private static AdaptateurStart INSTANCE = new AdaptateurStart();
    private Command start;
    private IHM clavier;
    private boolean lastPosition = false;
    private Horloge horloge;

    private AdaptateurStart()
    {
        horloge = new HorlogeImpl();
        horloge.activerPeriodiquement(new CheckStart(this), 10);
    }

    /** Point d'accès pour l'instance unique du singleton */
    public static AdaptateurStart getInstance()
    {	return INSTANCE;
    }

    @Override
    public void setCommand(Command c) {
        this.start = c;
    }

    public void setClavier(IHM clavier){ this.clavier = clavier;}

    public void checkStart(){
        boolean isButtonPressed = clavier.isButtonPressed("START");
        if(!isButtonPressed && lastPosition) {
            lastPosition = isButtonPressed;
            start.execute();
        }
        else{
            lastPosition = isButtonPressed;
        }
    }

}
