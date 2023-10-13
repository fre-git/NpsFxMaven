package com.fre.npsfxmaven.Controllers;

import com.fre.npsfxmaven.FileReaderAndWriter;
import com.fre.npsfxmaven.Nps;
import com.fre.npsfxmaven.NpsStorage;
import com.fre.npsfxmaven.Storable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class NpsController {
    FileReaderAndWriter readerAndWriter = new FileReaderAndWriter();
    NpsStorage npsStorage = new NpsStorage();
    File file;
    //Storable nps;

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
        AddNewNpsFormsController npsForm = new AddNewNpsFormsController();
        npsForm.stage.show();

        /*
        Stage stage = new Stage();
        HBox hbox = new HBox(new Label("Fill in properties for the new NPS"));
        Scene scene = new Scene(hbox);
        stage.setScene(scene);
        stage.setWidth(300);
        stage.setHeight(600);

        stage.show();

         */



        //npsStorage.addNps(nps));






        tblData.setItems(getNpsObservableList());
    }

    public ObservableList<Storable> getNpsObservableList(){
        ObservableList<Storable> npsSet = FXCollections.observableArrayList(npsStorage.getNpsRecords());
        return npsSet;
    }




}