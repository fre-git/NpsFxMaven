package com.fre.npsfxmaven.view;

import com.fre.npsfxmaven.FileReaderAndWriter;
import com.fre.npsfxmaven.NpsStorage;
import com.fre.npsfxmaven.Storable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class AppView {
    /*
    FileReaderAndWriter readerAndWriter;
    NpsStorage npsStorage;
    FileChooser fileChooser;
    File file;

    public AppView(File file, TableView<Storable> tblData, TableColumn<Storable,
            String> colLine, TableColumn<Storable, String> colName, TableColumn<Storable, Integer> colOrder) {
        readerAndWriter = new FileReaderAndWriter();
        npsStorage = new NpsStorage();
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = new Stage();
        String pathname = fileChooser.showOpenDialog(stage).getPath();
        file = readerAndWriter.readFile(pathname);
        this.file = file;
        npsStorage.setStorage(readerAndWriter.processFile(pathname));

        colLine.setCellValueFactory(new PropertyValueFactory<Storable, String>("fullLine"));
        colName.setCellValueFactory(new PropertyValueFactory<Storable, String>("name"));
        colOrder.setCellValueFactory(new PropertyValueFactory<Storable, Integer>("processingOrder"));
        tblData.setItems(getNpsObservableList());
    }

    public ObservableList<Storable> getNpsObservableList(){
        ObservableList<Storable> npsSet = FXCollections.observableArrayList(npsStorage.getNpsRecords());
        return npsSet;
    }

     */
}
