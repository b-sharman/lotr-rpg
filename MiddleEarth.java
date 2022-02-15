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
    }

}
