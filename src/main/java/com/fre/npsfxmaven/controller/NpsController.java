package com.fre.npsfxmaven.controller;

import com.fre.npsfxmaven.model.FileReaderAndWriter;
import com.fre.npsfxmaven.model.Nps;
import com.fre.npsfxmaven.model.NpsStorage;
import com.fre.npsfxmaven.model.Storable;
import com.fre.npsfxmaven.util.Timer;
import com.fre.npsfxmaven.view.FillFormView;
import com.fre.npsfxmaven.view.SwitchNpsView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

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
        infoLabel.setText(readerAndWriter.saveFile(npsStorage.getNpsRecords(), pathname));
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

// todo delete : npsStorage.setStorage(readerAndWriter.processFile("src/main/resources/com/fre/npsfxmaven/nps.txt"));
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
    void onSwitchNps() {
        SwitchNpsView switchView = new SwitchNpsView();
        switchView.getBtn().setOnAction(e -> {
            npsStorage.switchNps(switchView.getFirstNpsTextField().getText(),
                    switchView.getSecondNpsTextField().getText());
            tblData.setItems(getNpsObservableList());
            switchView.getStageSwitchNps().close();
        });
    }

    @FXML
    void onAddNpsClick() {
        FillFormView formView = new FillFormView();
        formView.getBtn().setOnAction(e -> {
            String processingOrder = formView.getProcessingOrderTextField().getText();
            nps = new Nps(
                    formView.getNameTextField().getText(), Integer.valueOf(processingOrder),
                    formView.getStateTextField().getText(), Integer.parseInt(formView.getPolicyTextField().getText()),
                    formView.getConditionTextField().getText(), formView.getConditionDataTextField().getText(),
                    formView.getProfileIdTextField().getText(), formView.getProfileDataTextField().getText()
            );

            nps.validate();

            infoLabel.setText(npsStorage.addNps(nps));
            Timer.delay(5000, () -> infoLabel.setText(""));

            //npsStorage.addNps(nps);
            tblData.setItems(getNpsObservableList());
            formView.getStage().close();
        });
    }

    public ObservableList<Storable> getNpsObservableList() {
        return FXCollections.observableArrayList(npsStorage.getNpsRecords());
    }
}