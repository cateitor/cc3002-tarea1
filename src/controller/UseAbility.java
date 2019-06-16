package controller;

public class UseAbility extends State {

    @Override
    void endTurn(){
        this.changeState(new EndTurn());
    }

    @Override
    public boolean isUseAbility(){
        return true;
    }
}
