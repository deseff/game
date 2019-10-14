package com.kodilla.tictactoe;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Square extends Rectangle {
    private static final int INITIAL_SIZE = 100;
    private int col, row;
    private TicTacToeController ticTacToeController;
    private boolean isSquareUsed;

    public Square(int col, int row, Paint fill, TicTacToeController ticTacToeController) {
        super(INITIAL_SIZE, INITIAL_SIZE, fill);
        this.col = col;
        this.row = row;
        this.ticTacToeController = ticTacToeController;
        this.isSquareUsed = false;

        this.setOnMouseClicked(event -> ticTacToeController.handleOnMouseClicked(this));
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean getIsSquareUsed() {
        return isSquareUsed;
    }

    public void setTicTacToeController(TicTacToeController ticTacToeController) {
        this.ticTacToeController = ticTacToeController;
    }

    public void setSquareUsed(boolean squareUsed) {
        isSquareUsed = squareUsed;
    }
}

