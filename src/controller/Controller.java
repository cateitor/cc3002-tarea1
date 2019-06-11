package controller;

import tcg.ICard;
import tcg.Trainer;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Game logic Controller class.
 * @author Catalina Rojas
 */
public class Controller  {
    Controller c;
    private Trainer trainer1;
    private Trainer trainer2;
    private Trainer currentTrainer;
    private boolean drawCard;
    private int turn=0;

    public Controller(){
        trainer1 = new Trainer();
        trainer1 = new Trainer();
        currentTrainer= trainer1;
        drawCard = false;
    }

    public Trainer currentTrainer(){
        return currentTrainer;
    }


    //robar carta del mazo
    public void drawCard(){
        DrawCardVisitor v = new DrawCardVisitor();
        c.currentTrainer.accept(v);
        drawCard = true;
    }

    //ver cartas de la mano
    public ArrayList<ICard> lookAtHand(){
        LookAtHandVisitor v = new LookAtHandVisitor();
        if(drawCard){
            c.currentTrainer.accept(v);
        }
        return v.getResult();
    }

    //jugar carta de la mano

    //ver todos los pokemon en juego (el de el y los de su oponente)

    //utilizar habilidad del pokemon activo
        //aqui terminaria el turno del entrenador activo y se cambiaria de jugador

    //elegir pokemon de la banca

    //cambiar estado del juego
        //no se si esto se puede hacer de otra manera ?


}
