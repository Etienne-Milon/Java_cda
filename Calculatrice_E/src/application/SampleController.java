package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import metier.Calculatrice;
import javafx.event.Event;

public class SampleController {
	
	
	
	@FXML
	Label label;
	
	
	
	@FXML
	public void onClick(Event event) {
		Calculatrice calculette = new Calculatrice()  ;
		Button button = (Button) event.getSource();
		label.setText(calculette.Exec(button.getText()));
		

		
	}
	
	
	
}
