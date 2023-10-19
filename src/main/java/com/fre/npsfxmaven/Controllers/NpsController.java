package com.fre.npsfxmaven.Controllers;

import com.fre.npsfxmaven.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class NpsController {
    FileReaderAndWriter readerAndWriter = new FileReaderAndWriter();
    NpsStorage npsStorage = new NpsStorage();
    Storable nps;
    File file;
    String pathname;

    @FXML
    private Label infoLabel;

    @FXML
    private TableView<Storable> tblData;

    @FXML
    private TableColumn<Storable, String> colName;

    @FXML
    private TableColumn<Storable, String> colState;

    @FXML
    private TableColumn<Storable, Integer> colOrder;

    @FXML
    private TableColumn<Storable, String> colPolicy;

    @FXML
    private TableColumn<Storable, String> colConditionId;

    @FXML
    private TableColumn<Storable, String> colConditionData;

    @FXML
    private TableColumn<Storable, String> colProfileId;

    @FXML
    private TableColumn<Storable, String> colProfileData;

    @FXML
    void saveFile() throws IOException {
        infoLabel.setText(readerAndWriter.saveFile(npsStorage.getNpsRecords()));
        Timer.delay(5000, () -> infoLabel.setText(""));
    }

    @FXML
    void saveFileAs() throws IOException {
        infoLabel.setText(readerAndWriter.saveFileAs(npsStorage.getNpsRecords()));
        Timer.delay(5000, () -> infoLabel.setText(""));
    }


    @FXML
    void loadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = new Stage();
        pathname = fileChooser.showOpenDialog(stage).getPath();
        System.out.println(pathname);
        file = readerAndWriter.readFile(pathname);

//TODO delete

// npsStorage.setStorage(readerAndWriter.processFile("src/main/resources/com/fre/npsfxmaven/nps.txt"));
        npsStorage.setStorage(readerAndWriter.processFile(pathname));
        loadTableview();
    }

    private void loadTableview() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colOrder.setCellValueFactory(new PropertyValueFactory<>("processingOrder"));
        colState.setCellValueFactory(new PropertyValueFactory<>("state"));
        colPolicy.setCellValueFactory(new PropertyValueFactory<>("policySource"));
        colConditionId.setCellValueFactory(new PropertyValueFactory<>("conditionId"));
        colConditionData.setCellValueFactory(new PropertyValueFactory<>("conditionData"));
        colProfileId.setCellValueFactory(new PropertyValueFactory<>("profileId"));
        colProfileData.setCellValueFactory(new PropertyValueFactory<>("profileData"));

        tblData.setItems(getNpsObservableList());
    }

    @FXML
    void onSwitchNps(){
        Stage stageSwitchNps = new Stage();
        stageSwitchNps.setTitle("Switch NPS priority");

        GridPane grid = initiateGrid();
        Scene scene = new Scene(grid);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm());
        stageSwitchNps.setScene(scene);
        stageSwitchNps.setWidth(400);
        stageSwitchNps.setHeight(250);

        Label firstNps = new Label("processing order 1st Nps");
        grid.add(firstNps, 0, 1);
        TextField firstNpsTextField = new TextField();
        grid.add(firstNpsTextField, 1, 1);

        Label secondNps = new Label("processing order 2nd Nps");
        grid.add(secondNps, 0, 2);
        TextField secondNpsTextField = new TextField();
        grid.add(secondNpsTextField, 1, 2);

        Button btn = new Button("Switch processing order");
        grid.add(btn, 1, 10);
        stageSwitchNps.show();

        btn.setOnAction(e -> {
            npsStorage.getNps(firstNpsTextField.getText(),
                    secondNpsTextField.getText());
            tblData.setItems(getNpsObservableList());
            stageSwitchNps.close();
        });
    }

    @FXML
    void onAddNpsClick() {
        Stage stage1 = new Stage();
        stage1.setTitle("Fill in NP properties");

        GridPane grid = initiateGrid();
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

        btn.setOnAction(e -> {
            String processingOrder = processingOrderTextField.getText();
            nps = new Nps(nameTextField.getText(),
                    Integer.valueOf(processingOrder),
                    stateTextField.getText(),
                    Integer.parseInt(policyTextField.getText()),
                    conditionTextField.getText(),
                    conditionDataTextField.getText(),
                    profileIdTextField.getText(),
                    profileDataTextField.getText());

            npsStorage.addNps(nps);
            tblData.setItems(getNpsObservableList());
            stage1.close();
        });
    }

    private GridPane initiateGrid() {
        GridPane grid = new GridPane();
        grid.setId("gridId");
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        return grid;
    }

    public ObservableList<Storable> getNpsObservableList(){
        ObservableList<Storable> npsSet = FXCollections.observableArrayList(npsStorage.getNpsRecords());
        return npsSet;
    }
}