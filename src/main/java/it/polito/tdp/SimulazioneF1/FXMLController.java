package it.polito.tdp.SimulazioneF1;

import java.net.URL;
import java.util.ArrayList;
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
		this.CheckPiloti.setDisable(false);
		this.CheckPiloti.setSelected(false);
		this.CBPilota1.setValue(null);
    	this.CBPilota2.setValue(null);
		
		this.Segnalazione.clear();
	    text1.setText("0");
        text2.setText("0");
        text3.setText("0");
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
    void DoConfermaScelta(ActionEvent event) {
    	
    	Pilota nuovo1 = this.CBPilota1.getValue();
    	Pilota nuovo2 = this.CBPilota2.getValue();
    	
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
    	
    	//quando disablo impostare che si veda meglio
    	
    	this.ComboScuderia.setDisable(true);
    	this.CBPilota1.setDisable(true);
    	this.CBPilota2.setDisable(true);
    	this.CheckPiloti.setDisable(true);
    	
    	this.Segnalazione.clear();

    }
    
    @FXML
    void DoPiloti(ActionEvent event) {
    	
    	if(this.ComboScuderia.getValue()==null) {
    		this.Segnalazione.appendText("Prima di scegliere i piloti selezionare una scuderia.");
    		return;
    	}
    	
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
    	
    	this.CheckPiloti.setDisable(true);

    }

    @FXML
    void DoSimula(ActionEvent event) {
    	
    	Pilota nuovo1 = this.CBPilota1.getValue();
    	Pilota nuovo2 = this.CBPilota2.getValue();
    	
    	if(nuovo1==null || nuovo2==null) {
    		this.Segnalazione.appendText("Inserire i piloti che gareggeranno per la tua squadra.");
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
    	
    	//se funziona posso togliere la roba dei P1 e P2
    	//al momento funziona
    	
    	String aero = this.text1.getText();
    	String telaio = this.text2.getText();
    	String pit = this.text3.getText();
    	String motore = this.text4.getText();
    	String aff = this.text5.getText();
    	
    	try {
    		int Aero = Integer.parseInt(aero);
    		int Telaio = Integer.parseInt(telaio);
    		int Pit = Integer.parseInt(pit);
    		int Motore = Integer.parseInt(motore);
    		int Aff = Integer.parseInt(aff);
    		
    		if((Aero+Telaio+Aff+Pit+Motore)>140) {
    			this.Segnalazione.appendText("Inserire importi la cui somma sia minore o uguale al limite imposto dal Budget Cup pari a 140 Milioni.");
    			return;
    		}else {
    			this.investimenti = new ArrayList<>();
    			investimenti.add(Aero);
    			investimenti.add(Telaio);
    			investimenti.add(Pit);
    			investimenti.add(Motore);
    			investimenti.add(Aff);
    		}
    		
    		
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    		this.Segnalazione.appendText("I dati inseriti sono errati.\nInserire numeri interi.");
    	} 
    	
    	//controlli
    	if(this.ComboScuderia.getValue()!=null && this.investimenti.size()==5) {
    		model.simula(this.ComboScuderia.getValue(), investimenti.get(0), investimenti.get(1), investimenti.get(2), investimenti.get(3), investimenti.get(4), this.getP1(), this.getP2());
    	
    	}
    	
    	//azzerare tutti i campi
		this.setP1(null);
		this.setP2(null);
		
		this.ComboScuderia.setDisable(false);
		this.ComboScuderia.setValue(null);
		this.CheckPiloti.setDisable(false);
		this.CheckPiloti.setSelected(false);
		this.CBPilota1.setValue(null);
    	this.CBPilota2.setValue(null);
		
		this.Segnalazione.clear();
	    text1.setText("0");
        text2.setText("0");
        text3.setText("0");
        text4.setText("0");
        text5.setText("0");
    	
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
        assert BtnConfermaScelta != null : "fx:id=\"BtnConfermaScelta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CBPilota1 != null : "fx:id=\"CBPilota1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CBPilota2 != null : "fx:id=\"CBPilota2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CheckPiloti != null : "fx:id=\"CheckPiloti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert ComboScuderia != null : "fx:id=\"ComboScuderia\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Simula != null : "fx:id=\"Simula\" was not injected: check your FXML file 'Scene.fxml'.";
        assert text1 != null : "fx:id=\"text1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert text2 != null : "fx:id=\"text2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert text3 != null : "fx:id=\"text3\" was not injected: check your FXML file 'Scene.fxml'.";
        assert text4 != null : "fx:id=\"text4\" was not injected: check your FXML file 'Scene.fxml'.";
        assert text5 != null : "fx:id=\"text5\" was not injected: check your FXML file 'Scene.fxml'.";
        text1.setText("0");
        text2.setText("0");
        text3.setText("0");
        text4.setText("0");
        text5.setText("0");
        
    }

	public void setModel(Model Model) {
		this.model = Model;		
	}

}
