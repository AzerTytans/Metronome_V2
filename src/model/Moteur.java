package model;

/**
 * Created by florian on 07/11/16.
 */
public interface Moteur {

	boolean getEtat();
	int getTempo();
	int getMesure();

	void setEtat(boolean etat);
	void setTempo(int tempo);
	void setMesure(int mesure);
}
