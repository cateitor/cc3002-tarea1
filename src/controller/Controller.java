package controller;

import tcg.Trainer;

import java.util.Observable;
import java.util.Observer;

/**
 * Game logic Controller class.
 * @author Catalina Rojas
 */
public class Controller implements Observer {
    private Trainer trainer1;
    private Trainer trainer2;
    private int turn=0;

    //robar carta del mazo
    public void drawCard(){

    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
