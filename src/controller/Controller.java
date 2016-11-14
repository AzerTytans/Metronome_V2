package controller;

public interface Controller {

	//Commande moteur
	void updateTempo();
	void updateMesure();
	void updateEtat();
	void marquerTemps();
	void marquerMesure();


	//Commande IHM
	void start();
	void stop();
	void incMesure();
	void decMesure();
	void updateCursor();
}
