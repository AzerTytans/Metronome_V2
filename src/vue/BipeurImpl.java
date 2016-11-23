package vue;

import java.applet.Applet;

/**
 * Created by ce on 16/11/16.
 */
public class BipeurImpl implements Bipeur {

	java.net.URL temps = getClass().getResource("/tools/beep-tempo.wav");
	java.applet.AudioClip sonTemps = Applet.newAudioClip(temps);
	java.net.URL mesure = getClass().getResource("/tools/beep-mesure.wav");
	java.applet.AudioClip sonMesure = Applet.newAudioClip(mesure);

	@Override
	public void marquerTemps() {
		sonTemps.play();
	}

	@Override
	public void marquerMesure() {
		sonMesure.play();
	}
}
