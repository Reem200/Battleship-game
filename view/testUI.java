package view;

import javax.swing.*;
import java.awt.*;

public class testUI extends JPanel{

        private JLabel lblGametag;
        private JLabel lblHits;
        private JLabel lblAttempts;
        private JLabel lblGameboard;

        private JLabel txtGametag;
        private JLabel txtHits;
        private JLabel txtAttempts;
        private JLabel txtGameboard;

        public testUI(){
            showUI();
        }

        public void showUI() {
            JFrame frame = new JFrame();

            frame.setSize(800, 600);
            frame.setTitle("Battleship");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameUI();
            frame.pack();

            frame.setVisible(true);
        }

        public void gameUI(){

            JPanel pnlLabels = new JPanel();

            pnlLabels.setBorder(BorderFactory.createTitledBorder("Scoreboard  "));

            pnlLabels.setLayout(new BorderLayout());

            lblGametag = new JLabel("Gametag: ");
            txtGametag = new JLabel();

            lblHits = new JLabel("Hits: ");
            txtHits = new JLabel("0");

            lblAttempts = new JLabel("Attempts: ");
            txtAttempts = new JLabel("0");

            lblGameboard = new JLabel("Gameboard: ");
            txtGameboard = new JLabel();


            pnlLabels.add(lblGametag);
            pnlLabels.add(txtGametag);
            pnlLabels.add(lblHits);
            pnlLabels.add(txtHits);
            pnlLabels.add(lblAttempts);
            pnlLabels.add(txtAttempts);
            pnlLabels.add(lblGameboard);
            pnlLabels.add(txtGameboard);

            add(pnlLabels, BorderLayout.NORTH);

            //Bygg på spelUI med Gridlayout med knappar
            //skapa två layouts för båtar med rows och columns
            //en metod som tittar efter hit eller miss
            //om hit returneras 1, annars 0
            //skapa en separat metod med button actionlisteners
        }
}

class start{
    public static void main(String[] args){
        testUI test = new testUI();
    }
}


