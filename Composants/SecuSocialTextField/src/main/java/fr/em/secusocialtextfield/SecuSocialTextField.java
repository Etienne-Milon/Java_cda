package fr.em.secusocialtextfield;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class SecuSocialTextField extends BorderPane {

    @FXML
    TextField nirTextField;
    @FXML
    TextField cleTextField;

    @FXML
    Label label;
    boolean nirCorrect;
    boolean cleCorrect;

    final String NIR = "^[1-478][0-9]{2}(0[1-9]|1[0-2]|[2-3][0-9]|4[0-2]|[5-9][0-9])(2[ABab]|[0-9]{2})(00[1-9]|0[1-9][0-9]|[1-8][0-9]{2}|9[0-8][0-9]|990)(00[1-9]|0[1-9][0-9]|[1-9][0-9]{2})$";

    public SecuSocialTextField(){
        FXMLLoader fxmlLoader = new FXMLLoader(SecuSocialTextField.class.getResource("nir.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void initialize(){
        matchNir(nirTextField.getText());
        nirTextField.textProperty().addListener((observable,oldText,newText) -> matchNir(newText));
        long nirValue = Long.parseLong(nirTextField.getText());
        matchCle(nirValue,cleTextField.getText());
        cleTextField.textProperty().addListener((observable,oldText,newText) -> matchCle(nirValue,newText));
    }

    private void matchNir(String newText) {
        if(newText.matches(NIR)){
            label.setText("NIR correct");
            label.setTextFill(Color.GREEN);
            nirCorrect=true;
        }
        else {
            label.setText("NIR incorrect");
            label.setTextFill(Color.RED);
            nirCorrect=false;
        }
    }
    private void matchCle(long nirValue,String cle) {
        long result = (97 - (nirValue%97));
        if (Long.parseLong(cle) == result){
            cleCorrect=true;
            if (isCorrect()){
                label.setText("NIR & Clé correcte");
                label.setTextFill(Color.GREEN);
            }
        }
        else {
            label.setText("Clé incorrecte");
            label.setTextFill(Color.RED);
            cleCorrect=false;
        }
    }
    public boolean isCorrect(){
        return (nirCorrect && cleCorrect);
    }

    public String getNir() {
        return nirTextField.getText();
    }
    public String getCle() {
        return cleTextField.getText();
    }

    public void setNIR(String text) {
        this.nirTextField.setText(text);
    }
    public void setCle(String text) {
        this.cleTextField.setText(text);
    }
}




