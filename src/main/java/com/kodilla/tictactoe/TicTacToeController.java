package com.kodilla.tictactoe;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class TicTacToeController {
    private Map<String, Square> squares = new HashMap<>();
    private Image cross = new Image("files/cross1.png", 100, 100, false, false);
    private Image nought = new Image("files/nought1.png", 100, 100, false, false);

    void addSquare(String coordinates, Square square) {
        squares.put(coordinates, square);
    }

    Square square = new Square();

    public void handleOnMouseClicked(Square square) {
        int col = square.getCol();
        int row = square.getRow();

        System.out.println("Clicked col " + col + ", row " + row);

        Turn turn = new Turn(false, false);
        boolean turnO;
        boolean turnX;

        if (row > 0 && col > 0) {
            if (!square.getIsSquareUsed()) {
                if (turn.isTurnX()) {
                    square.add(cross);
                    square.isSquareUsed() = true;
                    turnX = true;
                } else {
                    square.add(nought);
                    square.isSquareUsed() = true;
                    turnO = true;
                }
            }


            //część dotycząca zmiany koloru kwadratów
        /*if(square.getFill().equals(Color.BLACK)) {
            square.setFill(Color.ORANGERED);
        } else {
            square.setFill(Color.BLACK);
        }*/
        }
    }

    }

