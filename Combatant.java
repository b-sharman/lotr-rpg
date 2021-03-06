import java.util.Random;

public abstract class Combatant {

    // maximum value for probabilities
    private static final int POINT_SCALE = 100;
    // length of time it takes to resolve an attack, in ms
    private static final int FIGHT_TIME = 2500;
    // length of time between attacks, in ms
    private static final int PEACE_TIME = 800;

    private String name;
    private int health;
    private int numWins; // number of battle sims won

    public Combatant(String name, int health) {
        this.name = name;
        this.health = health;
        numWins = 0;
    }

    public abstract void speak();
    public abstract void reset();

    public abstract int getAttackProb();
    public abstract int getDamage();
    public abstract int getCriticalProb();
    public abstract int getCriticalDamage();
    public abstract int getShieldProb();

    public static void delay(int milli) {
        try {
            Thread.sleep(milli);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reset(int health) {
        this.health = health;
    }

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

    public void attack(Combatant defender, boolean verbose) {
        // create a new Random object
        Random random = new Random();
        // generate a value from 1 to POINT_SCALE, inclusive
        int roll = random.nextInt(POINT_SCALE) + 1;
        if (verbose) {
            speak();
            System.out.println(this.name + " is attacking " + defender.getName() + ".");
        }

        delay(FIGHT_TIME);

        String msg = "";
        int damage = 0;
        // if the attack was successful
        if (roll <= getAttackProb()) {
            // if it was a critical hit
            if (roll <= getCriticalProb()) {
                // run the proper criticalHit method - either Elf or Dwarf - and store the returned msg
                // store the damage returned by the critical hit power getter
                if (this instanceof Elf) {
                    msg = ((Elf)this).criticalMessage(defender);
                }
                else if (this instanceof Dwarf) {
                    msg = ((Dwarf)this).criticalMessage(defender);
                }
                damage = getCriticalDamage();
            }
            // else (normal hit)
            else {
                msg = "Successful attack!";
                damage = getDamage();
            }

            // if the defender can block, overwrite the previous values
            // to add more blocking classes than Men, it would make sense to create
            // a Blocker abstract class
            if (defender instanceof Man) {
                // generate a value from 1 to POINT_SCALE, inclusive
                int defense_roll = random.nextInt(POINT_SCALE) + 1;
                // if the defensive roll is less than or equal to the defender's shield probability
                if (defense_roll <= defender.getShieldProb()) {
                    // run the proper block method and store the returned msg
                    // we can cast as Man because only Man objects have shields!
                    msg = ((Man)defender).blockMessage(this);
                    // set damage to be zero
                    damage = 0;
                }
            }
        }
        // else...
        else {
            msg = "Failed attack.";
            damage = 0;
        }

        if (verbose) { System.out.println(msg); }
        // subtract damage from the opponent's health
        defender.health -= damage;

        delay(PEACE_TIME);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getNumWins() {
        return numWins;
    }

    // call after the character wins to increase the win counter
    public void win() {
        numWins++;
    }

}