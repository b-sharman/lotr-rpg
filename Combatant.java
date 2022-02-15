public abstract class Combatant {

    private String name;
    private int health;

    public Combatant(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public abstract void speak();

    public abstract int getAttackProb();
    public abstract int getDamage();
    public abstract int getCriticalProb();
    public abstract int getCriticalDamage();
    public abstract int getShieldProb();

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

}