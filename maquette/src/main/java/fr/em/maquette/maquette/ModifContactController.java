package fr.em.maquette.maquette;

import fr.em.controlledtextfield.ControlledTextField;
import fr.fs.metier.Personne;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ModifContactController {


    @FXML
    Label formatAlert;
    @FXML
    ControlledTextField nomControlledTextField;
    @FXML
    ControlledTextField prenomControlledTextField;
    @FXML
    ControlledTextField telephoneControlledTextField;


    Personne contact;

    final String regexNom = "^[a-zA-Z]{1}[\\s\\-'a-zA-Z]*$";
    final String regexTelephone = "^(\\+33[\\s.]?[1-9]|0[1-9])([\\s.]*[0-9]{2}){4}$";

    private Main main;

    @FXML
    public void initialize (){
        nomControlledTextField.setParameters("ok","incorrect",regexNom);
        prenomControlledTextField.setParameters("ok","incorrect",regexNom);
        telephoneControlledTextField.setParameters("tel ok","tel incorrect",regexTelephone);
    }

    public void setPerson (Personne contact){
        if (contact != null){
            this.contact = contact;
            nomControlledTextField.setText(contact.getNom());
            prenomControlledTextField.setText(contact.getPrenom());
            telephoneControlledTextField.setText(contact.getTelephone());
        }
        else
            System.out.println("contact est null");
    }

    public void ValiderModifContact(){
        contact.setAll(nomControlledTextField.getText(),prenomControlledTextField.getText(),telephoneControlledTextField.getText());
        Close();
    }

    public void Close() {
        main.getDialogueStage().close();
    }


    public void setMainapp(Main main) {
        this.main = main;

    }


}
