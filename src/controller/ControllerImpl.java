package controller;

import command.*;
import model.Moteur;
import vue.*;


public class ControllerImpl implements Controller {

	private Moteur moteur;
	private Afficheur afficheur;
    private Bipeur bipeur;

	public ControllerImpl(Moteur moteur) {
		this.moteur = moteur;
	}

	@Override
	public void updateTempo() {
		afficheur.setValeur(moteur.getTempo());
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
	bipeur.marquerTemps();
	}

	@Override
	public void marquerMesure() {
	//ihm.marquerMesure();
	bipeur.marquerMesure();
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
		curseur.setCommand(new UpdateCursor(this));
	}

	public void setAfficheur(Afficheur afficheur) {
		this.afficheur = afficheur;
	}

	public void setBipeur(Bipeur bipeur) {
		this.bipeur = bipeur;
	}

}
