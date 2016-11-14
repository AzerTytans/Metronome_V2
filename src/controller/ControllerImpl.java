package controller;

import model.Moteur;

/**
 * Created by florian on 07/11/16.
 */
public class ControllerImpl implements Controller {

	private Moteur moteur;

	public ControllerImpl(Moteur moteur) {
		this.moteur = moteur;
	}

	@Override
	public void updateTempo() {
		//set Tempo IHM
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

	}

	@Override
	public void marquerMesure() {

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

}
