package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TicTacToeController controller = new TicTacToeController();
        BoxesCreator boxesCreator = new BoxesCreator();
//        new BoxesCreator().createHBox1();
        new BoxesCreator().createHBox2(controller);
//        new BoxesCreator().createVBox();
        display("New Game", controller, boxesCreator);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(50, 50, 50, 50));
        grid.setHgap(1);
        grid.setVgap(1);
        grid.setGridLinesVisible(true);

//        Label popupLabel = new Label("Choose what do you wish to play with.\nNought or cross?");
//        popupLabel.setStyle(" -fx-font-size: 28; -fx-text-alignment: center; -fx-wrap-text: true");
//        Popup popup = new Popup();
//        popup.getContent().add(popupLabel);
//        popupLabel.setMinWidth(80);
//        popupLabel.setMinHeight(50);
//        popup.setAnchorX(100);
//        popup.setAnchorY(100);
//        popup.setAutoHide(true);


        for (int col = 0; col < 3; col++) {

            for (int row = 0; row < 3; row++) {

                Square square = new Square(col, row, Color.WHITE, controller, null);
                grid.add(square, col, row);
                controller.addSquare(col + "-" + row, square);
            }
        }

        primaryStage.setTitle("TicTacToe");
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);

        Button newGameButton = new Button();
        newGameButton.setText("New Game");
        newGameButton.setAlignment(Pos.CENTER);
        newGameButton.setOnAction(e -> {
            App app = new App();
            try {
                app.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        BorderPane border = new BorderPane();
        border.setTop(grid);
        border.setBottom(newGameButton);

        Scene scene = new Scene(border, 800, 500);

        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void display(String title, TicTacToeController controller, BoxesCreator boxesCreator) {
        boxesCreator.createHBox1();
        boxesCreator.createHBox2(controller);
        boxesCreator.createVBox(boxesCreator.createHBox2(controller));
    }


    /*public static void display(String title, TicTacToeController controller) {
        Stage window = new Stage();
        window.setOnCloseRequest(e -> {
            e.consume();
        });

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(500);
        window.setHeight(500);

        Label popupLabel = new Label("Choose what do you wish to play with.\nNought or cross?");
        popupLabel.setStyle(" -fx-font-size: 36; -fx-text-alignment: center; -fx-wrap-text: true;");

        HBox hBox1 = new HBox(10);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().add(popupLabel);

        Button chooseOButton = new Button();
        chooseOButton.setText("Choose O");
        chooseOButton.setAlignment(Pos.CENTER);
        HBox.setMargin(chooseOButton, new Insets(5));
        chooseOButton.setOnAction(e -> {
            controller.setUserShape(controller.getNought());
            controller.setComputerShape(controller.getCross());
            window.close();
        });

        Button chooseXButton = new Button();
        chooseXButton.setText("Choose X");
        chooseXButton.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(chooseXButton, new Insets(5));
        chooseXButton.setOnAction(e -> {
            controller.setUserShape(controller.getCross());
            controller.setComputerShape(controller.getNought());
            window.close();
        });

        HBox hBox2 = new HBox(20);
        hBox2.setAlignment(Pos.BOTTOM_CENTER);
        hBox2.getChildren().addAll(chooseOButton, chooseXButton);

        VBox layout = new VBox(100);
        layout.setPadding(new Insets(0, 0, 50, 0));
        layout.getChildren().addAll(hBox1, hBox2);
        layout.setAlignment(Pos.BOTTOM_CENTER);

        Scene scene = new Scene(layout);
        window.resizableProperty().setValue(false);
        window.setScene(scene);
        window.showAndWait();*/

        /*chooseOButton.setOnAction(e -> {
            window.close();
        });

        chooseOButton.setOnAction(e -> {
            window.close();
        });*/

    }


