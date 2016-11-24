package controller;

import command.*;
import model.CommandName;
import model.Moteur;
import vue.Afficheur;
import vue.Bipeur;
import vue.Bouton;
import vue.Curseur;


public class ControllerImpl implements Controller {

	private Moteur moteur;
	private Afficheur afficheur;
    private Bipeur bipeur;
	private Curseur curseur;

	public ControllerImpl(Moteur moteur) {
		this.moteur = moteur;
		moteur.setCommand(new UpdateEtat(this), CommandName.UPDATE_ETAT);
		moteur.setCommand(new UpdateMesure(this), CommandName.UPDATE_MESURE);
		moteur.setCommand(new UpdateTempo(this), CommandName.UPDATE_TEMPO);
		moteur.setCommand(new MarquerTemps(this), CommandName.MARQUER_TEMPS);
		moteur.setCommand(new MarquerMesure(this), CommandName.MARQUER_MESURE);
	}

	@Override
	public void updateTempo() {
		afficheur.setValeurTempo(moteur.getTempo());
	}

	@Override
	public void updateMesure() {
		System.out.println(moteur.getMesure());
		afficheur.setValeurMesure(moteur.getMesure());

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
		moteur.setTempo((int) curseur.getPosition());
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
		this.curseur=curseur;
		curseur.setCommand(new UpdateCursor(this));
	}

	public void setAfficheur(Afficheur afficheur) {
		this.afficheur = afficheur;
	}

	public void setBipeur(Bipeur bipeur) {
		this.bipeur = bipeur;
	}

}
