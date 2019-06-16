package controller;

public class PlayEnergy extends State {

    @Override
    void playStadium(){
        this.changeState(new PlayStadium());
    }

    @Override
    void useAbility(){
        this.changeState(new UseAbility());
    }

    @Override
    void endTurn(){
        this.changeState(new EndTurn());
    }

    @Override
    public boolean isPlayEnergy(){
        return true;
    }
}
