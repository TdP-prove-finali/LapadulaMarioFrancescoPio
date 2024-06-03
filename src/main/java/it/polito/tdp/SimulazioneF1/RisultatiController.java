package it.polito.tdp.SimulazioneF1;

import java.net.URL;
import java.util.ResourceBundle;
import it.polito.tdp.SimulazioneF1.TableController;
import it.polito.tdp.SimulazioneF1.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RisultatiController {

		private Model model;
		private Stage stage;
		
		private TableController tableController;
	
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TableColumn<Riga, Integer> Aero;

	    @FXML
	    private TableColumn<Riga, Integer> Affid;

	    @FXML
	    private TableColumn<Riga, Integer> Motore;

	    @FXML
	    private TableColumn<Riga, String> P1;

	    @FXML
	    private TableColumn<Riga, String> P2;

	    @FXML
	    private TableColumn<Riga, String> Scuderia;

	    @FXML
	    private TableColumn<Riga, Integer> Telaio;
	    
	    @FXML
	    private TableView<Riga> tableview;

	    @FXML
	    void CambiaController(ActionEvent event) throws Exception {
	    	CambiaScena.goToSimulazione(stage);
	    }

	    @FXML
	    void ShowPiloti(ActionEvent event) {

	    }

	    @FXML
	    void ShowScuderie(ActionEvent event) {

	    }

	    @FXML
	    void initialize() {
	        assert Aero != null : "fx:id=\"Aero\" was not injected: check your FXML file 'Risultati.fxml'.";
	        assert Affid != null : "fx:id=\"Affid\" was not injected: check your FXML file 'Risultati.fxml'.";
	        assert Motore != null : "fx:id=\"Motore\" was not injected: check your FXML file 'Risultati.fxml'.";
	        assert P1 != null : "fx:id=\"P1\" was not injected: check your FXML file 'Risultati.fxml'.";
	        assert P2 != null : "fx:id=\"P2\" was not injected: check your FXML file 'Risultati.fxml'.";
	        assert Scuderia != null : "fx:id=\"Scuderia\" was not injected: check your FXML file 'Risultati.fxml'.";
	        assert Telaio != null : "fx:id=\"Telaio\" was not injected: check your FXML file 'Risultati.fxml'.";
	        this.init();
	    }

		public void setModel(Model model) {
			this.model = model;			
		}
		
		public void setStage(Stage stage) {
			this.stage = stage;
		}
		
		public void init() {
			Aero.setCellValueFactory(new PropertyValueFactory<Riga, Integer>("aero"));
			Telaio.setCellValueFactory(new PropertyValueFactory<Riga, Integer>("telaio"));
			Motore.setCellValueFactory(new PropertyValueFactory<Riga, Integer>("motore"));
			Affid.setCellValueFactory(new PropertyValueFactory<Riga, Integer>("aff"));
			P1.setCellValueFactory(new PropertyValueFactory<Riga, String>("p1"));
			P2.setCellValueFactory(new PropertyValueFactory<Riga, String>("p2"));
			Scuderia.setCellValueFactory(new PropertyValueFactory<Riga, String>("scuderia"));
			this.tableController = new TableController(this.tableview);
		}
		
		public void add() {
			int aero = model.getAero();
			int telaio = model.getTelaio();
			int motore = model.getMotore();
			int affid = model.getAffid();
			
			String pilota1 = model.getPilota1();
			String pilota2 = model.getPilota2();
			String scuderia = model.getSc();
			
			Riga riga = new Riga(aero, telaio, motore, affid, pilota1, pilota2, scuderia);
			tableController.addRiga(riga);
		}

}

