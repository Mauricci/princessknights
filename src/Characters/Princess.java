package Characters;

import Characters.Data.Attributes;

public class Princess extends Character {
    public Princess(int strength, int speed, int intelligence, int charisma, int hp) {
       this.attributes = new Attributes(strength, speed, intelligence, charisma, hp);
    }

    public void addStrength(int strength) {
        this.attributes.setStrength(this.attributes.getStrength() + strength);
    }
    public void addSpeed(int speed) {
        this.attributes.setSpeed(this.attributes.getSpeed() + speed);
    }
    public void addIntelligence(int intelligence) {
        this.attributes.setIntelligence(this.attributes.getIntelligence() + intelligence);
    }
    public void addCharisma(int charisma) {
        this.attributes.setCharisma(this.attributes.getCharisma() + charisma);
    }
}
