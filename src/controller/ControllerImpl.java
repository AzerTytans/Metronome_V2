package controller;

import command.*;
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

	public ControllerImpl(Moteur moteur, IHM ihm) {
		this.moteur = moteur;
		this.ihm = ihm;
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
		this.boutonStart=boutonStart;
		boutonStart.setCommand(new Start(this));
	}

	public void setBoutonStop(Bouton boutonStop) {
		this.boutonStop =boutonStop;
		boutonStop.setCommand(new Stop(this));
	}

	public void setBoutonInc(Bouton boutonInc) {
		this.boutonInc=boutonInc;
		boutonInc.setCommand(new Inc(this));
	}

	public void setBoutonDec(Bouton boutonDec) {
		this.boutonDec=boutonDec;
		boutonDec.setCommand(new Dec(this));
	}

	public void setCurseur(Curseur curseur) {
		this.curseur = curseur;
		curseur.setCommand(new UpdateCursor(this));
	}
	public void setAfficheur(Afficheur afficheur) {
		this.afficheur = afficheur;
	}
	public void setBipeur(Bipeur bipeur) {
		this.bipeur = bipeur;
	}

}
