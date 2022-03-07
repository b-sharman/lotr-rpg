public class RohanMan extends Man {

    private static final int HEALTH = 30;
    private static final int ATTACK_PROBABILITY = 83;
    private static final int DAMAGE = 4;
    private static final int CRITICAL_PROBABILITY = 0;
    private static final int CRITICAL_DAMAGE = 0;
    private static final int SHIELD_PROBABILITY = 17;

    public RohanMan(String name) {
        super(name, HEALTH);
    }

    public void reset() {
        // reset health for the next game
        reset(HEALTH);
    }

    public void speak() {
        System.out.println(getName() + ": I am a man of Rohan!");
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