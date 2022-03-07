import java.util.ArrayList;
import java.util.Random;

public class MiddleEarth {

    // number of spaces in a tab - change to match environment
    public static final int TAB_LENGTH = 8;
    // number of games to run in a simulation
    public static final int NUM_GAMES = (int)Math.pow(10, 6);
    // whether to print messages are run a simulation of many games silently
    public static final boolean VERBOSE = false;

    public static void main(String[] args) throws Exception {
        ArrayList<Combatant> characters = new ArrayList<Combatant>();
        characters.add(new Elf("Legolas"));
        characters.add(new Dwarf("Bofur"));
        characters.add(new Man("Strider"));
        characters.add(new GondorMan("Faramir"));
        characters.add(new RohanMan("Éomer"));

        for (int i=0; i<NUM_GAMES; i++) {
            simBattle(characters, VERBOSE);
        }
        System.out.println();
        double percentage;
        for (Combatant c : characters) {
            percentage = Math.round((c.getNumWins() / (double)NUM_GAMES) * 10000) / 100.0;
            System.out.println(c.getName() + ": " + c.getNumWins() + " wins (" + percentage + "%)");
        }
    }

    public static ArrayList<Combatant> getLivingCombatants(ArrayList<Combatant> combatants) {
        ArrayList<Combatant> ret = new ArrayList<Combatant>();
        for (Combatant c : combatants) {
            if (c.getHealth() > 0) {
                ret.add(c);
            }
        }
        return ret;
    }

    public static Combatant getRandomCombatant(ArrayList<Combatant> combatants) {
        Random random = new Random();
        // only select living combatants
        ArrayList<Combatant> livingCombatants = getLivingCombatants(combatants);
        return livingCombatants.get(random.nextInt(livingCombatants.size()));
    }

    public static Combatant getDefender(ArrayList<Combatant> combatants, Combatant attacker) throws Exception {
        // store a list of valid defenders - equal to the list of alive combatants,
        // excluding the attacker
        ArrayList<Combatant> validDefenders = new ArrayList<Combatant>();
        for (Combatant c : combatants) {
            if ((c.getHealth() > 0) && (!c.equals(attacker))) {
                validDefenders.add(c);
            }
        }
        if (validDefenders.size() < 1) {
            throw new Exception("not enough valid combatants remaining");
        }

        Random random = new Random();
        return validDefenders.get(random.nextInt(validDefenders.size()));
    }

    public static void printHealths(ArrayList<Combatant> combatants) {
        System.out.println();
        System.out.println("***HEALTH BOARD***");

        // find the length of the longest name
        int max_length = 0;
        for (Combatant c : combatants) {
            if (c.getName().length() > max_length) {
                max_length = c.getName().length();
            }
        }

        // for each Combatant in the List...
        for (Combatant c : combatants) {
            // don't print dead combatants
            if (c.getHealth() <= 0) {
                continue;
            }

            System.out.print(c.getName());

            // print enough tabs that all the health bars are aligned
            for (int i=0; i<((c.getName().length() - max_length) / TAB_LENGTH) + 1; i++) {
                System.out.print("\t");
            }

            // 2 half-block characters for every health point
            for (int i=0; i<c.getHealth() * 2; i++) {
                // System.out.print("█");
                System.out.print("▀");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void simBattle(ArrayList<Combatant> combatants, boolean verbose) throws Exception {
        // while there is more than one combatant remaining…
        Combatant attacker;
        Combatant defender;
        while (getLivingCombatants(combatants).size() > 1) {
            if (verbose) { printHealths(combatants); }

            attacker = getRandomCombatant(combatants);
            defender = getDefender(combatants, attacker);

            attacker.attack(defender, VERBOSE);

            // after the attack…
            if (defender.getHealth() <= 0) {
                if (verbose) { System.out.println(attacker.getName() + " has defeated " + defender.getName() + "!"); }
            }
        }
        // TODO: move the "sole survivor" print statement to the Combatant.win method
        if (verbose) {System.out.println(getLivingCombatants(combatants).get(0).getName() + " is the sole survivor on Middle-Earth!"); }
        getLivingCombatants(combatants).get(0).win(); // increment the combatant's win counter
        // reset all the combatants' healths for the next round
        for (Combatant c : combatants) {
            c.reset();
        }
    }

}