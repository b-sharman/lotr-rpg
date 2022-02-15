public class Dwarf extends Combatant {

    private static final int HEALTH = 36;

    public Dwarf(String name) {
        super(name, HEALTH);
    }

    public void speak() {
        System.out.println(getName() + ": Let them come!");
    }

}