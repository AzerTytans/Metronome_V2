package controller;

import command.Dec;
import command.Inc;
import command.Start;
import command.Stop;
import model.Moteur;
import vue.*;


public class ControllerImpl implements Controller {

	private Moteur moteur;
	private Bouton boutonStart;
	private Bouton boutonStop;
	private Bouton boutonInc;
	private Bouton boutonDec;
	private Afficheur afficheur;
	private Bipeur bipeur;
	private Curseur curseur;
	private IHM ihm;

	public ControllerImpl(Moteur moteur) {
		this.moteur = moteur;
	}

	@Override
	public void updateTempo() {
		//Afficheur.setValeur(moteur.getTempo);
	}

	@Override
	public void updateMesure() {
		//set Mesure IHM
	}

	@Override
	public void updateEtat() {
		//set Etat IHM
	}

	@Override
	public void marquerTemps() {
	// bipeur.marquerTemps();
	}

	@Override
	public void marquerMesure() {
	//	ihm.marquerMesure();
	//  bipeur.marquerMesure();
	}

	@Override
	public void start() {
			moteur.setEtat(true);
	}

	@Override
	public void stop() {
			moteur.setEtat(false);
	}

	@Override
	public void incMesure() {
			moteur.setMesure(moteur.getMesure()+1);
	}

	@Override
	public void decMesure() {
			moteur.setMesure(moteur.getMesure()-1);
	}

	@Override
	public void updateCursor() {
		int cursorPosition=42;
		moteur.setTempo(cursorPosition);
	}

	public void setBoutonStart(Bouton boutonStart) {
		boutonStart.setCommand(new Start(this));
	}

	public void setBoutonStop(Bouton boutonStop) {
		boutonStop.setCommand(new Stop(this));
	}

	public void setBoutonInc(Bouton boutonInc) {
		boutonInc.setCommand(new Inc(this));
	}

	public void setBoutonDec(Bouton boutonDec) {
		boutonDec.setCommand(new Dec(this));
	}

	public void setCurseur(Curseur curseur) {
		this.curseur = curseur;
	}

	public void setAfficheur(Afficheur afficheur) {
		this.afficheur = afficheur;
	}

	public void setBipeur(Bipeur bipeur) {
		this.bipeur = bipeur;
	}

    public void setIHM(IHM ihm) {
        this.ihm = ihm;
    }
}
