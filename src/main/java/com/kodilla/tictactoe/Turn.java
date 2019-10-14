package com.kodilla.tictactoe;

public class Turn {
    private boolean turnO = false;
    private boolean turnX = false;

    public Turn(boolean turnO, boolean turnX) {
        this.turnX = turnX;
        this.turnO = turnO;
    }

    public boolean isTurnO() {
        return turnO;
    }

    public boolean isTurnX() {
        return turnX;
    }

    //    public void isTurnX {
//        if()
//    }
}


