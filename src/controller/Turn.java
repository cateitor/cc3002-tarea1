package controller;

public class Turn extends State {

    @Override
    void drawCard(){
        this.changeState(new DrawCard());
    }

    @Override
    public boolean isTurn(){
        return true;
    }

}
