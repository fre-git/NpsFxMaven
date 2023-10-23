package com.fre.npsfxmaven.view;

import com.fre.npsfxmaven.util.GridBuilder;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

public class SwitchNpsView {
    Stage stageSwitchNps;
    GridPane grid;
    Scene scene;
    Button btn;
    TextField firstNpsTextField;
    TextField secondNpsTextField;

    public SwitchNpsView() {
        stageSwitchNps = new Stage();
        stageSwitchNps.setTitle("Switch NPS priority");
        grid = GridBuilder.initiateGrid();
        scene = new Scene(grid);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm());
        stageSwitchNps.setScene(scene);
        stageSwitchNps.setWidth(420);
        stageSwitchNps.setHeight(250);

        Label firstNps = new Label("processingorder 1st Nps");
        grid.add(firstNps, 0, 1);
        firstNpsTextField = new TextField();
        grid.add(firstNpsTextField, 1, 1);

        Label secondNps = new Label("processingorder 2nd Nps");
        grid.add(secondNps, 0, 2);
        secondNpsTextField = new TextField();
        grid.add(secondNpsTextField, 1, 2);

        btn = new Button("Switch priority");
        grid.add(btn, 1, 10);
        stageSwitchNps.show();
    }

    public Button getBtn() {
        return btn;
    }

    public TextField getFirstNpsTextField() {
        return firstNpsTextField;
    }

    public TextField getSecondNpsTextField() {
        return secondNpsTextField;
    }

    public Stage getStageSwitchNps() {
        return stageSwitchNps;
    }
}
