package tcg;

import tcg.electric.ElectricAttack;
import tcg.fighting.FightingAttack;
import tcg.fire.FireAttack;
import tcg.grass.GrassAttack;
import tcg.psychic.PsychicAttack;
import tcg.water.WaterAttack;

import java.util.ArrayList;

/**
 * The base class for all the Pokemon. Contains getter and some setter methods for the Pokemon's properties.
 * Also contains the attack method according to the type of attack.
 * @author Catalina Rojas
 */
public abstract class AbstractPokemon implements IPokemon{
    private int id;
    private int hp;
    private ArrayList<IEnergy> energies;
    private ArrayList<IAttack> attacks;
    private IAttack selectedAttack=null;

    /**
     * Creates a new Pokemon
     * @param aId the id of the pokemon.
     * @param anHp health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks the types of attacks of the pokemon. Maximum of 4.
     */
    public AbstractPokemon(int aId, int anHp, ArrayList<IEnergy> anEnergies, ArrayList<IAttack> anAttacks){
        id=aId;
        hp=anHp;
        energies=anEnergies;
        attacks= anAttacks;

    }

    @Override
    public void attack(IPokemon aPokemon) {
        if(numberOfEnergies()>=selectedAttack.getCost()) {
            selectedAttack.attack(aPokemon);
        }
    }

    @Override
    public void selectAttack(int index) {
        selectedAttack = attacks.get(index);
    }

    @Override
    public void receiveFireAttack(FireAttack fireAttack) {
        receiveAttack(fireAttack);
    }

    /**
     * Receives attack from a card.
     * @param attack the attack.
     */
    private void receiveAttack(IAttack attack) {
        this.hp-=attack.getBaseDamage();
    }

    @Override
    public void receiveElectricAttack(ElectricAttack electricAttack) {
        receiveAttack(electricAttack);
    }

    @Override
    public void receiveFightingAttack(FightingAttack figthingAttack) {
        receiveAttack(figthingAttack);
    }

    @Override
    public void receiveGrassAttack(GrassAttack grassAttack) {
        receiveAttack(grassAttack);
    }

    @Override
    public void receivePsychicAttack(PsychicAttack psychicAttack) {
        receiveAttack(psychicAttack);
    }

    @Override
    public void receiveWaterAttack(WaterAttack waterAttack) {
        receiveAttack(waterAttack);
    }

    public void receiveResistantAttack(IAttack attack){
        this.hp-= (attack.getBaseDamage() -30);
    }

    public void receiveWeaknessAttack(IAttack attack){
        this.hp -= (attack.getBaseDamage()*2);
    }

    @Override
    public int getId(){
        return id;
    }

    @Override
    public int getHp(){
        return hp;
    }

    @Override
    public ArrayList<IEnergy> getEnergies(){
        return energies;
    }

    @Override
    public ArrayList<IAttack> getAttacks(){
        return attacks;
    }

    @Override
    public IAttack getSelectedAttack(){
        return selectedAttack;
    }

    @Override
    public boolean isDead(){
        return hp<=0;
    }

    @Override
    public int numberOfEnergies(){
        return energies.size();
    }

    @Override
    public void addAttack(IAttack attack){
        if(attacks.size()<4){
            attacks.add(attack);
        }
    }

    @Override
    public void addEnergy(IEnergy energy){
        energies.add(energy);
    }

    @Override
    public void isPlayed(Trainer trainer) {
        if(trainer.activePokemon==null){
            trainer.setActivePokemon(this);
        }
        else{
            trainer.addBenchPokemon(this);
        }
        trainer.getHand().remove(this);
    }
}
