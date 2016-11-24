package vue;

import command.Command;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

/**
 * Created by tp15009314 on 16/11/16.
 */

public class CurseurImpl implements Curseur{

    private double position;
    private Command updateCurseur;

    private CurseurImpl()
    {}

    /** Instance unique pré-initialisée */
    private static CurseurImpl INSTANCE = new CurseurImpl();

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
