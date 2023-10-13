package com.fre.npsfxmaven;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class NpsController {
    FileReaderAndWriter readerAndWriter = new FileReaderAndWriter();
    NpsStorage npsStorage = new NpsStorage();
    File file;

    @FXML
    private AnchorPane AnchorPaneId;

    @FXML
    private Button Button1;

    @FXML
    private Button buttonAddNps;

    @FXML
    private VBox VBoxId;

    @FXML
    private Label welcomeText;

    @FXML
    private TableView<Storable> tblData;
    @FXML
    private TableColumn<Storable, String> colLine;

    @FXML
    private TableColumn<Storable, String> colName;

    @FXML
    private TableColumn<Storable, Integer> colOrder;

    @FXML
    void loadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = new Stage();
        String pathname = fileChooser.showOpenDialog(stage).getPath();
        file = readerAndWriter.readFile(pathname);
        npsStorage.setStorage(readerAndWriter.processFile(pathname));

        colLine.setCellValueFactory(new PropertyValueFactory<Storable, String>("fullLine"));
        colName.setCellValueFactory(new PropertyValueFactory<Storable, String>("name"));
        colOrder.setCellValueFactory(new PropertyValueFactory<Storable, Integer>("processingOrder"));
        tblData.setItems(getNpsObservableList());
    }

    @FXML
    void onAddNpsClick() {
        Stage stage = new Stage();
        stage.show();
        System.out.println("start adding");
        String line = "add np name=\"Tel_CMP1_VLAN_100____EOVOIP\" state=\"enable\" processingorder=\"20\" policysource=\"0\" conditionid=\"0x1023\" conditiondata=\"S-1-5-21-21230147-39487222091-3732445045-1631\" profileid=\"0x100f\" profiledata=\"TRUE\"";
        String name = "Tel_CMP1_VLAN_100____EOVOIP";
        int order = 1;
        Nps nps = new Nps(line, name, order);
        npsStorage.addNps(nps);

        //TreeSet<Storable> treeSet = new TreeSet<>(npsStorage.getNpsRecords());

        tblData.setItems(getNpsObservableList());
    }

    public ObservableList<Storable> getNpsObservableList(){
        ObservableList<Storable> npsSet = FXCollections.observableArrayList(npsStorage.getNpsRecords());
        return npsSet;
    }
}