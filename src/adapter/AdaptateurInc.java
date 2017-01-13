package vue;

import command.CheckInc;
import command.CheckStart;
import command.Command;
import tools.Horloge;
import tools.HorlogeImpl;

/**
 * Created by ce on 12/01/17.
 */
public class AdaptateurInc implements Bouton {
    /**
     * Instance unique pré-initialisée
     */
    private static AdaptateurInc INSTANCE = new AdaptateurInc();
    private Command inc;
    private IHM clavier;
    private boolean lastPosition = false;
    private Horloge horloge;

    private AdaptateurInc()
    {
        horloge = new HorlogeImpl();
        horloge.activerPeriodiquement(new CheckInc(this), 10);
    }

    /** Point d'accès pour l'instance unique du singleton */
    public static AdaptateurInc getInstance()
    {	return INSTANCE;
    }

    @Override
    public void setCommand(Command c) {
        this.inc = c;
    }

    public void setClavier(IHM clavier){ this.clavier = clavier;}

    public void checkInc(){
        boolean isButtonPressed = clavier.isButtonPressed("INC");
        if(!isButtonPressed && lastPosition) {
            lastPosition = isButtonPressed;
            inc.execute();
        }
        else{
            lastPosition = isButtonPressed;
        }
    }

}