package it.polito.tdp.SimulazioneF1;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.SimulazioneF1.model.Model;
import it.polito.tdp.SimulazioneF1.model.Pilota;
import it.polito.tdp.SimulazioneF1.model.Scuderia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLController {
	
	private Model model;
	private Stage stage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Azzera;

    @FXML
    private ComboBox<Pilota> CBPilota1;

    @FXML
    private ComboBox<Pilota> CBPilota2;

    @FXML
    private ComboBox<Scuderia> ComboScuderia;

    @FXML
    private Button Simula;
    
    @FXML
    private TextArea Segnalazione;

    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    @FXML
    private TextField text4;

    @FXML
    private TextField text5;
    
    Pilota p1;
    Pilota p2;
    ArrayList<Integer> investimenti;

    public Pilota getP1() {
		return p1;
	}

	public void setP1(Pilota p1) {
		this.p1 = p1;
	}

	public Pilota getP2() {
		return p2;
	}

	public void setP2(Pilota p2) {
		this.p2 = p2;
	}

	@FXML
    void DoAzzera(ActionEvent event) {
		
		this.setP1(null);
		this.setP2(null);
		
		this.ComboScuderia.setDisable(false);
		this.ComboScuderia.setValue(null);
		this.CBPilota1.setValue(null);
    	this.CBPilota2.setValue(null);
		
		this.Segnalazione.clear();
	    text1.setText("0");
        text2.setText("0");
        text4.setText("0");
        text5.setText("0");

}
	
    @FXML
    void SceltaScuderia(ActionEvent event) {
    	
    	this.CBPilota1.setDisable(false);
    	this.CBPilota2.setDisable(false);

    	Scuderia s = this.ComboScuderia.getValue();
    	Pilota p1 = null;
    	Pilota p2 = null;
    	
    	int i = 0;
    	
    	for(Pilota p : model.getAllPiloti()) {
    		if(p.getS().equals(s)){
    			if(i==0) {
    				p1 = p;
    				i++;
    			}else if(i==1) {
    				p2 = p;
    				i = 0;
    			}
    		}
    	}
    	
       	this.CBPilota1.setValue(p1);
    	this.CBPilota2.setValue(p2);
    	
    }

    @FXML
    void DoSimula(ActionEvent event) throws Exception {
    	
    	Pilota nuovo1 = this.CBPilota1.getValue();
    	Pilota nuovo2 = this.CBPilota2.getValue();    	
    	
    	if(nuovo1==null || nuovo2==null) {
    		this.Segnalazione.setText("Inserire i piloti che gareggeranno per la tua squadra.");
    		return;
    	}
    	
    	if(nuovo1!=null) {
    		this.setP1(nuovo1);
    	}
    	
    	if(nuovo2!=null) {
    		this.setP2(nuovo2);
    	}
    	
    	if(nuovo1.equals(nuovo2)) {
    		this.Segnalazione.setText("Inserire piloti diversi per la scuderia!\n");
    		return;
    	}
    	
    	String aero = this.text1.getText();
    	String telaio = this.text2.getText();
    	String motore = this.text4.getText();
    	String aff = this.text5.getText();
    	
    	try {
    		int Aero = Integer.parseInt(aero);
    		int Telaio = Integer.parseInt(telaio);
    		int Motore = Integer.parseInt(motore);
    		int Aff = Integer.parseInt(aff);
    		
    		if(!(Aero>=0 && Telaio>=0 && Motore>=0 && Aff>=0)) {
    			this.Segnalazione.setText("Inserire valori interi positivi per gli investimenti.\n");
    			return;
    		}
    		if((Aero+Telaio+Aff+Motore)>140) {
    			this.Segnalazione.setText("Inserire importi la cui somma sia minore o uguale al limite imposto dal Budget Cup pari a 140 Milioni.\n");
    			return;
    		}else {
    			this.investimenti = new ArrayList<>();
    			investimenti.add(Aero);
    			investimenti.add(Telaio);
    			investimenti.add(Motore);
    			investimenti.add(Aff);
    		}
    		
    		
    	}catch(NumberFormatException e) {
    		//e.printStackTrace();
    		this.Segnalazione.setText("I dati inseriti sono errati.\nInserire numeri interi.");
    		return;
    	} 
    	
    	//controlli
    	if(this.ComboScuderia.getValue()!=null && this.investimenti.size()==4) {
    		model.simula(this.ComboScuderia.getValue(), investimenti.get(0), investimenti.get(1), investimenti.get(2), investimenti.get(3), this.getP1(), this.getP2());
    	}
    	
    	//azzerare tutti i campi
		this.setP1(null);
		this.setP2(null);
		
		this.CBPilota1.getItems().clear();
		this.CBPilota2.getItems().clear();
		this.ComboScuderia.setDisable(false);
		this.ComboScuderia.setValue(null);
		this.ComboScuderia.getItems().clear();
		this.CBPilota1.setValue(null);
    	this.CBPilota2.setValue(null);
		

	    text1.setText("0");
        text2.setText("0");
        text4.setText("0");
        text5.setText("0");
        this.setCombos();
    	this.Segnalazione.clear();
        this.gotoRisultati();
    }
    
    
    void setCombos() {
    	this.ComboScuderia.getItems().addAll(model.getAllScuderie());
    	LinkedList<Pilota> piloti = new LinkedList<>(model.getAllPiloti());
    	Collections.sort(piloti);
    	this.CBPilota1.getItems().addAll(piloti);
    	this.CBPilota2.getItems().addAll(piloti);
    	
    }

    @FXML
    void initialize() {
        assert Azzera != null : "fx:id=\"Azzera\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CBPilota1 != null : "fx:id=\"CBPilota1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CBPilota2 != null : "fx:id=\"CBPilota2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert ComboScuderia != null : "fx:id=\"ComboScuderia\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Simula != null : "fx:id=\"Simula\" was not injected: check your FXML file 'Scene.fxml'.";
        assert text1 != null : "fx:id=\"text1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert text2 != null : "fx:id=\"text2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert text4 != null : "fx:id=\"text4\" was not injected: check your FXML file 'Scene.fxml'.";
        assert text5 != null : "fx:id=\"text5\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Segnalazione != null : "fx:id=\"Segnalazione\" was not injected: check your FXML file 'Scene.fxml'.";
        
        // Applica stili CSS ai componenti
        ComboScuderia.getStyleClass().add("combo-box");
        CBPilota1.getStyleClass().add("combo-box");
        CBPilota2.getStyleClass().add("combo-box");

        text1.getStyleClass().add("text-field");
        text2.getStyleClass().add("text-field");
        text4.getStyleClass().add("text-field");
        text5.getStyleClass().add("text-field");

        Azzera.getStyleClass().add("button");
        Simula.getStyleClass().add("button");

        Segnalazione.getStyleClass().add("text-area");
        
        text1.setText("0");
        text2.setText("0");
        text4.setText("0");
        text5.setText("0");
        
    }

	public void setModel(Model Model) {
		this.model = Model;	
		this.setCombos();
	}
	
	void gotoRisultati() throws Exception {
		CambiaScena.goToRisultati(stage, model);
	}

	public void setStage(Stage stage) {
		this.stage = stage;		
	}

	//ok
	
}
