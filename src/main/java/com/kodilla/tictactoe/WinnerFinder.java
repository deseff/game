package com.kodilla.tictactoe;

public class WinnerFinder {
    private Square whoseSquare;
    private boolean isWinner;
    private int winnerScore;
    private String winnerMessage;

    TicTacToeController controller = new TicTacToeController();


    public void winnerChecker () {
        if(controller.isPlayerMoved() && !controller.isComputerMoved()) {
            whoseSquare = controller.getPlayersSquare();
            isWinner = controller.isHasPlayerWon();
            winnerScore = controller.getPlayerScore() + 1;
            winnerMessage = "You won";
        } else if (!controller.isPlayerMoved() && controller.isComputerMoved()) {
            whoseSquare = controller.getComputersSquare();
            isWinner = controller.isHasComputerWon();
            winnerScore = controller.getComputerScore();
            winnerMessage = "Computer won";
        }

        for (int c = 0; c < 3; c++) {
            if (controller.getSquares().get(c + "-0").equals(whoseSquare) && controller.getSquares().get(c + "-1").equals(whoseSquare) && controller.getSquares().get(c + "-2").equals(whoseSquare)) {
//                setHasPlayerWon(true);
                winnerScore += 1;
                System.out.println(winnerMessage);
            }
        }
        for (int r = 0; r < 3; r++) {
            if (!isWinner && controller.getSquares().get("0-" + r).equals(whoseSquare) && controller.getSquares().get("1-" + r).equals(whoseSquare) && controller.getSquares().get("2-" + r).equals(whoseSquare)) {
//                setHasPlayerWon(true);
                winnerScore += 1;
                System.out.println(winnerMessage);
            }
        }
        if (!isWinner && controller.getSquares().get("0-0").equals(whoseSquare) && controller.getSquares().get("1-1").equals(whoseSquare) && controller.getSquares().get("2-2").equals(whoseSquare)) {
//            setHasPlayerWon(true);
            winnerScore += 1;
            System.out.println(winnerMessage);
        }
        if (!isWinner && controller.getSquares().get("2-0").equals(whoseSquare) && controller.getSquares().get("1-1").equals(whoseSquare) && controller.getSquares().get("0-2").equals(whoseSquare)) {
//            setHasPlayerWon(true);
            winnerScore += 1;
            System.out.println(winnerMessage);
        }
    }
}
