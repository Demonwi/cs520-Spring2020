package controller;

import model.RowGameModel;
import javax.swing.JButton;
import model.RowGameModel;
import view.RowGameGUI;


public interface RowGameRulesStrategy
{
    public RowGameModel getModel();

    public RowGameGUI getView();

    public void startUp();

    public void resetGame();

    public void move(JButton block);

    public void endGame();
}
