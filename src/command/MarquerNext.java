package command;

import model.Moteur;

/**
 * Created by ce on 09/11/16.
 */
public class MarquerNext implements Command{
    private Moteur moteur;

    public MarquerNext(Moteur moteur) {
        this.moteur = moteur;
    }

    @Override
    public void execute() {
        moteur.notifyDelay();
    }
}
