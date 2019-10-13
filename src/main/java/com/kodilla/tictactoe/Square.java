package com.kodilla.tictactoe;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Square extends Rectangle {
    private static final int INITIAL_SIZE = 100;
    private int col, row;
    private TicTacToeController ticTacToeController;
    private boolean IsSquareUsed;

    public Square(int col, int row, Paint fill, boolean IsSquareUsed, TicTacToeController ticTacToeController) {
        super(INITIAL_SIZE, INITIAL_SIZE, fill);
        this.col = col;
        this.row = row;
        this.ticTacToeController = ticTacToeController;
        this.IsSquareUsed = false;

        this.setOnMouseClicked(event -> ticTacToeController.handleOnMouseClicked(this));
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean getIsSquareUsed() {
        return IsSquareUsed;
    }
}

