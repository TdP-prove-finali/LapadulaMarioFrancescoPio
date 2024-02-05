package it.polito.tdp.SimulazioneF1;
import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.SimulazioneF1.model.ClassificaScuderie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RisultatiController {

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TableColumn<ClassificaScuderie, String> Nome;

	    @FXML
	    private TableColumn<ClassificaScuderie, Integer> Punti;

	    @FXML
	    private TableView<ClassificaScuderie> Tab1;

	    @FXML
	    private TableView<ClassificaScuderie> Tab2;

	    @FXML
	    private TableView<ClassificaScuderie> Tab3;

	    @FXML
	    private TableColumn<ClassificaScuderie, Integer> W;

	    @FXML
	    void CambiaController(ActionEvent event) {

	    }

	    @FXML
	    void ShowPiloti(ActionEvent event) {

	    }

	    @FXML
	    void ShowScuderie(ActionEvent event) {

	    }

	    @FXML
	    void initialize() {
	        assert Nome != null : "fx:id=\"Nome\" was not injected: check your FXML file 'Risultati.fxml'.";
	        assert Punti != null : "fx:id=\"Punti\" was not injected: check your FXML file 'Risultati.fxml'.";
	        assert Tab1 != null : "fx:id=\"Tab1\" was not injected: check your FXML file 'Risultati.fxml'.";
	        assert Tab2 != null : "fx:id=\"Tab2\" was not injected: check your FXML file 'Risultati.fxml'.";
	        assert Tab3 != null : "fx:id=\"Tab3\" was not injected: check your FXML file 'Risultati.fxml'.";
	        assert W != null : "fx:id=\"W\" was not injected: check your FXML file 'Risultati.fxml'.";

	    }

	
}
