package vue;

import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Moteur;
import model.MoteurImpl;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxml.getRoot();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 275));
        primaryStage.show();

        ((IHM)fxml.getController()).setDec(BoutonDec.getInstance());
        ((IHM)fxml.getController()).setInc(BoutonInc.getInstance());
        ((IHM)fxml.getController()).setStart(BoutonStart.getInstance());
        ((IHM)fxml.getController()).setStop(BoutonStop.getInstance());
    }

    public static void main(String[] args) {
        Moteur moteur = new MoteurImpl();
        Controller controller = new ControllerImpl(moteur);
        Afficheur afficheur = new AfficheurImpl();
        Bipeur bipeur = new BipeurImpl();

        launch(args);
    }
}
