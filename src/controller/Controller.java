package controller;

public interface Controller {

	void updateTempo();
	void updateMesure();
	void updateEtat();
	void marquerTemps();
	void marquerMesure();

	void start();
	void stop();
	void incMesure();
	void decMesure();
	void updateCurseur();
}
