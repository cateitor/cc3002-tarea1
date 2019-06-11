package controller;

import tcg.Trainer;

public class DrawCardVisitor extends Visitor{

    @Override
    public void visitTrainer(Trainer trainer){
        trainer.drawCard();
        //algo que avise que ya saco una carta y puede hacer otras acciones ?
    }
}
