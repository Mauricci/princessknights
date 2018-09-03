package Characters.Data;

public class Abilities {
    protected int strength;
    protected int speed;
    protected int intelligence;
    protected int charisma;

    public Abilities(int strength, int speed, int intelligence, int charisma) {
        this.strength = strength;
        this.speed = speed;
        this.intelligence = intelligence;
        this.charisma = charisma;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCharisma() {
        return charisma;
    }
}
