package vue;

import command.CheckDec;
import command.Command;
import tools.Horloge;
import tools.HorlogeImpl;

/**
 * Created by ce on 12/01/17.
 */
public class AdaptateurDec implements Bouton {
    /**
     * Instance unique pré-initialisée
     */
    private static AdaptateurDec INSTANCE = new AdaptateurDec();
    private Command dec;
    private IHM clavier;
    private boolean lastPosition = false;
    private Horloge horloge;

    private AdaptateurDec()
    {
        horloge = new HorlogeImpl();
        horloge.activerPeriodiquement(new CheckDec(this), 10);
    }

    /** Point d'accès pour l'instance unique du singleton */
    public static AdaptateurDec getInstance()
    {	return INSTANCE;
    }

    @Override
    public void setCommand(Command c) {
        this.dec = c;
    }

    public void setClavier(IHM clavier){ this.clavier = clavier;}

    public void checkDec(){
        boolean isButtonPressed = clavier.isButtonPressed("DEC");
        if(!isButtonPressed && lastPosition) {
            lastPosition = isButtonPressed;
            dec.execute();
        }
        else{
            lastPosition = isButtonPressed;
        }
    }

}
