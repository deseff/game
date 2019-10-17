package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        Label popupLabel = new Label("Choose what do you wish to play with.\nNought or cross?");
        popupLabel.setStyle(" -fx-font-size: 26; -fx-text-alignment: center; -fx-wrap-text: true");
//        Popup popup = new Popup();
//        popup.getContent().add(popupLabel);
//        popupLabel.setMinWidth(80);
//        popupLabel.setMinHeight(50);
//        popup.setAnchorX(100);
//        popup.setAnchorY(100);
//        popup.setAutoHide(true);

        TicTacToeController controller = new TicTacToeController();

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

        BorderPane border = new BorderPane();
        border.setLeft(addVBox());
        border.setCenter(grid);
        border.setCenter(popupLabel);

        Scene scene = new Scene(border, 500, 500);

        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public VBox addVBox() {

        TicTacToeController controllerVB = new TicTacToeController();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Text title = new Text("Nought or cross?");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        Button chooseOButton = new Button();
        chooseOButton.setText("Choose O");
//        chooseOButton.setAlignment(Pos.CENTER);
        VBox.setMargin(chooseOButton, new Insets(5));
        chooseOButton.setOnAction(e -> {
            System.out.println("tu będzie tekst dla użytkownika: You have chosen nought");
//            vbox.border.popupLabel.setVisible(false);
//            controllerVB.setUserShape(controllerVB.nought);
        });
        vbox.getChildren().add(chooseOButton);


        Button chooseXButton = new Button();
        chooseXButton.setText("Choose X");
        chooseXButton.setAlignment(Pos.CENTER_RIGHT);
        VBox.setMargin(chooseXButton, new Insets(5));
        chooseXButton.setOnAction(e -> {
            System.out.println("tu będzie tekst dla użytkownika: You have chosen cross");
        });
        vbox.getChildren().add(chooseXButton);

        return vbox;
    }
}
