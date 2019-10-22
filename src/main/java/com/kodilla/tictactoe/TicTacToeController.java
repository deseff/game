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
    private Image userShape;
    private Image computerShape;

    private boolean hasPlayerWon;
    private boolean hasComputerWon;

    private boolean computerMoved;
    private boolean playerMoved;
    private int computerScore;
    private int playerScore;

    private Square playersSquare;
    private Square computersSquare;

    private Scores scores = new Scores(this);

    public void handleOnMouseClicked(Square square) {
        int col = square.getCol();
        int row = square.getRow();

        System.out.println("Clicked col " + col + ", row " + row);

        Random random = new Random();
        scores.readScore();
        playerScore = scores.getPlayerSavedScore();
        computerScore = scores.getComputerSavedScore();

        playersSquare = square;

        //PLAYER MOVE
        playerMoved = false;
        if (!hasPlayerWon && !hasComputerWon) {
            if (!square.getIsSquareUsed()) {
                square.setFill(new ImagePattern(this.userShape));
                square.setSquareUsed(true);
                square.setShape(this.userShape.toString());
                playerMoved = true;
            }
            //CHECK IF PLAYER WON
            for (int c = 0; c < 3; c++) {
                if (squares.get(c + "-0").equals(square) && squares.get(c + "-1").equals(square) && squares.get(c + "-2").equals(square)) {
                    setHasPlayerWon(true);
                    playerWon();
                }
            }
            for (int r = 0; r < 3; r++) {
                if (!hasPlayerWon && squares.get("0-" + r).equals(square) && squares.get("1-" + r).equals(square) && squares.get("2-" + r).equals(square)) {
                    setHasPlayerWon(true);
                    playerWon();
                }
            }
            if (!hasPlayerWon && squares.get("0-0").equals(square) && squares.get("1-1").equals(square) && squares.get("2-2").equals(square)) {
                setHasPlayerWon(true);
                playerWon();
            }
            if (!hasPlayerWon && squares.get("2-0").equals(square) && squares.get("1-1").equals(square) && squares.get("0-2").equals(square)) {
                setHasPlayerWon(true);
                playerWon();
            }
        }

        //COMPUTER MOVE

        long freeSquares = squares.values().stream()
                .filter(s -> !s.getIsSquareUsed())
                .count();
        System.out.println("free squares " + freeSquares);

        if (!hasComputerWon && !hasPlayerWon && playerMoved && freeSquares > 0) {
            do {
                col = random.nextInt(3);
                row = random.nextInt(3);
                Square computerChoice = squares.get(col + "-" + row);
                computersSquare = computerChoice;
                System.out.println("Computer choice " + col + "-" + row);

                if (!computerChoice.getIsSquareUsed()) {
                    computerChoice.setFill(new ImagePattern(this.computerShape));
                    computerChoice.setSquareUsed(true);
                    computerChoice.setShape(this.computerShape.toString());
                    computerMoved = true;
                }

                //CHECK IF COMPUTER WON
                for (int c = 0; c < 3; c++) {
                    if (squares.get(c + "-0").equals(computerChoice) && squares.get(c + "-1").equals(computerChoice) && squares.get(c + "-2").equals(computerChoice)) {
                        setHasComputerWon(true);
                        computerWon();
                    }
                }
                for (int r = 0; r < 3; r++) {
                    if (!hasComputerWon && squares.get("0-" + r).equals(computerChoice) && squares.get("1-" + r).equals(computerChoice) && squares.get("2-" + r).equals(computerChoice)) {
                        setHasComputerWon(true);
                        computerWon();
                    }
                }
                if (!hasComputerWon && squares.get("0-0").equals(computerChoice) && squares.get("1-1").equals(computerChoice) && squares.get("2-2").equals(computerChoice)) {
                    setHasComputerWon(true);
                    computerWon();
                }
                if (!hasComputerWon && squares.get("2-0").equals(computerChoice) && squares.get("1-1").equals(computerChoice) && squares.get("0-2").equals(computerChoice)) {
                    setHasComputerWon(true);
                    computerWon();
                }
            } while (!computerMoved);
        }
        computerMoved = false;
        if (hasComputerWon || hasPlayerWon) {
            System.out.println("Player's score equals " + playerScore);
            System.out.println("Computer's score equals " + computerScore);
        } else if (!hasPlayerWon && !hasComputerWon && freeSquares == 0) {
            draw();
        }
        scores.writeFile();
    }

    private void playerWon() {
        System.out.println("You won!");
        BoxesCreator.showEndBox("You won!");
        scores.setPlayerWon();
    }

    private void computerWon() {
        System.out.println("Computer won!");
        BoxesCreator.showEndBox("Computer won!");
        scores.setComputerWon();
    }

    private void draw() {
        System.out.println("Draw");
        BoxesCreator.showEndBox("Draw");
    }

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

    public Scores getScores() {
        return scores;
    }
}




