package com.kodilla.tictactoe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BoxesCreator {
    private TicTacToeController ticTacToeController;
//    private App app;
//    private Image cross = new Image("files/cross1.png", 100, 100, false, false);
//    private Image nought = new Image("files/nought1.png", 100, 100, false, false);

    TicTacToeController controller = new TicTacToeController();

//    App appToDis = new App();

    public void createHBox1() {
        Label popupLabel = new Label("Choose what do you wish to play with.\nNought or cross?");
        popupLabel.setStyle(" -fx-font-size: 36; -fx-text-alignment: center; -fx-wrap-text: true;");

        HBox hBox1 = new HBox(10);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().add(popupLabel);
    }

    public void createHBox2(TicTacToeController controller) {
        Button chooseOButton = new Button();
        chooseOButton.setText("Choose O");
        chooseOButton.setAlignment(Pos.CENTER);
        HBox.setMargin(chooseOButton, new Insets(5));
        chooseOButton.setOnAction(e -> {
            controller.setUserShape(controller.getNought());
            controller.setComputerShape(controller.getCross());


//            App.display("New Game", controller);
//            App.display("New Game", controller).getWindow.close();
//                    window.close();
        });

        Button chooseXButton = new Button();
        chooseXButton.setText("Choose X");
        chooseXButton.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(chooseXButton, new Insets(5));
        chooseXButton.setOnAction(e -> {
            controller.setUserShape(controller.getCross());
            controller.setComputerShape(controller.getNought());
//            window.close();
        });

        HBox hBox2 = new HBox(20);
        hBox2.setAlignment(Pos.BOTTOM_CENTER);
        hBox2.getChildren().addAll(chooseOButton, chooseXButton);
    }

    public void createVBox(HBox hBox1, HBox hBox2) {
        VBox layout = new VBox(100);
        layout.setPadding(new Insets(0, 0, 50, 0));
        layout.getChildren().addAll(hBox1, hBox2);
        layout.setAlignment(Pos.BOTTOM_CENTER);
    }
}


