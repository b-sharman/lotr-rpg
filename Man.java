public class Man extends Combatant {

    private static final int HEALTH = 33;

    public Man(String name) {
        super(name, HEALTH);
    }

    public Man(String name, int health) {
        super(name, health);
    }

    public void speak() {
        System.out.println(getName() + ": I am a man!");
    }

}