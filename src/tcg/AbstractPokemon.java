package tcg;

import tcg.electric.ElectricAttack;
import tcg.electric.ElectricEnergy;
import tcg.fighting.FightingAttack;
import tcg.fighting.FightingEnergy;
import tcg.fire.FireAttack;
import tcg.fire.FireEnergy;
import tcg.grass.GrassAttack;
import tcg.grass.GrassEnergy;
import tcg.psychic.PsychicAttack;
import tcg.psychic.PsychicEnergy;
import tcg.trainer.Trainer;
import tcg.water.WaterAttack;
import tcg.water.WaterEnergy;

import java.util.ArrayList;

/**
 * The base class for all the Pokemon. Contains getter and some setter methods for the Pokemon's properties.
 * Also contains the attack method according to the type of attack.
 * @author Catalina Rojas
 */
public abstract class AbstractPokemon extends AbstractCard implements IPokemon{
    private int id;
    private int hp;
    private int damage;
    private EnergyCounter energyCounter;
    private ArrayList<IAbility> attacks;
    private IAbility selectedAttack;
    private int preId;

    /**
     * Creates a new Pokemon
     * @param aId the id of the pokemon.
     * @param anHp health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks the types of attacks of the pokemon. Maximum of 4.
     */
    public AbstractPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks){
        id=aId;
        hp=anHp;
        energyCounter=anEnergies;
        int i = 0;
        if(anAttacks.size()<5){
            attacks = anAttacks;
        }
        else {
            while(attacks.size()<5){
                attacks.add(anAttacks.get(i));
                i++;
            }
        }
    }

    @Override
    public void attack(IPokemon aPokemon) {
        if(energyCounter.greaterThan(this.selectedAttack.getCost())){
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
    private void receiveAttack(IAbility attack) {
        damage+=attack.getBaseDamage();
        if(hp<damage){
            damage=hp;
        }
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

    public void receiveResistantAttack(IAbility attack){
        this.damage+= (attack.getBaseDamage() -30);
    }

    public void receiveWeaknessAttack(IAbility attack){
        this.damage += (attack.getBaseDamage()*2);
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
    public int getCurrentHp(){
        return hp-damage;
    }

    @Override
    public void setDamage(int current){
        damage = current > hp ? hp : current<0 ? 0 : current;
    }

    @Override
    public int getDamage(){
        return damage;
    }

    @Override
    public EnergyCounter getEnergies(){
        return energyCounter;
    }

    @Override
    public ArrayList<IAbility> getAttacks(){
        return attacks;
    }

    @Override
    public IAbility getSelectedAttack(){
        return selectedAttack;
    }

    @Override
    public boolean isDead(){
        if(hp<=damage){
            return true;
        }
        return false;
    }


    @Override
    public void addAttack(IAbility attack){
        if(attacks.size()<4){
            attacks.add(attack);
        }
    }

    @Override
    public void play() {
        PokemonVisitor visitor = new PokemonVisitor();
        this.accept(visitor);
    }

    @Override
    public void useAbility(Trainer adversary){
        //if i think?
        attack(adversary.getActivePokemon());
    }

    @Override
    public void addElectricEnergy(ElectricEnergy energy){
        energyCounter.setElectricEnergy(energyCounter.getElectricEnergy()+1);
    }

    @Override
    public  void addFightingEnergy(FightingEnergy energy){
        energyCounter.setFightingEnergy(energyCounter.getElectricEnergy()+1);
    }

    @Override
    public void addFireEnergy(FireEnergy energy){
        energyCounter.setFireEnergy((energyCounter.getFireEnergy())+1);
    }

    @Override
    public void addGrassEnergy(GrassEnergy energy){
        energyCounter.setGrassEnergy(energyCounter.getGrassEnergy()+1);
    }

    @Override
    public void addPsychicEnergy(PsychicEnergy energy){
        energyCounter.setPsychicEnergy(energyCounter.getPsychicEnergy()+1);
    }

    @Override
    public void addWaterEnergy(WaterEnergy energy){
        energyCounter.setWaterEnergy(energyCounter.getWaterEnergy()+1);
    }

    /**
     * Sets the Pokemon's pre evolution id.
     * @param id the id corresponding to the basic pokemon that is the pre evolution
     */
    public void setPreId(int id){
        preId=id;
    }

    /**
     * Ges the Pokemon's pre evolution id
     * @return pre evolution id
     */
    public int getPreId(){
        return preId;
    }


    /**
     * Sets the EnergyCounter for the Pokemon
     * @param energyCounter the energyCounter.
     */
    public void setEnergyCounter(EnergyCounter energyCounter){
        this.energyCounter = energyCounter;
    }

}
