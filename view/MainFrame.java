package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    private Controller controller;
    private JPanel pnlLabels = new JPanel();

    private JLabel lblGametag;
    private JLabel lblHits;

    private JLabel lblAttempts;
    private JLabel lblGameboard;

    private JLabel txtGametag;
    private JLabel txtHits;
    private JLabel txtAttempts;
    private JLabel txtGameboard;

    private JPanel gridPnl = new JPanel();
    private JButton[][] board;
    private JButton[][] buttonArray;
    private boolean hit;

    public MainFrame(Controller controller){
        this.controller = controller;
        showUI();
        createGrid();
    }

    public void showUI(){
        setPreferredSize(new Dimension(800, 600));
        setTitle("Battleship");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameUI();
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void gameUI(){
        pnlLabels.setLayout(new GridLayout(1,5));
        pnlLabels.setBorder(BorderFactory.createTitledBorder("Scoreboard  "));

        lblGametag = new JLabel("Gametag: ");
        txtGametag = new JLabel("");

        lblGameboard = new JLabel("Gameboard: ");
        txtGameboard = new JLabel("");

        lblHits = new JLabel("Hits: ");
        txtHits = new JLabel("0");

        lblAttempts = new JLabel("Attempts: ");
        txtAttempts = new JLabel("0");

        pnlLabels.add(lblGametag);
        pnlLabels.add(txtGametag);
        pnlLabels.add(lblGameboard);
        pnlLabels.add(txtGameboard);
        pnlLabels.add(lblHits);
        pnlLabels.add(txtHits);
        pnlLabels.add(lblAttempts);
        pnlLabels.add(txtAttempts);

        add(pnlLabels, BorderLayout.NORTH);
    }

    /**
     * Skapar game board med knappar
     */
    public void createGrid(){
        gridPnl.setLayout(new GridLayout(10, 10));
        gridPnl.setSize(500, 500);
        board = new JButton[10][10];
        buttonArray = new JButton[10][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                board[i][j]= new JButton();
                JButton btn = board[i][j];
                buttonArray[i][j]= btn;

                btn.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if( (( (JButton)e.getSource() ).getText().equals("")) ) {

                            findButton(e.getSource());
                            if(isHit()){
                                btn.setText("BOOM!!");
                            }
                            else{
                                btn.setText("X");
                            }
                        }
                    }
                });
                gridPnl.add(board[i][j]);
            }
            add(gridPnl, BorderLayout.CENTER);
        }
    }

    /**
     * Ser till om sjkutit btn träffar ett skepp
     * @param btnCoord: JButton
     */
    private void findButton(Object btnCoord) {
        for (int x = 0; x < buttonArray.length; x++) {
            for (int y = 0; y < buttonArray[0].length; y++) {
                if (btnCoord.equals(buttonArray[x][y])) {
                    controller.attackedCoordinate(x, y);
                }
            }
        }
    }

    public boolean isHit(){
        return hit;
    }

    public void setHit(boolean hit){
        this.hit = hit;
    }

    public void hideUI(){
        this.dispose();
    }

    public String getGameBoard(){
        return txtGameboard.getText();
    }

    public void setGameboard(String gameboard){
        txtGameboard.setText(gameboard);
    }

    public void setGametag(String gametag){
        txtGametag.setText(gametag);
    }

    public String getGametag(){
        return txtGametag.getText();
    }

    public String getScore(){
        return txtHits.getText();
    }

    public void setScore(String score){
        txtHits.setText(score);
    }

    public void setAttempts(String attempts){
        txtAttempts.setText(attempts);
    }
    public String getAttempts(){
        return txtAttempts.getText();
    }
}
