package fr.em.controlledtextfield;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class ControlledTextField extends BorderPane {

    @FXML
    private Label label;

    @FXML
    private TextField textField;

    boolean correct;

    public ControlledTextField(){
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("controlledTextField.fxml"));
        fxmlloader.setRoot(this);
        fxmlloader.setController(this);
        try{
            fxmlloader.load();
        }catch(IOException exception){
            exception.printStackTrace();
        }
        label.setText("");
    }

    public void setParameters(String texteCorrect, String texteIncorrect, String expressionReguliere){
        matchExpression(texteCorrect,texteIncorrect,expressionReguliere,textField.getText());
        textField.textProperty().addListener((observable,oldText,newText) -> matchExpression(texteCorrect,
                texteIncorrect,expressionReguliere,newText));
    }

    private void matchExpression(String texteCorrect, String texteIncorrect, String expressionReguliere, String newText) {
        if(newText.matches(expressionReguliere)){
            label.setText(texteCorrect);
            label.setTextFill(Color.GREEN);
            correct=true;
        }
        else {
            label.setText(texteIncorrect);
            label.setTextFill(Color.RED);
            correct=false;
        }
    }
    public boolean isCorrect(){
        return correct;
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String text) {
        this.textField.setText(text);
    }
}
