package controller;

public class PlayStadium extends State {

    @Override
    void playEnergy(){
        this.changeState(new PlayEnergy());
    }

    @Override
    void useAbility(){
        this.changeState(new UseAbility());
    }

    void endTurn(){
        this.changeState(new EndTurn());
    }

    @Override
    public boolean isPlayStadium(){
        return true;
    }

}
