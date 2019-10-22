package com.kodilla.tictactoe;

import java.io.*;

public class Scores {

    private int playerSavedScore;
    private int computerSavedScore;
    private TicTacToeController ticTacToeController;

    private ClassLoader classLoader = getClass().getClassLoader();
    private File scores = new File(classLoader.getResource("files/Scores.txt").getFile());

    public Scores(TicTacToeController ticTacToeController) {
        this.ticTacToeController = ticTacToeController;

        readScore();
    }

    public void setPlayerWon(){
        playerSavedScore++;
        writeFile();
    }

    public void setComputerWon(){
        computerSavedScore++;
        writeFile();
    }

    public void writeFile(){
        writeFile(playerSavedScore+"-"+computerSavedScore);
    }

    public void writeFile(String value) {
        try {
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter(scores));
            outputWriter.write(value);
            outputWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readScore() {
        String fileText = "0-0";
        try {
            BufferedReader inputReader = new BufferedReader(new FileReader(scores));

            fileText = inputReader.readLine();
            System.out.println(fileText);
            inputReader.close();
        } catch (Exception e) {
            //create new file with 0-0 score
            writeFile("0-0");
        }

        String parts[] = fileText.split("-");
        String playerScoreString = parts[0];
        String computerScoreString = parts[1];

        this.playerSavedScore = Integer.valueOf(playerScoreString);
        this.computerSavedScore = Integer.valueOf(computerScoreString);
    }

    public int getPlayerSavedScore() {
        return playerSavedScore;
    }

    public int getComputerSavedScore() {
        return computerSavedScore;
    }

    @Override
    public String toString() {
        return "Scores: " +
                "Player " + playerSavedScore + "-" +
                computerSavedScore + " Computer";
    }
}