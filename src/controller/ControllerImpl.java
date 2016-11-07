package controller;

import model.Moteur;

/**
 * Created by florian on 07/11/16.
 */
public class ControllerImpl implements Controller {

	private Moteur moteur;
	private int old = 0;
	private int count = 0;

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
		if (!moteur.getEtat())
			moteur.setEtat(true);
	}

	@Override
	public void stop() {
		if (moteur.getEtat())
			moteur.setEtat(false);
	}

	@Override
	public void incMesure() {
		if(moteur.getMesure()<7)
			moteur.setMesure(moteur.getMesure()+1);
	}

	@Override
	public void decMesure() {
		if(moteur.getMesure()>2)
			moteur.setMesure(moteur.getMesure()-1);
	}

	@Override
	public void updateCurseur() {
		int cursorPosition=42;

		if(old==cursorPosition)
			count ++;
		else {
			count = 0;
			old = cursorPosition;
		}
		if (count==5){
			moteur.setTempo(cursorPosition);
	}

	}

}
