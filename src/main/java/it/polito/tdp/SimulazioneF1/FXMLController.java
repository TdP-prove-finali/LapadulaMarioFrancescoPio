package it.polito.tdp.SimulazioneF1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Azzera;

    @FXML
    private Button BtnConfermaScelta;

    @FXML
    private ComboBox<?> CBPilota1;

    @FXML
    private ComboBox<?> CBPilota2;

    @FXML
    private CheckBox CheckInvestimento;

    @FXML
    private CheckBox CheckPiloti;

    @FXML
    private ComboBox<?> ComboScuderia;

    @FXML
    private Button Simula;

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

    @FXML
    void DoAzzera(ActionEvent event) {

    }

    @FXML
    void DoConfermaScelta(ActionEvent event) {

    }

    @FXML
    void DoInvestimento(ActionEvent event) {

    }

    @FXML
    void DoPiloti(ActionEvent event) {

    }

    @FXML
    void DoSimula(ActionEvent event) {

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

}
