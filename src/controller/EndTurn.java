package controller;

public class EndTurn extends State {

    @Override
    public void turn(){
        controller.changeCurrentTrainer();
        this.changeState(new Turn());
    }

    @Override
    public boolean isEndTurn(){
        return true;
    }
}
