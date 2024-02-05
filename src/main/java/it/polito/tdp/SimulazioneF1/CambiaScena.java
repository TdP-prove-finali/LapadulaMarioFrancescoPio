package it.polito.tdp.SimulazioneF1;

import it.polito.tdp.SimulazioneF1.model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CambiaScena {
	
	protected static void goToRisultati(Stage stage, Model model) throws Exception {
		FXMLLoader loader = new FXMLLoader(CambiaScena.class.getResource("/fxml/Risultati.fxml"));
        BorderPane root = loader.load();
		
        RisultatiController controller = loader.getController();
		controller.setModel(model);
		controller.setStage(stage);
		Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("F1");
        stage.setScene(scene);
        stage.show();
	}
	
	protected static void goToSimulazione(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(CambiaScena.class.getResource("/fxml/Scene.fxml"));
        BorderPane root = loader.load();
        //cambianome al controller
        FXMLController controller = loader.getController();
		Model model = new Model();
		controller.setModel(model);
		controller.setStage(stage);
		Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("F1");
        stage.setScene(scene);
        stage.show();
	}

}
