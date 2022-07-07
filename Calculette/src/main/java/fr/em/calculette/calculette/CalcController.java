package fr.em.calculette.calculette;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalcController {

    @FXML
    private Label saisie;
    @FXML
    private Label resultat;

    @FXML
    Calculatrice calculette = new Calculatrice();

    @FXML
    public void onClick(Event event)
    {
        Button button = (Button) event.getSource();
        calculette.touche(button.getText());
        saisie.setText(calculette.toString());
        //resultat.setText(calculette.resultat());
    }


}