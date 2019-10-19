package com.kodilla.tictactoe;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Square extends Rectangle {
    private static final int INITIAL_SIZE = 100;
    private int col, row;
    private TicTacToeController ticTacToeController;
    private boolean isSquareUsed;
    private String shape;

    public Square(int col, int row, Paint fill, TicTacToeController ticTacToeController, String shape) {
        super(INITIAL_SIZE, INITIAL_SIZE, fill);
        this.col = col;
        this.row = row;
        this.ticTacToeController = ticTacToeController;
        this.isSquareUsed = false;
        this.shape = shape;

        this.setOnMouseClicked(event -> ticTacToeController.handleOnMouseClicked(this));
    }

    public int getCol() {
        return col;
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

    public void setSquareUsed(boolean squareUsed) {
        isSquareUsed = squareUsed;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (isSquareUsed != square.isSquareUsed) return false;
        return shape != null ? shape.equals(square.shape) : square.shape == null;
    }

    @Override
    public int hashCode() {
        int result = col;
        result = 31 * result + row;
        result = 31 * result + ticTacToeController.hashCode();
        result = 31 * result + (isSquareUsed ? 1 : 0);
        result = 31 * result + (shape != null ? shape.hashCode() : 0);
        return result;
    }
}

