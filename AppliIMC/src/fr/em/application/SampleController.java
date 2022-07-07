package fr.em.application;

import java.io.File;
import java.net.MalformedURLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import metier.CalcIMC;

public class SampleController {

	@FXML
	Button button;

	@FXML
	Label imc;

	@FXML
	TextField masseInput;

	@FXML
	TextField tailleInput;

	@FXML
	Label comment;

	@FXML
	ImageView imageView;

	@FXML
	public void initialize() {
		imc.setText("");
	}

	@FXML
	public void calcIMC() {
		try {
		CalcIMC calcimc = new CalcIMC(masseInput, tailleInput);
		imc.setText(calcimc.CalculerIMC());
		comment.setText(calcimc.ecrireComment());
		Image image2 = new Image("C:\\Java\\img\\" + calcimc.getRange() + ".png");
		imageView.setImage(image2);
		}  catch (Exception e ) {imc.setText("Entrez un format valide");}
	}
}
