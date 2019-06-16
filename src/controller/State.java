package controller;

public class State {
    protected  Controller controller;

    public void setController(Controller controller){
        this.controller=controller;
    }

    protected void changeState(State state){
        controller.setState(state);
    }

    void error(){
        throw new RuntimeException();
    }

    void turn(){
        error();
    }

    void canPlay(){
        error();
    }

    void drawCard(){
        error();
    }

    void playEnergy(){
        error();
    }

    void playStadium(){
        error();
    }

    void useAbility(){
        error();
    }

    void useAttack(){
        error();
    }

    void endTurn(){
        error();
    }

    public boolean isDrawCard(){
        return false;
    }

    public boolean isPlayEnergy(){
        return false;
    }

    public boolean isPlayStadium(){
        return false;
    }

    public boolean isUseAttack(){
        return false;
    }

    public boolean isEndTurn(){
        return false;
    }

    public boolean isCanPlay(){
        return false;
    }

    public boolean isTurn(){
        return false;
    }

    public boolean isUseAbility(){
        return false;
    }



}
