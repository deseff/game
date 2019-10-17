package com.kodilla.tictactoe;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.util.HashMap;
import java.util.Map;

public class TicTacToeController {
    private Map<String, Square> squares = new HashMap<>();
    private Image cross = new Image("files/cross1.png", 100, 100, false, false);
    private Image nought = new Image("files/nought1.png", 100, 100, false, false);
    private Image userShape;
    private Image computerShape;

    public void setUserShape(Image userShape) {
        this.userShape = userShape;
    }

    public void setComputerShape(Image computerShape) {
        this.computerShape = computerShape;
    }

    void addSquare(String coordinates, Square square) {
        squares.put(coordinates, square);
    }

    public void handleOnMouseClicked(Square square) {
        int col = square.getCol();
        int row = square.getRow();

        System.out.println("Clicked col " + col + ", row " + row);

        //PLAYER MOVE
        if (!square.getIsSquareUsed()) {
            square.setFill(new ImagePattern(cross)); //userShape
            square.setSquareUsed(true);
            square.setShape("cross"); //userShape.toString()
        }
        //CHECK IF PLAYER WON
        for (int c = 0; c < 3; c++) {
            if (squares.get(c + "-0").equals(square) && squares.get(c + "-1").equals(square) && squares.get(c + "-2").equals(square)) {
                System.out.println("You won!");
            }
        }
    }
}



