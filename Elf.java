public class Elf extends Combatant {

    private static final int HEALTH = 42;

    public Elf(String name) {
        super(name, HEALTH);
    }

    public void speak() {
        System.out.println(getName() + ": A red moon rises!");
    }

}