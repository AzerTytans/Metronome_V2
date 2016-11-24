package vue;


import controller.ControllerImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Moteur;
import model.MoteurImpl;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxml.load();
        primaryStage.setTitle("Metronome");
        primaryStage.setScene(new Scene(root, 500, 275));
        primaryStage.show();

        initialize(fxml);
    }

    public void initialize(FXMLLoader fxml){
        Moteur moteur = new MoteurImpl();
        Afficheur afficheur = new AfficheurImpl(fxml.getController());
        Bipeur bipeur = new BipeurImpl(fxml.getController());

        /**
         * Transmission infos controller
         */
        ControllerImpl controller = new ControllerImpl(moteur);
        controller.setBoutonDec(BoutonDec.getInstance());
        controller.setBoutonStart(BoutonStart.getInstance());
        controller.setBoutonStop(BoutonStop.getInstance());
        controller.setBoutonInc(BoutonInc.getInstance());
        controller.setAfficheur(afficheur);
        controller.setBipeur(bipeur);
        controller.setCurseur(CurseurImpl.getInstance());

        /**
         * Transmission boutons/curseur IHM
         */
        ((IHM)fxml.getController()).setDec(BoutonDec.getInstance());
        ((IHM)fxml.getController()).setInc(BoutonInc.getInstance());
        ((IHM)fxml.getController()).setStart(BoutonStart.getInstance());
        ((IHM)fxml.getController()).setStop(BoutonStop.getInstance());
        ((IHM)fxml.getController()).setCursor(CurseurImpl.getInstance());
    }
}
