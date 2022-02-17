public class Man extends Combatant {

    private static final int HEALTH = 33;
    private static final int ATTACK_PROBABILITY = 67;
    private static final int DAMAGE = 6;
    private static final int CRITICAL_PROBABILITY = 0;
    private static final int CRITICAL_DAMAGE = 0;
    private static final int SHIELD_PROBABILITY = 17;

    public Man(String name) {
        super(name, HEALTH);
    }

    public Man(String name, int health) {
        super(name, health);
    }

    public void speak() {
        System.out.println(getName() + ": I am a man!");
    }

    public String blockMessage(Combatant attacker) {
        return attacker.getName() + "'s attack is blocked by " + getName() + "'s shield!";
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