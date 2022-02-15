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

    public void speak() {
        System.out.println(getName() + ": I am a man of Rohan!");
    }

}