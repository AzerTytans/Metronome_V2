package model;

import command.Command;
import command.MarquerMesure;

/**
 * Created by florian on 07/11/16.
 */
public class MoteurImpl implements Moteur{
    /**
     * Command
     */
    private Command marquerMesure;
    private Command marquerTemps;
    private Command updateTempo;;
    private Command updateEtat;
    private Command updateMesure;

    /**
     * Parametre
     */
    private boolean enMarche;
    private int tempo;
    private int mesure;

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


    /**
     * Getters/Setters
     */
    @Override
    public void setEtat(boolean marche){
        enMarche = marche;
        updateEtat.execute();
    }

    @Override
    public void setTempo(int tempo){
        this.tempo = tempo;
        updateTempo.execute();
    }

    @Override
    public void setMesure(int mesure){
        this.mesure = mesure;
        updateMesure.execute();
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
