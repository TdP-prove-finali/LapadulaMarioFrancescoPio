package it.polito.tdp.SimulazioneF1;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.SimulazioneF1.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Azzera;

    @FXML
    private Button BtnConfermaScelta;

    @FXML
    private ComboBox<Pilota> CBPilota1;

    @FXML
    private ComboBox<Pilota> CBPilota2;

    @FXML
    private CheckBox CheckInvestimento;

    @FXML
    private CheckBox CheckPiloti;

    @FXML
    private ComboBox<Scuderia> ComboScuderia;

    @FXML
    private Button Simula;
    
    @FXML
    private TextField Segnalazione;

    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    @FXML
    private TextField text3;

    @FXML
    private TextField text4;

    @FXML
    private TextField text5;

    @FXML
    private TextField text6;
    
    Pilota p1;
    Pilota p2;

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

    }

    @FXML
    void DoConfermaScelta(ActionEvent event) {
    	
    	Pilota nuovo1 = this.CBPilota1.getValue();
    	Pilota nuovo2 = this.CBPilota2.getValue();
    	
    	if(nuovo1!=null) {
    		model.Scambio(this.getP1(), nuovo1);
    	}
    	if(nuovo2!=null) {
    		model.Scambio(this.getP2(), nuovo2);
    	}
    	
    	if(nuovo1.equals(nuovo2)) {
    		this.Segnalazione.setText("Inserire piloti diversi per la scuderia!\n");
    		return;
    	}
    	
    	//quando disablo impostare che si veda meglio
    	
    	this.CBPilota1.setDisable(true);
    	this.CBPilota2.setDisable(true);
    	this.CheckPiloti.setDisable(true);
    	
    	for(Pilota p : model.getAllPiloti()) {
    		System.out.println(p.toString()+" "+p.getS().toString());
    	}
    	
    	this.Segnalazione.clear();

    }

    @FXML
    void DoInvestimento(ActionEvent event) {

    }
    
    @FXML
    void DoPiloti(ActionEvent event) {
    	
    	this.ComboScuderia.setDisable(true);
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
    	
    	this.setP1(p1);
    	this.setP2(p2);
    	
    	this.CBPilota1.setValue(p1);
    	this.CBPilota2.setValue(p2);

    }

    @FXML
    void DoSimula(ActionEvent event) {

    }
    
    void setCombos() {
    	LinkedList<Pilota> piloti = new LinkedList<>(model.getAllPiloti());
    	Collections.sort(piloti);
    	this.CBPilota1.getItems().addAll(piloti);
    	this.CBPilota2.getItems().addAll(piloti);
    	this.ComboScuderia.getItems().addAll(model.getAllScuderie());
    	
    }

    @FXML
    void initialize() {
        assert Azzera != null : "fx:id=\"Azzera\" was not injected: check your FXML file 'Scene.fxml'.";
        assert BtnConfermaScelta != null : "fx:id=\"BtnConfermaScelta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CBPilota1 != null : "fx:id=\"CBPilota1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CBPilota2 != null : "fx:id=\"CBPilota2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CheckInvestimento != null : "fx:id=\"CheckInvestimento\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CheckPiloti != null : "fx:id=\"CheckPiloti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert ComboScuderia != null : "fx:id=\"ComboScuderia\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Simula != null : "fx:id=\"Simula\" was not injected: check your FXML file 'Scene.fxml'.";
        assert text1 != null : "fx:id=\"text1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert text2 != null : "fx:id=\"text2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert text3 != null : "fx:id=\"text3\" was not injected: check your FXML file 'Scene.fxml'.";
        assert text4 != null : "fx:id=\"text4\" was not injected: check your FXML file 'Scene.fxml'.";
        assert text5 != null : "fx:id=\"text5\" was not injected: check your FXML file 'Scene.fxml'.";
        assert text6 != null : "fx:id=\"text6\" was not injected: check your FXML file 'Scene.fxml'.";
    }

	public void setModel(Model Model) {
		this.model = Model;		
	}

}
