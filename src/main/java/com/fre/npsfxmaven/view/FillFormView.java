package com.fre.npsfxmaven.view;

import com.fre.npsfxmaven.util.GridBuilder;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

public class FillFormView {
    Stage stage;
    Scene scene;
    Button btn;
    TextField nameTextField;
    TextField processingOrderTextField;
    TextField stateTextField;
    TextField policyTextField;
    TextField conditionTextField;
    TextField conditionDataTextField;
    TextField profileIdTextField;
    TextField profileDataTextField;
    GridPane grid;

    public FillFormView() {
        stage = new Stage();
        stage.setTitle("Fill in NP properties");

        grid = GridBuilder.initiateGrid();
        scene = new Scene(grid);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(500);
        Label npName = new Label("NP name");
        grid.add(npName, 0, 1);
        nameTextField = new TextField();
        grid.add(nameTextField, 1, 1);

        Label processingOrderLabel = new Label("Processing Order");
        grid.add(processingOrderLabel, 0, 2);
        processingOrderTextField = new TextField();
        grid.add(processingOrderTextField, 1, 2);

        Label stateLabel = new Label("State");
        grid.add(stateLabel, 0, 3);
        stateTextField = new TextField("enable");
        grid.add(stateTextField, 1, 3);

        Label policyLabel = new Label("Policy source");
        grid.add(policyLabel, 0, 4);
        policyTextField = new TextField("0");
        grid.add(policyTextField, 1, 4);

        Label conditionLabel = new Label("Condition id");
        grid.add(conditionLabel, 0, 5);
        conditionTextField = new TextField("0x1023");
        grid.add(conditionTextField, 1, 5);

        Label conditionDataLabel = new Label("Condition data");
        grid.add(conditionDataLabel, 0, 6);
        conditionDataTextField = new TextField("S-1-5-21-21230147-39487222091-3732445045-");
        grid.add(conditionDataTextField, 1, 6);

        Label profileIdLabel = new Label("Profile id");
        grid.add(profileIdLabel, 0, 7);
        profileIdTextField = new TextField("0x100f");
        grid.add(profileIdTextField, 1, 7);

        Label profileDataLabel = new Label("Profile data");
        grid.add(profileDataLabel, 0, 8);
        profileDataTextField = new TextField("TRUE");
        grid.add(profileDataTextField, 1, 8);

        /*
        infoLabel = new Label("");
        grid.add(infoLabel,0, 11);

         */

        btn = new Button("Add new NPS");

        grid.add(btn, 1, 10);
        stage.show();
    }

    public TextField getNameTextField() {
        return nameTextField;
    }

    public TextField getProcessingOrderTextField() {
        return processingOrderTextField;
    }

    public TextField getStateTextField() {
        return stateTextField;
    }

    public TextField getPolicyTextField() {
        return policyTextField;
    }

    public TextField getConditionTextField() {
        return conditionTextField;
    }

    public TextField getConditionDataTextField() {
        return conditionDataTextField;
    }

    public TextField getProfileIdTextField() {
        return profileIdTextField;
    }

    public TextField getProfileDataTextField() {
        return profileDataTextField;
    }

    public Button getBtn() {
        return btn;
    }

    public Stage getStage() {
        return stage;
    }

}
