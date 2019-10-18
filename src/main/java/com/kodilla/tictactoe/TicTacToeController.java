package com.kodilla.tictactoe;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicTacToeController {
    private Map<String, Square> squares = new HashMap<>();
    private Image cross = new Image("files/cross1.png", 100, 100, false, false);
    private Image nought = new Image("files/nought1.png", 100, 100, false, false);
    public Image userShape;
    public Image computerShape;

    private boolean hasUserWon;
    private boolean hasComputerWon;

    public void setUserShape(Image userShape) {
        this.userShape = userShape;
    }

    public void setComputerShape(Image computerShape) {
        this.computerShape = computerShape;
    }

    void addSquare(String coordinates, Square square) {
        squares.put(coordinates, square);
    }

    public void setHasUserWon(boolean hasUserWon) {
        this.hasUserWon = hasUserWon;
    }

    public void setHasComputerWon(boolean hasComputerWon) {
        this.hasComputerWon = hasComputerWon;
    }

    public void handleOnMouseClicked(Square square) {
        int col = square.getCol();
        int row = square.getRow();

        System.out.println("Clicked col " + col + ", row " + row);

        //PLAYER MOVE
        if (!hasUserWon && !hasComputerWon) {
            if (!square.getIsSquareUsed()) {
                square.setFill(new ImagePattern(this.userShape));
//                square.setFill(new ImagePattern(cross));
                square.setSquareUsed(true);
                square.setShape(this.userShape.toString());
//                square.setShape(cross.toString());
            }
            //CHECK IF PLAYER WON
            for (int c = 0; c < 3; c++) {
                if (squares.get(c + "-0").equals(square) && squares.get(c + "-1").equals(square) && squares.get(c + "-2").equals(square)) {
                    setHasUserWon(true);
                    System.out.println("You won!");
                    Label win = new Label("You win");
//                coś żeby gra się zatrzymywała, komunikat, że gracz wygrał
                }
            }
            for (int r = 0; r < 3; r++) {
                if (squares.get("0-" + r).equals(square) && squares.get("1-" + r).equals(square) && squares.get("2-" + r).equals(square)) {
                    setHasUserWon(true);
                    System.out.println("You won!");
//                coś żeby gra się zatrzymywała, komunikat, że gracz wygrał
                }
            }
            if (squares.get("0-0").equals(square) && squares.get("1-1").equals(square) && squares.get("2-2").equals(square)) {
                setHasUserWon(true);
                System.out.println("You won!");
//                coś żeby gra się zatrzymywała, komunikat, że gracz wygrał
            }
            if (squares.get("2-0").equals(square) && squares.get("1-1").equals(square) && squares.get("0-2").equals(square)) {
                setHasUserWon(true);
                System.out.println("You won!");
//                coś żeby gra się zatrzymywała, komunikat, że gracz wygrał
            }
        }

        //COMPUTER MOVE

        Optional<Square> firstFreeSquareOpt = squares.values().stream()
                .filter(s -> !s.getIsSquareUsed())
                .findFirst();

        if (!firstFreeSquareOpt.isPresent()) {
            System.out.println("DRAW");
        }
        Square computerChoice = firstFreeSquareOpt.get();

        if(!hasComputerWon && !hasUserWon) {
//            if (!square.getIsSquareUsed()) {
                computerChoice.setFill(new ImagePattern(this.computerShape));
//            computerChoice.setFill(new ImagePattern(nought));
                computerChoice.setSquareUsed(true);
                computerChoice.setShape(this.computerShape.toString());
//            computerChoice.setShape(nought.toString());
        //CHECK IF COMPUTER WON
            for (int c = 0; c < 3; c++) {
                if (squares.get(c + "-0").equals(computerChoice) && squares.get(c + "-1").equals(computerChoice) && squares.get(c + "-2").equals(computerChoice)) {
                    setHasComputerWon(true);
                    System.out.println("Computer won!");
//                coś żeby gra się zatrzymywała, komunikat, że komputer wygrał
                }
            }
            for (int r = 0; r < 3; r++) {
                if (squares.get("0-" + r).equals(computerChoice) && squares.get("1-" + r).equals(computerChoice) && squares.get("2-" + r).equals(computerChoice)) {
                    setHasComputerWon(true);
                    System.out.println("Computer won!");
//                coś żeby gra się zatrzymywała, komunikat, że komputer wygrał
                }
            }
            if (squares.get("0-0").equals(computerChoice) && squares.get("1-1").equals(computerChoice) && squares.get("2-2").equals(computerChoice)) {
                setHasComputerWon(true);
                System.out.println("Computer won!");
//                coś żeby gra się zatrzymywała, komunikat, że kopmuter wygrał
            }
            if (squares.get("2-0").equals(computerChoice) && squares.get("1-1").equals(computerChoice) && squares.get("0-2").equals(computerChoice)) {
                setHasComputerWon(true);
                System.out.println("Computer won!");
//                coś żeby gra się zatrzymywała, komunikat, że komputer wygrał
            }
        }
    }
}



