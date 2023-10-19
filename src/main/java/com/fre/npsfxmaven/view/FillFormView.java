package com.fre.npsfxmaven.view;

import com.fre.npsfxmaven.Nps;
import com.fre.npsfxmaven.Storable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Objects;

public class FillFormView {
    /*
    Stage stage;
    Button btn;
    TextField nameTextField;
    TextField processingOrderTextField;
    TextField stateTextField;
    TextField policyTextField;
    TextField conditionTextField;
    TextField conditionDataTextField;
    TextField profileIdTextField;
    TextField profileDataTextField;
    Storable nps1;
    GridPane grid;


    public FillFormView() {
        stage = new Stage();
        stage.setTitle("Fill in NP properties");

        grid = initiateGrid();
        Scene scene = new Scene(grid);
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


        stage.show();

        //buttonClicked();




    }

    public Storable buttonClicked() {
        Button btn = new Button("Add new NPS");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 10);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String processingOrder = processingOrderTextField.getText();
                nps1 = new Nps(nameTextField.getText(),
                        Integer.valueOf(processingOrder),
                        processingOrderTextField.getText(),
                        Integer.valueOf(policyTextField.getText()),
                        conditionTextField.getText(),
                        conditionDataTextField.getText(),
                        profileIdTextField.getText(),
                        profileDataTextField.getText());
                System.out.println("form  " + nps1);

               // stage.close();

                /*
                npsStorage.addNps(nps);
                System.out.println(npsStorage);
                tblData.setItems(getNpsObservableList());
                stage1.close();

            }
        });
        return nps1;
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

                 */


    /*
    Stage stage;
    Scene scene;
    Button btn;
    private TextField nameTextField;
    private TextField processingOrderTextField;
    private TextField stateTextField;
    private TextField policyTextField;
    private TextField conditionTextField;
    private TextField conditionDataTextField;
    private TextField profileIdTextField;
    private TextField profileDataTextField;

    DataSingleton data = DataSingleton.getInstance();
    NpsController npsController;

    public FillFormView() {
        initialize();
    }

    public void initialize(){
        this.stage = new Stage();
        stage.setTitle("Fill in NP properties");

        GridPane grid = getGridForm();

        scene = new Scene(grid);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(500);

        btn = new Button("Add new NPS");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 10);
        stage.show();

         //clickAddNpsButton();
    }

    private GridPane getGridForm() {
        GridPane grid = new GridPane();
        grid.setId("gridId");
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
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

        return grid;
    }

    public void clickAddNpsButton(){

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
                        profileDataTextField.getText()
                );

                data.setNps(nps);


                //System.out.println(nps);
                stage.close();
            }
        });



    }

     */

}
