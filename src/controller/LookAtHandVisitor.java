package controller;

import tcg.ICard;
import tcg.Trainer;

import java.util.ArrayList;

public class LookAtHandVisitor extends Visitor{
    private Trainer t;

    @Override
    public void visitTrainer(Trainer trainer){
        t=trainer;
    }

    public ArrayList<ICard> getResult() {
        return t.getHand();
    }
}
