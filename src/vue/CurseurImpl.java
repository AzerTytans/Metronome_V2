package vue;

import command.Command;
import javafx.scene.input.MouseEvent;


public class CurseurImpl implements Curseur{

    /**
     * Instance unique pré-initialisée
     */
    private static CurseurImpl INSTANCE = new CurseurImpl();
    private double position;
    private Command updateCurseur;

    private CurseurImpl()
    {}

    /** Point d'accès pour l'instance unique du singleton */
    public static CurseurImpl getInstance()
    {	return INSTANCE;
    }

    @Override
    public double getPosition() {
        return position;
    }

    @Override
    public void setCommand(Command c) {
        this.updateCurseur = c;
    }

    public void onSliderChanged(MouseEvent e,double valeur){
        this.position = valeur;
        updateCurseur.execute();
    }

}
