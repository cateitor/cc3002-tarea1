package tcg;

import tcg.electric.*;
import tcg.fighting.*;
import tcg.fire.*;
import tcg.grass.*;
import tcg.psychic.*;
import tcg.trainerCard.objectCard.PotionCard;
import tcg.trainerCard.stadiumCard.LuckyStadium;
import tcg.trainerCard.supportCard.ProfessorCozmosDiscoveryCard;
import tcg.trainerCard.supportCard.ProfessorJuniperCard;
import tcg.water.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Class to create a Deck, used in Test classes.
 */
public class DeckForTest {
    private ArrayList<ICard> deck;

    /**
     * The constructor of the deck.
     */
    public DeckForTest(){
        deck = new ArrayList<ICard>();
        ElectricAttack electricAttack = new ElectricAttack("Thunder",20,1,"The pokémon could be paralized!");
        Heal heal = new Heal("Heal",30,0,"Heals your damage");
        ElectricShock electricShock = new ElectricShock("ElectricShock",30,2,"SHOOK");
        FightingAttack fightingAttack = new FightingAttack("Punch", 30, 1, "It hurts!");
        FireAttack fireAttack = new FireAttack("Ember", 30, 1, "Discard a Fire Energy attached to Pokemon");
        GrassAttack grassAttack = new GrassAttack("Sharp Leaf", 30, 2, "It cuts the pokemon");
        PsychicAttack psychicAttack = new PsychicAttack("Zen Force", 30, 2, "Ohmm");
        WaterAttack waterAttack = new WaterAttack("Rain Blow", 30, 1, "It's raining!");

        BasicFirePokemon charmander = new BasicFirePokemon(4,70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fireAttack)));
        PhaseOneFirePokemon charmeleon = new PhaseOneFirePokemon(5,90,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(fireAttack)));
        charmeleon.setPreId(4);
        PhaseTwoFirePokemon charizard = new PhaseTwoFirePokemon(6,180, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fireAttack)));
        charizard.setPreId(5);

        BasicGrassPokemon bulbasaur = new BasicGrassPokemon(1, 70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(grassAttack)));
        PhaseOneGrassPokemon ivysaur = new PhaseOneGrassPokemon(2,90,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(grassAttack,heal)));
        ivysaur.setPreId(1);
        PhaseTwoGrassPokemon venusaur = new PhaseTwoGrassPokemon(3,150,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(grassAttack,heal)));
        venusaur.setPreId(2);

        BasicWaterPokemon squirtle = new BasicWaterPokemon(7, 70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(waterAttack)));
        PhaseOneWaterPokemon wartortle = new PhaseOneWaterPokemon(8, 90, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(waterAttack)));
        wartortle.setPreId(7);
        PhaseTwoWaterPokemon blastoise = new PhaseTwoWaterPokemon(9,150, new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(waterAttack)));
        blastoise.setPreId(8);

        BasicElectricPokemon mareep = new BasicElectricPokemon(179,70,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(electricAttack)));
        PhaseOneElectricPokemon flaaffy = new PhaseOneElectricPokemon(180, 90,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(electricAttack,electricShock)));
        flaaffy.setPreId(179);
        PhaseTwoElectricPokemon ampharos = new PhaseTwoElectricPokemon(181, 140, new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(electricAttack,electricShock)));
        ampharos.setPreId(180);

        BasicPsychicPokemon abra = new BasicPsychicPokemon(63,70,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(psychicAttack)));
        PhaseOnePsychicPokemon kadabra = new PhaseOnePsychicPokemon(64, 90, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(psychicAttack)));
        kadabra.setPreId(63);
        PhaseTwoPsychicPokemon alakazam = new PhaseTwoPsychicPokemon(65, 150, new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(psychicAttack)));
        alakazam.setPreId(64);

        BasicFightingPokemon machop = new BasicFightingPokemon(66,70,new EnergyCounter() ,new ArrayList<IAbility>(Arrays.asList(fightingAttack)));
        PhaseOneFightingPokemon machoke = new PhaseOneFightingPokemon(67,90, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fightingAttack)));
        machoke.setPreId(66);
        PhaseTwoFightingPokemon machamp = new PhaseTwoFightingPokemon(68,150,new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fightingAttack)));
        machamp.setPreId(67);

        PotionCard potionCard = new PotionCard("PotionCard","heals the pokemon");
        potionCard.setHeal(20);
        LuckyStadium luckyStadium = new LuckyStadium("Lucky Stadium", "throw a coin, if it's head, draw a card from deck");
        ProfessorCozmosDiscoveryCard professorCozmosDiscoveryCard = new ProfessorCozmosDiscoveryCard("Professor Cozmo's Discovery", "Throw a coin, if it's head draw the last 3 cards form the deck, if it's tails draw the 2 first.");
        ProfessorJuniperCard professorJuniperCard = new ProfessorJuniperCard("Professor Juniper", "discard your hand and draw 7 cards from the deck");

        for(int i=0;i<3;i++){
            deck.add(new FireEnergy());
            deck.add(new FireEnergy());
            deck.add(new WaterEnergy());
            deck.add(new ElectricEnergy());
            deck.add(new FightingEnergy());
            deck.add(new GrassEnergy());
            deck.add(new PsychicEnergy());
            deck.add(potionCard);
            deck.add(luckyStadium);
            deck.add(professorCozmosDiscoveryCard);
            deck.add(professorJuniperCard);

        }

        deck.addAll(Arrays.asList(charmander,charmeleon,charizard,bulbasaur,ivysaur,venusaur,squirtle,wartortle,blastoise,mareep,flaaffy,ampharos,abra,kadabra,alakazam,machop,machoke,machamp));
        deck.addAll(Arrays.asList(charmander,bulbasaur,squirtle,charmeleon,charizard,ivysaur,venusaur,wartortle,blastoise));

        Collections.shuffle(deck);

    }


    public ArrayList<ICard> getDeck(){
        return deck;
     }

}
