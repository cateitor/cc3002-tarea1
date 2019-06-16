package controller;

public class DrawCard extends State {

    @Override
    void playEnergy(){
        this.changeState(new PlayEnergy());
    }

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
    public boolean isDrawCard(){
        return true;
    }

    @Override
    public boolean isCanPlay(){
        return true;
    }

}
