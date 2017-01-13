package vue;

import command.CheckStart;
import command.CheckStop;
import command.Command;
import tools.Horloge;
import tools.HorlogeImpl;

/**
 * Created by ce on 12/01/17.
 */
public class AdaptateurStop implements Bouton {
    /**
     * Instance unique pré-initialisée
     */
    private static AdaptateurStop INSTANCE = new AdaptateurStop();
    private Command stop;
    private IHM clavier;
    private boolean lastPosition = false;
    private Horloge horloge;

    private AdaptateurStop()
    {
        horloge = new HorlogeImpl();
        horloge.activerPeriodiquement(new CheckStop(this), 10);
    }

    /** Point d'accès pour l'instance unique du singleton */
    public static AdaptateurStop getInstance()
    {	return INSTANCE;
    }

    @Override
    public void setCommand(Command c) {
        this.stop = c;
    }

    public void setClavier(IHM clavier){ this.clavier = clavier;}

    public void checkStop(){
        boolean isButtonPressed = clavier.isButtonPressed("STOP");
        if(!isButtonPressed && lastPosition) {
            lastPosition = isButtonPressed;
            stop.execute();
        }
        else{
            lastPosition = isButtonPressed;
        }
    }

}