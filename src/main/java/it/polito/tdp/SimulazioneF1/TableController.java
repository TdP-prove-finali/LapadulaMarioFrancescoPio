package it.polito.tdp.SimulazioneF1;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.TableView;

public class TableController {

    private TableView<Riga> tableView;
    private ObservableList<Riga> data;

    public TableController(TableView<Riga> tableView) {
        this.tableView = tableView;
        
    }

    public void addRiga(Riga riga) {
        data.add(riga);
    }
    
    public void setdata(ObservableList<Riga> dati) {
    	this.data = dati;
    	this.tableView.setItems(data);
    }
    
}

