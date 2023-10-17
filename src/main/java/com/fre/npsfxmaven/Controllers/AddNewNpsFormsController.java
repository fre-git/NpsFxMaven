package com.fre.npsfxmaven.Controllers;

import com.fre.npsfxmaven.Nps;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class AddNewNpsFormsController {
    /*
    Stage stage;
    Scene scene;


    @FXML
    private Label conditionData;

    @FXML
    private TextField conditionId;

    @FXML
    private TextField nameId;

    @FXML
    private TextField orderId;

    @FXML
    private TextField policyId;

    @FXML
    private TextField profileData;

    @FXML
    private TextField profileId;

    @FXML
    private TextField stateId;



    public AddNewNpsFormsController() throws IOException {

        this.stage = new Stage();
        stage.setTitle("Fill in NP properties");

        GridPane grid = new GridPane();
        grid.setId("gridId");
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        scene = new Scene(grid);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm());

        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(500);
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

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                String processingOrder = processingOrderTextField.getText();
                Nps nps = new Nps(nameTextField.getText(),
                        Integer.valueOf(processingOrder),
                        processingOrderTextField.getText(),
                        Integer.valueOf(policyTextField.getText()),
                        conditionTextField.getText(),
                        conditionDataTextField.getText(),
                        profileIdTextField.getText(),
                        profileDataTextField.getText());

               // System.out.println(nps);

                // FXMLLoader loader = new FXMLLoader(getClass().getResource())
                stage.close();
            }
        });

    }

s
     */
}
