package model;

import javax.swing.*;

public class PlayerManager {

    private Player[] playerList;
    private int[] scoreList;
    private int numOfPlayers;

    public PlayerManager(int maximumPlayers){
        playerList = new Player[maximumPlayers];
        scoreList = new int[maximumPlayers];
    }

    public void addPlayerAndScore( Player player, int score){
        int index = getNumOfPlayers();

        if( playerList.length > numOfPlayers){
            playerList[index]= player;
            scoreList[index]= score;
            numOfPlayers++;
        }
        else if(playerList.length <= numOfPlayers)
        {
            JOptionPane.showMessageDialog(null, "Too many players registered! Restart the application.");
            System.exit(0);
        }
        sortArrays();
    }

    /***
     * Sorterar för att bygga high-score listan
     */

    private void sortArrays(){
        Player player;
        int temp;

        for (int i = 0; i < numOfPlayers; i++)
        {
            for (int j = i + 1; j < numOfPlayers; j++)
            {
                if (scoreList[i]>scoreList[j])
                {
                    temp = scoreList[i];
                    scoreList[i]=scoreList[j];
                    scoreList[j] = temp;

                    player = playerList[i];
                    playerList[i] = playerList[j];
                    playerList[j]= player;
                }
            }
        }
    }

    private int getNumOfPlayers(){
        return numOfPlayers;
    }

    public String HighscoreList(){
        String text = "Gametag                "+ "\t"+ "Score" + '\n'+'\n'; //GametagScore

        for(int i = 0; i<numOfPlayers; i++){
            text += String.format(( i + 1 ) + ". " + "%s %20s" + '\n', playerList[i].toString(), scoreList[i] + "");
        }

        return text;
    }
}
