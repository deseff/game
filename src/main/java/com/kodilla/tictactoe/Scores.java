package com.kodilla.tictactoe;

import java.io.*;

public class Scores {

    private int playerSavedScore;
    private int computerSavedScore;

    private int[] saveScores = {playerSavedScore, computerSavedScore};

    private ClassLoader classLoader = getClass().getClassLoader();
    private File scores = new File(classLoader.getResource("files/Scores.txt").getFile());

    public int getPlayerSavedScore() {
        return playerSavedScore;
    }

    public int getComputerSavedScore() {
        return computerSavedScore;
    }

    TicTacToeController controller = new TicTacToeController();

    public void writeFile() {
        try {
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter(scores));
            outputWriter.write(controller.getScoresToWrite());
            outputWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try {
            BufferedReader inputReader = new BufferedReader(new FileReader(scores));

            playerSavedScore = saveScores[0];
            computerSavedScore = saveScores[1];

            String fileText = inputReader.readLine();
            System.out.println(fileText);
            inputReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
