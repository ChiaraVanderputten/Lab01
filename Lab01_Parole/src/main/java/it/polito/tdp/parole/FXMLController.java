package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;
import it.polito.tdp.parole.model.Parole2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	//Parole elenco ;
	Parole2 elenco;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancella;
    
    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtTempiDiProcesso;
    
    @FXML
    void doCancella(ActionEvent event) {

    	String daCancellare = txtResult.getSelectedText();
    	
    	long start = System.nanoTime();  
    	elenco.elimina(daCancellare);
    	long finish = System.nanoTime() - start;
    	
    	txtResult.clear();
    	txtResult.appendText(elenco.getStringa());
    	
    	txtTempiDiProcesso.clear();
    	txtTempiDiProcesso.appendText( "Il tempo di processo per cancellare dall'elenco la parola selezionata è:  "+finish);
    }

    @FXML
    void doInsert(ActionEvent event) {
    	
        String parola = txtParola.getText();               //prendo la parola nel TextField
       
        long start = System.nanoTime();
        elenco.addParola(parola);                          //aggiungo la parola all'elenco
        long finish = System.nanoTime() - start;
        
       /* if(parola.matches("(?=.*[0-9])(?=.*[@#!?]).{1,100}")) {
     	   
        } */
     	   
        txtParola.clear();
        txtResult.clear();
        
        txtResult.appendText(elenco.getStringa());      //ritorno l'elenco
        
        txtTempiDiProcesso.clear();
    	txtTempiDiProcesso.appendText( "Il tempo di processo per aggiungere all'elenco la parola è:  "+finish);

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	long start = System.nanoTime();   
    	elenco.reset();
    	long finish = System.nanoTime() - start;
    	txtResult.clear();
    	txtTempiDiProcesso.clear();
    	txtTempiDiProcesso.appendText( "Il tempo di processo per resettare l'elenco è:  "+finish);

    }
    
    //Faccio una prova per vedere i tempi con le linkedList
    //aggiungo la parola "a"
    //Il tempo di processo per aggiungere all'elenco la parola è:  9500 
    //Il tempo di processo per resettare l'elenco è:  10100
    //Il tempo di processo per cancellare dall'elenco la parola selezionata è:  9700
    
    //Ora faccio la stessa prova ma con le ArrayList vado a usare la classe Parole2
    //Il tempo di processo per aggiungere all'elenco la parola è:  6800
    //Il tempo di processo per resettare l'elenco è:  8500
    //Il tempo di processo per cancellare dall'elenco la parola selezionata è:  12000

    @FXML
    void initialize() {
    	
    	 assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
         assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
         assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
         assert txtTempiDiProcesso != null : "fx:id=\"txtTempiDiProcesso\" was not injected: check your FXML file 'Scene.fxml'.";
         assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
         assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        //elenco = new Parole() ;
         elenco = new Parole2() ;
    }
}
