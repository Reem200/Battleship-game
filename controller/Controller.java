package controller;

import view.MainFrame;
import view.ChooseGameboard;
import model.GameboardType;
import model.Player;
import model.PlayerManager;
import model.Gameboard;

import javax.swing.*;

public class Controller {

    private MainFrame view;
    private PlayerManager playerManager;
    private Gameboard gameboard;

    public Controller(){
        playerManager = new PlayerManager(50);
        gameboard = new Gameboard();
        startGame();
    }

    public void startGame(){
        String gametag = JOptionPane.showInputDialog(null, "Your gametag: ");
        ChooseGameboard chsGameboard = new ChooseGameboard(this);

        Object object = chsGameboard.chooseGameboardUI();
        gameboard.setGameBoardTypes((GameboardType) object);
        gameboard.placeShips();

        view = new MainFrame(this);
        view.setGametag(gametag);
        view.setGameboard(object.toString());
    }

    /***
     * Kontrollerar om ett skepp inträffar och skickar det till view
     * Ökar score och antal attempts vid skjutning
     */
    public void attackedCoordinate(int row, int column){
        gameboard.setCol(column);
        gameboard.setRow(row);

        boolean hit = gameboard.attack();
        view.setHit(hit);

        currentScoreAndAttempts(hit);
    }

    private void currentScoreAndAttempts(boolean hit){
        int score = 0;
        int attempts = 0;
        String attemptStr = view.getAttempts();
        String scoreStr = view.getScore();

        if(attemptStr != "0"){
            if(hit){
                score = Integer.parseInt(scoreStr) + 1;
            }
            else{
                score = Integer.parseInt(scoreStr);
            }
            attempts = Integer.parseInt( attemptStr) + 1;
        }
        else if(attemptStr == "0"){
            if(hit){
                score = 1;
            }
            attempts = 1;
        }

        view.setScore(score + "");
        view.setAttempts(attempts + "");

        if(score == 15){ //summa på hits av alla skepp
            view.hideUI();
            playerInfo();
        }
    }

    public void playerInfo(){
        Player player = new Player();

        String gametag = view.getGametag();
        int score = Integer.parseInt(view.getAttempts());
        player.setGametag(gametag);

        playerManager.addPlayerAndScore(player, score);

        String scoreList = playerManager.HighscoreList();
        JOptionPane.showMessageDialog(null, scoreList);
        afterGame();
    }

    private void afterGame(){
        int n = JOptionPane.showConfirmDialog(
                null,
                "Would you like to play again?",
                "Play again?",
                JOptionPane.YES_NO_OPTION);

        if(n == JOptionPane.YES_OPTION){
            startGame();
        }
        else{
            System.exit(0);
        }
    }

    public GameboardType[] getGameboardTypes(){
        return GameboardType.values();
    }

    public void setGameboardTypes(Object obj, int index){

    }
}
