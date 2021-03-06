package model;

import command.Command;
import command.MarquerNext;
import tools.Horloge;
import tools.HorlogeImpl;

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
        this.tempo = 30;
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
//        System.out.println("Tempo : " + tempo);
//        System.out.println("Mesure Actuelle : " + mesureActuelle%4);
//        System.out.println("Mesure : " + mesure);
        if(mesureActuelle%mesure == 0) {
            mesureActuelle++;
            marquerMesure.execute();
        }
        else{
            marquerTemps.execute();
            mesureActuelle++;
        }
    }

	@Override
	public boolean getEtat() {
		return enMarche;
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
    public int getTempo() {
	    return tempo;
    }

	@Override
    public void setTempo(int tempo){
        System.out.println("New tempo : " + tempo);
        this.tempo = tempo;
        this.horloge.desactiver();
        if(enMarche)
            this.horloge.activerPeriodiquement(new MarquerNext(this), 1000f/ (60f/this.tempo));
        updateTempo.execute();
    }

    @Override
    public int getMesure() {
	    return mesure;
    }

	@Override
    public void setMesure(int mesure){
        if (1<mesure && mesure<8){
            this.mesure = mesure;
            this.mesureActuelle = 0;
            updateMesure.execute();
        }
    }
}
