public class GondorMan extends Man {

    private static final int HEALTH = 36;

    public GondorMan(String name) {
        super(name, HEALTH);
    }

    public void speak() {
        System.out.println(getName() + ": I am a man of Gondor!");
    }

}