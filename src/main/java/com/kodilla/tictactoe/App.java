package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application { //implements EventHandler<ActionEvent>

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.setHgap(1);
        grid.setVgap(1);
        grid.setGridLinesVisible(true);
        TicTacToeController controller = new TicTacToeController();

        for (int col = 0; col < 4; col++) {

            for (int row = 0; row < 4; row++) {

                if (col == 0 || row == 0) {
                    Square square = new Square(col, row, Color.LIGHTGRAY, controller);
                    grid.add(square, col, row);
                    controller.addSquare(col + "-" + row, square);
                } else {
                    Square square = new Square(col, row, Color.WHITE, controller);
                    grid.add(square, col, row);
                    controller.addSquare(col + "-" + row, square);
                }
            }
        }

        primaryStage.setTitle("TicTacToe");
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);

        Button chooseOButton = new Button();
        chooseOButton.setText("Choose O");
        chooseOButton.setAlignment(Pos.CENTER);
        chooseOButton.setOnAction(e -> {
            System.out.println("tu będzie tekst dla użytkownika: You have chosen nought");
//            isTurnO = true;
        });

        Button chooseXButton = new Button();
        chooseXButton.setText("Choose X");
        chooseXButton.setAlignment(Pos.CENTER);
        chooseXButton.setOnAction(e -> {
            System.out.println("tu będzie tekst dla użytkownika: You have chosen cross");
//            isTurnX = true
        });

        grid.add(chooseOButton, 0, 0);
        grid.add(chooseXButton, 1, 0);

        /*Label chooseX = new Label("Choose X");
        GridPane.setConstraints(chooseX, 0,0);
        chooseX.alignmentProperty().
        grid.getChildren().addAll(chooseX);*/

        BorderPane border = new BorderPane();
        border.setLeft(addVBox());
        border.setCenter(grid);

        Scene scene = new Scene(border, 500, 500);

        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public VBox addVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Text title = new Text("Data");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        for (int i = 0; i < 4; i++) {

            Button btn = new Button("Super button");
            btn.setOnMouseClicked(event -> System.out.println("Clicked !"));
            VBox.setMargin(btn, new Insets(0, 0, 0, 8));
            vbox.getChildren().add(btn);
        }

        return vbox;
    }
}
