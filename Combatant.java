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
		msg += "Starting Health: " + this.getHealth() + "\n";
		msg += "Attack Prob: " + this.getAttackProb()  + "\n";
		msg += "Attack Power: " + this.getDamage() + "\n";
		msg += "Critical Hit Prob: " + this.getCriticalProb() + "\n";
		msg += "Critical Hit Power: " + this.getCriticalDamage() + "\n";
		msg += "Shield Prob: " + this.getShieldProb() + "\n";
		return msg;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

}