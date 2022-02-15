public class RohanMan extends Man {

    private static final int HEALTH = 30;

    public RohanMan(String name) {
        super(name, HEALTH);
    }

    public void speak() {
        System.out.println(getName() + ": I am a man of Rohan!");
    }

}