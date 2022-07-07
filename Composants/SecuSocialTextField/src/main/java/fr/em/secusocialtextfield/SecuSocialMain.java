
package fr.em.secusocialtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SecuSocialMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        SecuSocialTextField secuSocialTextField = new SecuSocialTextField();
        secuSocialTextField.setNIR("1860659512325");
        secuSocialTextField.setCle("88");
        secuSocialTextField.initialize();
        primaryStage.setScene(new Scene(secuSocialTextField));
        primaryStage.show();
        System.out.printf("nir : %s  clé : %s",secuSocialTextField.nirCorrect,secuSocialTextField.cleCorrect);
        System.out.println();
        System.out.println(secuSocialTextField.isCorrect());
    }
}
