package fr.em.metier;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.util.List;


public class BeanSelectionTable<T> {

    private ObservableList<T> dispo;
    private ObservableList<T> selected;
    private FilteredList<T> dispoFiltre;
    private FilteredList<T> selectedFiltre;

    public BeanSelectionTable() {
        dispo = FXCollections.observableArrayList();
        selected = FXCollections.observableArrayList();
        dispoFiltre = new FilteredList<>(dispo);
        selectedFiltre = new FilteredList<>(selected);
    }

    public void setListes (List<T> dispo, List<T> selected){
        for (T elementLu : dispo){
            if (selected.indexOf(elementLu) == -1)
                this.dispo.add(elementLu);
        }
        for (T elementLu : selected){
            //if (dispo.indexOf(elementLu) == -1)
            this.selected.add(elementLu);
        }
    }

    public ObservableList<T> getSelectedFiltre(){return selectedFiltre;}
    public ObservableList<T> getDispoFiltre(){return dispoFiltre;}


    public void select(List<T> selectedItems) {
        selected.addAll(selectedItems);
        dispo.removeAll(selectedItems);
    }

    public void unSelect(ObservableList<T> selectedItems) {
        dispo.addAll(selectedItems);
        selected.removeAll(selectedItems);
    }

    public void selectAll(){
        selected.addAll(dispoFiltre);
        dispo.removeAll(selected);
    }

    public void unSelectAll(){
        dispo.addAll(selectedFiltre);
        selected.removeAll(dispo);
    }

    public void filtrer(String filtre){
        dispoFiltre.setPredicate(element -> isContains(filtre,element));
    }

    private boolean isContains(String filtre, T element) {
        return element.toString().toUpperCase().contains(filtre.toUpperCase());
    }

    @Override
    public String toString() {
        return "" ;
    }





}
