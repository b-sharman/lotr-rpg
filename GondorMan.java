public class GondorMan extends Man {

    private static final int HEALTH = 36;
    private static final int ATTACK_PROBABILITY = 67;
    private static final int DAMAGE = 5;
    private static final int CRITICAL_PROBABILITY = 0;
    private static final int CRITICAL_DAMAGE = 0;
    private static final int SHIELD_PROBABILITY = 33;

    public GondorMan(String name) {
        super(name, HEALTH);
    }

    public void speak() {
        System.out.println(getName() + ": I am a man of Gondor!");
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