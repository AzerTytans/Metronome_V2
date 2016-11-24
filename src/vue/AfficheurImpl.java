package vue;

public class AfficheurImpl implements Afficheur {

    private IHM controller;

    public AfficheurImpl(IHM controller) {
        this.controller = controller;
    }


	@Override
	public void setValeurMesure(int i) {
		controller.setValeurMesure(i);
	}

	@Override
	public void setValeurTempo(int i) {
		controller.setValeurTempo(i);
	}

}
