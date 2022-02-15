public class Dwarf extends Combatant {

    private static final int HEALTH = 36;
    private static final int ATTACK_PROBABILITY = 50;
    private static final int DAMAGE = 7;
    private static final int CRITICAL_PROBABILITY = 33;
    private static final int CRITICAL_DAMAGE = 12;
    private static final int SHIELD_PROBABILITY = 0;

    public Dwarf(String name) {
        super(name, HEALTH);
    }

    public void speak() {
        System.out.println(getName() + ": Let them come!");
    }

    public int getAttackProb() {
        return ATTACK_PROBABILITY;
    }

    public int getDamage() {
        return DAMAGE;
    }

    public int getCriticalProb() {
        return CRITICAL_PROBABILITY;
    }

    public int getCriticalDamage() {
        return CRITICAL_DAMAGE;
    }

    public int getShieldProb() {
        return SHIELD_PROBABILITY;
    }

}