package it.polito.tdp.SimulazioneF1;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RisultatiController2 {
	
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
    private TableColumn<Riga, Integer> Pos1;

    @FXML
    private TableColumn<Riga, Integer> Pos2;

    @FXML
    private TableColumn<Riga, Integer> PosS;

    @FXML
    private TableColumn<Riga, Integer> Punti1;

    @FXML
    private TableColumn<Riga, Integer> Punti2;

    @FXML
    private TableColumn<Riga, Integer> PuntiS;

    @FXML
    private TableColumn<Riga, String> Tag1;

    @FXML
    private TableColumn<Riga, String> Tag2;

    @FXML
    private TableColumn<Riga, String> TagS;

    @FXML
    private TableColumn<Riga, Integer> Telaio;
    
    @FXML
    private TableView<Riga> tableview;

    @FXML
    void CambiaController(ActionEvent event) throws Exception {
    	CambiaScena.goToSimulazione(stage);
    }

    @FXML
    void DoAzzera(ActionEvent event) {
    	tableview.getItems().clear();
    }

    @FXML
    void initialize() {
        assert Aero != null : "fx:id=\"Aero\" was not injected: check your FXML file 'Risultati2.fxml'.";
        assert Affid != null : "fx:id=\"Affid\" was not injected: check your FXML file 'Risultati2.fxml'.";
        assert Motore != null : "fx:id=\"Motore\" was not injected: check your FXML file 'Risultati2.fxml'.";
        assert Pos1 != null : "fx:id=\"Pos1\" was not injected: check your FXML file 'Risultati2.fxml'.";
        assert Pos2 != null : "fx:id=\"Pos2\" was not injected: check your FXML file 'Risultati2.fxml'.";
        assert PosS != null : "fx:id=\"PosS\" was not injected: check your FXML file 'Risultati2.fxml'.";
        assert Punti1 != null : "fx:id=\"Punti1\" was not injected: check your FXML file 'Risultati2.fxml'.";
        assert Punti2 != null : "fx:id=\"Punti2\" was not injected: check your FXML file 'Risultati2.fxml'.";
        assert PuntiS != null : "fx:id=\"PuntiS\" was not injected: check your FXML file 'Risultati2.fxml'.";
        assert Tag1 != null : "fx:id=\"Tag1\" was not injected: check your FXML file 'Risultati2.fxml'.";
        assert Tag2 != null : "fx:id=\"Tag2\" was not injected: check your FXML file 'Risultati2.fxml'.";
        assert TagS != null : "fx:id=\"TagS\" was not injected: check your FXML file 'Risultati2.fxml'.";
        assert Telaio != null : "fx:id=\"Telaio\" was not injected: check your FXML file 'Risultati2.fxml'.";
        this.init();
    }

    public void setModel(Model model) {
		this.model = model;			
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void init() {
		tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		Aero.setCellValueFactory(new PropertyValueFactory<Riga, Integer>("aero"));
		Telaio.setCellValueFactory(new PropertyValueFactory<Riga, Integer>("telaio"));
		Motore.setCellValueFactory(new PropertyValueFactory<Riga, Integer>("motore"));
		Affid.setCellValueFactory(new PropertyValueFactory<Riga, Integer>("aff"));
		Punti1.setCellValueFactory(new PropertyValueFactory<Riga, Integer>("punti1"));
		Punti2.setCellValueFactory(new PropertyValueFactory<Riga, Integer>("punti2"));
		PuntiS.setCellValueFactory(new PropertyValueFactory<Riga, Integer>("puntiS"));
		Pos1.setCellValueFactory(new PropertyValueFactory<Riga, Integer>("pos1"));
		Pos2.setCellValueFactory(new PropertyValueFactory<Riga, Integer>("pos2"));
		PosS.setCellValueFactory(new PropertyValueFactory<Riga, Integer>("posS"));
		Tag1.setCellValueFactory(new PropertyValueFactory<Riga, String>("tag1"));
		Tag2.setCellValueFactory(new PropertyValueFactory<Riga, String>("tag2"));
		TagS.setCellValueFactory(new PropertyValueFactory<Riga, String>("tagS"));
		this.tableController = new TableController(this.tableview);
		this.tableController.setdata(CambiaScena.getdata());
	}
	
	public void add() {
		int aero = model.getAero();
		int telaio = model.getTelaio();
		int motore = model.getMotore();
		int affid = model.getAffid();

		String pilota1 = model.getPilota1();
		String[] ss1 = pilota1.split(" ");
		int pos1 =  Integer.valueOf(ss1[0]);
		String tag1 = ss1[1];
		int punti1 = Integer.valueOf(ss1[2]);
		String pilota2 = model.getPilota2();
		String[] ss2 = pilota2.split(" ");
		int pos2 =  Integer.valueOf(ss2[0]);
		String tag2 = ss2[1];
		int punti2 = Integer.valueOf(ss2[2]);
		String scuderia = model.getSc();
		String[] sss = scuderia.split(" ");
		int poss =  Integer.valueOf(sss[0]);
		String tags = sss[1];
		int puntis = Integer.valueOf(sss[2]);
		
		Riga riga = new Riga(aero, telaio, motore, affid, punti1, punti2, puntis, pos1, pos2, poss, tag1, tag2, tags);
		tableController.addRiga(riga);
	}
}

