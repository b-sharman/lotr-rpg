public abstract class Combatant {

    private String name;
    private int health;

    public Combatant(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public abstract void speak();

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}