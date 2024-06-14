package it.polito.tdp.SimulazioneF1;

import it.polito.tdp.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

class CambiaScena {
	
	protected static void goToRisultati(Stage stage, Model model) throws Exception {
		FXMLLoader loader = new FXMLLoader(CambiaScena.class.getResource("/fxml/Risultati2.fxml"));
        BorderPane root = loader.load();
		
        RisultatiController2 controller = loader.getController();
		controller.setModel(model);
		controller.setStage(stage);
		Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setScene(scene);
        stage.show();
        controller.add();
	}
	
	protected static void goToSimulazione(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(CambiaScena.class.getResource("/fxml/Scene.fxml"));
        BorderPane root = loader.load();
        FXMLController controller = loader.getController();
		Model model = new Model();
		controller.setModel(model);
		controller.setStage(stage);
		Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setScene(scene);
        stage.show();

	}
	
	static ObservableList<Riga> OL;
	
	public static void startdata() {
		OL = FXCollections.observableArrayList();
	}
	
	public static ObservableList<Riga> getdata(){
		return OL;
	}

}
