package vue;

/**
 * Created by ce on 16/11/16.
 */
public class AfficheurImpl implements Afficheur {
    private IHM controller;

    public AfficheurImpl(IHM controller) {
        this.controller = controller;
    }
}
