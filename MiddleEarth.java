import java.util.ArrayList;
import java.util.Random;

public class MiddleEarth {

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

}
