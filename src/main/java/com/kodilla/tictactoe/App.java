package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TicTacToeController controller = new TicTacToeController();
        BoxesCreator.createDisplayBox(controller);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(50, 50, 50, 50));
        grid.setHgap(1);
        grid.setVgap(1);
        grid.setGridLinesVisible(true);

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

        border.setTop(new Text(controller.getScores().toString()));
        border.setCenter(grid);
        border.setBottom(newGameButton);

        Scene scene = new Scene(border, 500, 500);

        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void display() {
    }
}


