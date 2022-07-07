package fr.em.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;


public class SelectionTableMain extends Application {

ArrayList names = new ArrayList<>(Arrays.asList("Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise", "Denis", "Denose", "Denuse","Den"));
ArrayList empty = new ArrayList<>(Arrays.asList("Rouge"));

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
        try{
        SelectionTableController selectionTableController = new SelectionTableController();
        selectionTableController.setParameters(names,empty);
        selectionTableController.setMultipleSelect(true);
        primaryStage.setTitle("Selection table test");

        primaryStage.setScene(new Scene(selectionTableController));
        primaryStage.show();}
        catch (Exception e){e.printStackTrace();}
    }


}