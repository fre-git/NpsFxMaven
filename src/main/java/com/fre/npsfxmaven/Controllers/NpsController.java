package com.fre.npsfxmaven.Controllers;

import com.fre.npsfxmaven.FileReaderAndWriter;
import com.fre.npsfxmaven.Nps;
import com.fre.npsfxmaven.NpsStorage;
import com.fre.npsfxmaven.Storable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class NpsController {
    FileReaderAndWriter readerAndWriter = new FileReaderAndWriter();
    NpsStorage npsStorage = new NpsStorage();
    File file;
    Storable nps;
    Stage stage;

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
        /*
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = new Stage();
        String pathname = fileChooser.showOpenDialog(stage).getPath();
        System.out.println(pathname);
        file = readerAndWriter.readFile(pathname);

         */



//Fix this for filechooser
        npsStorage.setStorage(readerAndWriter.processFile("src/main/resources/com/fre/npsfxmaven/nps.txt"));
        //npsStorage.setStorage(readerAndWriter.processFile(pathname));


        colLine.setCellValueFactory(new PropertyValueFactory<Storable, String>("fullLine"));
        colName.setCellValueFactory(new PropertyValueFactory<Storable, String>("name"));
        colOrder.setCellValueFactory(new PropertyValueFactory<Storable, Integer>("processingOrder"));

        tblData.setItems(getNpsObservableList());
    }

    @FXML
    void onSwitchNps(){

        Stage stageSwitchNps = new Stage();
        stageSwitchNps.setTitle("Give the processing order of the network policy servers you want to switch");

        GridPane grid = new GridPane();
        grid.setId("gridId");
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm());

        stageSwitchNps.setScene(scene);
        stageSwitchNps.setWidth(300);
        stageSwitchNps.setHeight(300);
        Label firstNps = new Label("First Nps");
        grid.add(firstNps, 0, 1);
        TextField firstNpsTextField = new TextField();
        grid.add(firstNpsTextField, 1, 1);

        Label secondNps = new Label("Second Nps");
        grid.add(secondNps, 0, 2);
        TextField secondNpsTextField = new TextField();
        grid.add(secondNpsTextField, 1, 2);



        Button btn = new Button("Switch processing order");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 10);
        stageSwitchNps.show();

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                npsStorage.getNps(firstNpsTextField.getText(),
                        secondNpsTextField.getText());

                tblData.setItems(getNpsObservableList());
                stageSwitchNps.close();

                //Nps nps = npsStorage.

/*
                String processingOrder = processingOrderTextField.getText();
                nps = new Nps(nameTextField.getText(),
                        Integer.valueOf(processingOrder),
                        processingOrderTextField.getText(),
                        Integer.valueOf(policyTextField.getText()),
                        conditionTextField.getText(),
                        conditionDataTextField.getText(),
                        profileIdTextField.getText(),
                        profileDataTextField.getText());

                // System.out.println(nps);
                npsStorage.addNps(nps);
                System.out.println(npsStorage);

                // FXMLLoader loader = new FXMLLoader(getClass().getResource())
                tblData.setItems(getNpsObservableList());
                stageSwitchNps.close();
 */
            }
        });






        /*
        TableView.TableViewSelectionModel<Storable> selectionModel =
                tblData.getSelectionModel();

        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        Storable n = selectionModel.getSelectedItem();
        System.out.println(n);
        Storable n2 = selectionModel.getSelectedItem();
        System.out.println(n2);

        // npsStorage.
        tblData.setItems(getNpsObservableList())
        Storable firstNps = tblData.getItems().get(1);
        Storable secondNps = tblData.getItems().get(3);
        npsStorage.switchNps(firstNps, secondNps);
        npsStorage.
         */
    }

    @FXML
    void onAddNpsClick(ActionEvent event) throws IOException {
        Stage stage1 = new Stage();
        stage1.setTitle("Fill in NP properties");

        GridPane grid = new GridPane();
        grid.setId("gridId");
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm());

        stage1.setScene(scene);
        stage1.setWidth(400);
        stage1.setHeight(500);
        Label npName = new Label("NP name");
        grid.add(npName, 0, 1);
        TextField nameTextField = new TextField();
        grid.add(nameTextField, 1, 1);

        Label processingOrderLabel = new Label("Processing Order");
        grid.add(processingOrderLabel, 0, 2);
        TextField processingOrderTextField = new TextField();
        grid.add(processingOrderTextField, 1, 2);

        Label stateLabel = new Label("State");
        grid.add(stateLabel, 0, 3);
        TextField stateTextField = new TextField("enable");
        grid.add(stateTextField, 1, 3);

        Label policyLabel = new Label("Policy source");
        grid.add(policyLabel, 0, 4);
        TextField policyTextField = new TextField("0");
        grid.add(policyTextField, 1, 4);

        Label conditionLabel = new Label("Condition id");
        grid.add(conditionLabel, 0, 5);
        TextField conditionTextField = new TextField("0x1023");
        grid.add(conditionTextField, 1, 5);

        Label conditionDataLabel = new Label("Condition data");
        grid.add(conditionDataLabel, 0, 6);
        TextField conditionDataTextField = new TextField("S-1-5-21-21230147-39487222091-3732445045-");
        grid.add(conditionDataTextField, 1, 6);

        Label profileIdLabel = new Label("Profile id");
        grid.add(profileIdLabel, 0, 7);
        TextField profileIdTextField = new TextField("0x100f");
        grid.add(profileIdTextField, 1, 7);

        Label profileDataLabel = new Label("Profile data");
        grid.add(profileDataLabel, 0, 8);
        TextField profileDataTextField = new TextField("TRUE");
        grid.add(profileDataTextField, 1, 8);

        Button btn = new Button("Add new NPS");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 10);
        stage1.show();

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                String processingOrder = processingOrderTextField.getText();
                nps = new Nps(nameTextField.getText(),
                        Integer.valueOf(processingOrder),
                        processingOrderTextField.getText(),
                        Integer.valueOf(policyTextField.getText()),
                        conditionTextField.getText(),
                        conditionDataTextField.getText(),
                        profileIdTextField.getText(),
                        profileDataTextField.getText());

                // System.out.println(nps);
                npsStorage.addNps(nps);
                System.out.println(npsStorage);

                // FXMLLoader loader = new FXMLLoader(getClass().getResource())
                tblData.setItems(getNpsObservableList());
                stage1.close();
            }
        });





        /*
        AddNewNpsFormsController npsForm = new AddNewNpsFormsController();
        npsForm.stage.show();

        /*


        System.out.println("nps: + + "  + nps);
        AddNewNpsFormsController npsForm = new AddNewNpsFormsController();
        npsForm.stage.show();

        Stage stage = new Stage();
        HBox hbox = new HBox(new Label("Fill in properties for the new NPS"));
        Scene scene = new Scene(hbox);
        stage.setScene(scene);
        stage.setWidth(300);
        stage.setHeight(600);

        stage.show();





        //npsStorage.addNps(nps));

        tblData.setItems(getNpsObservableList());
        */
    }

    public ObservableList<Storable> getNpsObservableList(){
        ObservableList<Storable> npsSet = FXCollections.observableArrayList(npsStorage.getNpsRecords());
        return npsSet;
    }

}