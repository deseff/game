package com.kodilla.tictactoe;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class TicTacToeController {
    private Map<String, Square> squares = new HashMap<>();
    private Image cross = new Image("files/cross1.png", 100, 100, false, false);
    private Image nought = new Image("files/nought1.png", 100, 100, false, false);

    void addSquare(String coordinates, Square square) {
        squares.put(coordinates, square);
    }

    public void handleOnMouseClicked(Square square) {
        int col = square.getCol();
        int row = square.getRow();

        System.out.println("Clicked col " + col + ", row " + row);

        /**
         * PLAYER MOVE
         */

        //check if square is free. Otherwise ask to choose other square
        square.setFill(new ImagePattern(cross));
        square.setSquareUsed(true);
        //CHECK IF PLAYER WON

        /**
         * COMPUTER MOVE
         */
        //draw a computer move
        Optional<Square> firstFreeSquareOpt = squares.values().stream()
                .filter(s -> !s.getIsSquareUsed())
                .findFirst();

        if (!firstFreeSquareOpt.isPresent()) {
            System.out.println("DRAW");
        }
        Square computerChoise = firstFreeSquareOpt.get();

        //take a square
        computerChoise.setFill(new ImagePattern(nought));
        computerChoise.setSquareUsed(true);
        //check if computer won

//        if (row > 0 && col > 0) {
//            if (!square.getIsSquareUsed()) {
//                if (turn.isTurnX()) {
////                    square.add(cross);
//                    square.setSquareUsed(true);
//                    turnX = true;
//                } else {
////                    square.add(nought);
//                    square.setSquareUsed(true);
//                    ;
//                    turnO = true;
//                }
//            }
//
        //część dotycząca zmiany koloru kwadratów
        /*if(square.getFill().equals(Color.BLACK)) {
            square.setFill(Color.ORANGERED);
        } else {
            square.setFill(Color.BLACK);
        }*/
    }
}

