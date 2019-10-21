package com.kodilla.tictactoe;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TicTacToeController {
    private Map<String, Square> squares = new HashMap<>();
    private Image cross = new Image("files/cross1.png", 100, 100, false, false);
    private Image nought = new Image("files/nought1.png", 100, 100, false, false);
    public Image userShape;
    public Image computerShape;

    private boolean hasPlayerWon;
    private boolean hasComputerWon;

    private boolean computerMoved;
    private boolean playerMoved;
    private int computerScore;
    private int playerScore;
    private String scoresToWrite;

    public Image getCross() {
        return cross;
    }

    public Image getNought() {
        return nought;
    }

    public void setUserShape(Image userShape) {
        this.userShape = userShape;
    }

    public void setComputerShape(Image computerShape) {
        this.computerShape = computerShape;
    }

    void addSquare(String coordinates, Square square) {
        squares.put(coordinates, square);
    }

    public void setHasPlayerWon(boolean hasPlayerWon) {
        this.hasPlayerWon = hasPlayerWon;
    }

    public void setHasComputerWon(boolean hasComputerWon) {
        this.hasComputerWon = hasComputerWon;
    }

//    public int getComputerScore() {
//        return computerScore;
//    }
//
//    public int getPlayerScore() {
//        return playerScore;
//    }

    public String getScoresToWrite() {
        return scoresToWrite;
    }

    Scores scores = new Scores();


    public void handleOnMouseClicked(Square square) {
        int col = square.getCol();
        int row = square.getRow();

        System.out.println("Clicked col " + col + ", row " + row);

        Random random = new Random();
        scores.readFile();
        playerScore = scores.getPlayerSavedScore();
        computerScore = scores.getComputerSavedScore();

        //PLAYER MOVE
        playerMoved = false;
        if (!hasPlayerWon && !hasComputerWon) {
            if (!square.getIsSquareUsed()) {
                square.setFill(new ImagePattern(this.userShape));
//                square.setFill(new ImagePattern(cross));
                square.setSquareUsed(true);
                square.setShape(this.userShape.toString());
                playerMoved = true;
//                square.setShape(cross.toString());
            }
            //CHECK IF PLAYER WON
            for (int c = 0; c < 3; c++) {
                if (squares.get(c + "-0").equals(square) && squares.get(c + "-1").equals(square) && squares.get(c + "-2").equals(square)) {
                    setHasPlayerWon(true);
                    playerScore += 1;
                    System.out.println("You won!");
                }
            }
            for (int r = 0; r < 3; r++) {
                if (!hasPlayerWon && squares.get("0-" + r).equals(square) && squares.get("1-" + r).equals(square) && squares.get("2-" + r).equals(square)) {
                    setHasPlayerWon(true);
                    playerScore += 1;
                    System.out.println("You won!");
                }
            }
            if (!hasPlayerWon && squares.get("0-0").equals(square) && squares.get("1-1").equals(square) && squares.get("2-2").equals(square)) {
                setHasPlayerWon(true);
                playerScore += 1;
                System.out.println("You won!");
            }
            if (!hasPlayerWon && squares.get("2-0").equals(square) && squares.get("1-1").equals(square) && squares.get("0-2").equals(square)) {
                setHasPlayerWon(true);
                playerScore += 1;
                System.out.println("You won!");
            }
        }

        //COMPUTER MOVE

        /*Optional<Square> firstFreeSquareOpt = squares.values().stream()
                .filter(s -> !s.getIsSquareUsed())
                .findFirst();

        if (!firstFreeSquareOpt.isPresent()) {
            System.out.println("DRAW");
        }
        Square computerChoice = firstFreeSquareOpt.get();*/
        computerMoved = false;
        if (!hasComputerWon && !hasPlayerWon && playerMoved) {
            do {
                col = random.nextInt(3);
                row = random.nextInt(3);
                Square computerChoice = squares.get(col + "-" + row);
                System.out.println("Computer choice " + col + "-" + row);

                if (!computerChoice.getIsSquareUsed()) {
                    computerChoice.setFill(new ImagePattern(this.computerShape));
//            computerChoice.setFill(new ImagePattern(nought));
                    computerChoice.setSquareUsed(true);
                    computerChoice.setShape(this.computerShape.toString());
                    computerMoved = true;
//            computerChoice.setShape(nought.toString());
                }

                //CHECK IF COMPUTER WON
                for (int c = 0; c < 3; c++) {
                    if (squares.get(c + "-0").equals(computerChoice) && squares.get(c + "-1").equals(computerChoice) && squares.get(c + "-2").equals(computerChoice)) {
                        setHasComputerWon(true);
                        computerScore += 1;
                        System.out.println("Computer won!");
                    }
                }
                for (int r = 0; r < 3; r++) {
                    if (!hasComputerWon && squares.get("0-" + r).equals(computerChoice) && squares.get("1-" + r).equals(computerChoice) && squares.get("2-" + r).equals(computerChoice)) {
                        setHasComputerWon(true);
                        computerScore += 1;
                        System.out.println("Computer won!");
                    }
                }
                if (!hasComputerWon && squares.get("0-0").equals(computerChoice) && squares.get("1-1").equals(computerChoice) && squares.get("2-2").equals(computerChoice)) {
                    setHasComputerWon(true);
                    computerScore += 1;
                    System.out.println("Computer won!");
                }
                if (!hasComputerWon && squares.get("2-0").equals(computerChoice) && squares.get("1-1").equals(computerChoice) && squares.get("0-2").equals(computerChoice)) {
                    setHasComputerWon(true);
                    computerScore += 1;
                    System.out.println("Computer won!");
                }
            } while (!computerMoved);
        }
        if (hasComputerWon || hasPlayerWon) {
            System.out.println("Player's score equals " + playerScore);
            System.out.println("Computer's score equals " + computerScore);
            scoresToWrite = playerScore + "\n" + computerScore;
        }
        scores.writeFile();
    }
}




