import java.util.ArrayList;
import java.util.Random;

public class MiddleEarth {

    // number of spaces in a tab - change to match environment
    public static final int TAB_LENGTH = 8;

    public static void main(String[] args) {
        ArrayList<Combatant> characters = new ArrayList<Combatant>();
        characters.add(new Elf("Legolas"));
        characters.add(new Dwarf("Bofur"));
        characters.add(new Man("Strider"));
        characters.add(new GondorMan("Faramir"));
        characters.add(new RohanMan("Éomer"));
    
        for (Combatant c : characters) {
            c.speak();
            // print character stats
            System.out.println(c);
        }

        ((Elf)characters.get(0)).attack(characters.get(3));
        // ((Dwarf)characters.get(1)).attack(characters.get(3));
    }

    public static Combatant getRandomCombatant(ArrayList<Combatant> combatants) {
        Random random = new Random();
        return combatants.get(random.nextInt(combatants.size()));
    }

    public static Combatant getDefender(ArrayList<Combatant> combatants, Combatant attacker) throws Exception {
        if (combatants.size() <= 1) {
            throw new Exception("not enough combatants remaining");
        }
        Combatant defender = attacker;
        while (defender.equals(attacker)) {
            defender = getRandomCombatant(combatants);
        }
        return defender;
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

}