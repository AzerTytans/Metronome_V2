package model;

import command.Command;
import command.MarquerMesure;
import command.MarquerNext;
import tools.Horloge;
import tools.HorlogeImpl;

import java.util.Timer;

/**
 * Created by florian on 07/11/16.
 */
public class MoteurImpl implements Moteur{
    /**
     * Command
     */
    private Command marquerMesure;
    private Command marquerTemps;
    private Command updateTempo;
    private Command updateEtat;
    private Command updateMesure;

	private int old = 0;
	private int count = 0;

    /**
     * Parametre
     */
    private boolean enMarche;
    private int tempo;
    private int mesure;
    private int mesureActuelle;

    /**
     * Timer
     */
    private Horloge horloge;

    public MoteurImpl() {
        this.enMarche = false;
        this.tempo = 150;
        this.mesure = 4;
        this.horloge = new HorlogeImpl();
        this.mesureActuelle = 0;

    }

    @Override
    public void setCommand(Command c, CommandName evt) {
        switch(evt){
            case MARQUER_TEMPS:
                marquerTemps = c;
                break;
            case MARQUER_MESURE :
                marquerMesure = c;
                break;
            case UPDATE_TEMPO:
                updateTempo = c;
                break;
            case UPDATE_MESURE:
                updateMesure = c;
                break;
            case UPDATE_ETAT:
                updateEtat = c;
            default :
                break;
        }
    }

    public void notifyDelay(){
        if(mesureActuelle%mesure == 0){
            marquerMesure.execute();
            mesureActuelle ++;
        }
        else{
            marquerTemps.execute();
            mesureActuelle++;
        }
    }

    /**
     * Getters/Setters
     */
    @Override
    public void setEtat(boolean marche){
        if (!marche == enMarche) {
            enMarche = marche;
            if(enMarche)
                this.horloge.activerPeriodiquement(new MarquerNext(this),1000f/ (60f/tempo));
            else{
                mesureActuelle = 0;
                this.horloge.desactiver();
            }
            updateEtat.execute();
        }
    }

    @Override
    public void setTempo(int tempo){
	    if(old==tempo)
		    count ++;
	    else {
		    count = 0;
		    old = tempo;
	    }
	    if (count==5){
            this.tempo = tempo;
            this.horloge.desactiver();
            this.horloge.activerPeriodiquement(new MarquerNext(this), 1000f/ (60f/this.tempo));
            updateTempo.execute();
        }
    }

    @Override
    public void setMesure(int mesure){
	    if (1<mesure && mesure<8){
            this.mesure = mesure;
            this.mesureActuelle = 0;
            updateMesure.execute();
	    }
    }

    @Override
    public boolean getEtat() {
        return enMarche;
    }

    @Override
    public int getTempo() {
        return tempo;
    }

    @Override
    public int getMesure() {
        return mesure;
    }
}
