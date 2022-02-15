public class Elf extends Combatant {

    private static final int HEALTH = 42;
    private static final int ATTACK_PROBABILITY = 83;
    private static final int DAMAGE = 4;
    private static final int CRITICAL_PROBABILITY = 17;
    private static final int CRITICAL_DAMAGE = 8;
    private static final int SHIELD_PROBABILITY = 0;

    public Elf(String name) {
        super(name, HEALTH);
    }

    public void speak() {
        System.out.println(getName() + ": A red moon rises!");
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