package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.AnagrammiModel;
import it.polito.tdp.anagrammi.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class AnagrammiController {
	
	AnagrammiModel aM;	
	
	public void setModel(AnagrammiModel am){
		aM=am;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextFlow txtOutput;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	txtOutput.getChildren().clear();
    	String s=null;
    	s=txtInput.getText();
    	if(s.compareTo("")==0){
    		System.err.println("INSERISCI UNA PAROLA");
    		txtOutput.getChildren().add(new Text("Inserisci una Parola"));
    		return;
    	}
    	List<Parola>parole=new ArrayList<Parola>();    	
    	parole.addAll(aM.elencoAnagrammi(s));
    	
    	for(Parola p:parole){
    		Text t =new Text(p.toString()+"\n");
    		if(p.isCorretta())
    			t.setFill(Color.BLUE);
    		else
    			t.setFill(Color.BLACK);
			txtOutput.getChildren().add(t);
			
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtInput.clear();
    	txtOutput.getChildren().clear();
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}
