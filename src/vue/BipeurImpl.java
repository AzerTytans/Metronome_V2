package vue;

import java.applet.Applet;


public class BipeurImpl implements Bipeur {
    private IHM controller;

	public BipeurImpl(IHM controller){
        this.controller = controller;
    }

	java.net.URL temps = getClass().getResource("/tools/beep-tempo.wav");
	java.applet.AudioClip sonTemps = Applet.newAudioClip(temps);
	java.net.URL mesure = getClass().getResource("/tools/beep-mesure.wav");
	java.applet.AudioClip sonMesure = Applet.newAudioClip(mesure);

	@Override
	public void marquerTemps() {
        sonTemps.play();
        controller.marquerTempo();
	}

	@Override
	public void marquerMesure() {
		sonMesure.play();
        controller.marquerMesure();
	}
}
