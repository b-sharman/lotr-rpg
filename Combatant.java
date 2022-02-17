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

    public String toString() {
		String msg = "";
		msg += this.name + "\n";
		msg += "Starting health: " + this.getHealth() + "\n";
		msg += "Attack probability: " + this.getAttackProb()  + "\n";
		msg += "Attack damage: " + this.getDamage() + "\n";
		msg += "Critical probability: " + this.getCriticalProb() + "\n";
		msg += "Critical damage: " + this.getCriticalDamage() + "\n";
		msg += "Shield probability: " + this.getShieldProb() + "\n";
		return msg;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

}