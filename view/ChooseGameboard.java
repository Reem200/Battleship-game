package view;

import controller.Controller;

import javax.swing.*;

public class ChooseGameboard {

    private Controller controller;
    private JComboBox cmbGameBrd;

    public ChooseGameboard(Controller controller){
        this.controller = controller;
    }

    /**
     * @return valt game board
     */
    public Object chooseGameboardUI(){
        cmbGameBrd = new JComboBox(controller.getGameboardTypes());
        cmbGameBrd.setSelectedIndex(0);

        JOptionPane.showMessageDialog(null, cmbGameBrd, "Choose Gameboard: ", JOptionPane.QUESTION_MESSAGE);
        Object object = cmbGameBrd.getSelectedItem();

        return object;
    }
}
