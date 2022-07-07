package fr.em.controller;

import fr.em.metier.BeanSelectionTable;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;

import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;


public class SelectionTableController extends AnchorPane {
    @FXML
    private TextField textField;
    @FXML
    ListView tableGauche;
    @FXML
    ListView tableDroite;


    public BeanSelectionTable bean;


    public SelectionTableController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SelectionTable.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
            bean = new BeanSelectionTable();
            tableGauche.setItems(bean.getDispoFiltre());
            tableDroite.setItems(bean.getSelectedFiltre());
            textField.textProperty().addListener((observableValue, oldValue, newValue) -> bean.filtrer(newValue));
            gestionDoubleClick();
            gestionDragStart();
            gestionDragDropped();
            gestionDragOver();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setParameters(ArrayList disponible, ArrayList selected) {
        bean.setListes(disponible, selected);
    }

    private void gestionDoubleClick() {
        tableGauche.setOnMouseClicked(click -> {
            if (click.getClickCount() == 2) {
                bean.select(tableGauche.getSelectionModel().getSelectedItems());
            }
        });
        tableDroite.setOnMouseClicked(click -> {
            if (click.getClickCount() == 2) {
                bean.unSelect(tableDroite.getSelectionModel().getSelectedItems());
            }
        });
    }


    private void gestionDragStart() {
        tableGauche.setOnDragDetected(dragEvent -> {
            final Dragboard dragBoard = tableGauche.startDragAndDrop(TransferMode.MOVE);
            final ClipboardContent content = new ClipboardContent();
            content.putString("Selectionner");
            dragBoard.setContent(content);
            dragEvent.consume();
        });
        tableDroite.setOnDragDetected(dragEvent -> {
            final Dragboard dragBoard = tableDroite.startDragAndDrop(TransferMode.MOVE);
            final ClipboardContent content = new ClipboardContent();
            content.putString("Selectionner");
            dragBoard.setContent(content);
            dragEvent.consume();
        });
    }

    private void gestionDragOver() {
        tableDroite.setOnDragOver(dragEvent -> {
            if (dragEvent.getGestureSource() == tableGauche){
                dragEvent.acceptTransferModes(TransferMode.ANY);}
            dragEvent.consume();
        });
        tableGauche.setOnDragOver(dragEvent -> {
            if (dragEvent.getGestureSource() == tableDroite){
                dragEvent.acceptTransferModes(TransferMode.ANY);}
            dragEvent.consume();
        });
        textField.setOnDragOver(dragEvent -> {
            if (dragEvent.getGestureSource() == tableGauche || dragEvent.getGestureSource() == tableDroite){
                dragEvent.acceptTransferModes(TransferMode.ANY);}
            dragEvent.consume();
        });
    }

    private void gestionDragDropped() {
        tableDroite.setOnDragDropped(dragEvent -> {
            if (dragEvent.getGestureSource() == tableGauche){
                selectOne();}
            dragEvent.consume();
        });
        tableGauche.setOnDragDropped(dragEvent -> {
            if (dragEvent.getGestureSource() == tableDroite){
                unSelectOne();}
            dragEvent.consume();
        });
        textField.setOnDragDropped(dragEvent -> {
            if (dragEvent.getGestureSource() == tableGauche && tableGauche.getSelectionModel().getSelectedItems().size() == 1)
                textField.setText(tableGauche.getSelectionModel().getSelectedItem().toString());
            dragEvent.consume();
        });
    }

    @FXML
    public void selectOne() {
        if (tableGauche.getSelectionModel().getSelectedItem() != null) {
            bean.select(tableGauche.getSelectionModel().getSelectedItems());
        }
        tableGauche.getSelectionModel().clearSelection();
    }

    @FXML
    private void unSelectOne() {
        if (tableDroite.getSelectionModel().getSelectedItem() != null) {
            bean.unSelect(tableDroite.getSelectionModel().getSelectedItems());
        }
        tableDroite.getSelectionModel().clearSelection();
    }

    @FXML
    public void selectAll() {
        //if (tableGauche.getSelectionModel().getSelectedItem() != null)
        bean.selectAll();

        tableGauche.getSelectionModel().clearSelection();
    }

    @FXML
    private void unSelectAll() {
        //if (tableDroite.getSelectionModel().getSelectedItem() != null)
        bean.unSelectAll();

        tableGauche.getSelectionModel().clearSelection();
    }

    public void setMultipleSelect(boolean b) {
        if (b) {
            tableGauche.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            tableDroite.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        }
    }
}


