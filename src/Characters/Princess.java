package Characters;

import Characters.Data.Attributes;

public class Princess extends Character {
    protected int trainingPoints;

    public Princess(int strength, int speed, int intelligence, int charisma, int hp, int trainingPoints) {
        this.attributes = new Attributes(strength, speed, intelligence, charisma, hp);
        this.trainingPoints = trainingPoints;
    }

    public int getTrainingPoints() {
        return trainingPoints;
    }

    public void setTrainingPoints(int trainingPoints) {
        this.trainingPoints = trainingPoints;
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
