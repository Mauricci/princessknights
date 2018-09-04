package Characters;

import Characters.Data.Attributes;
import Characters.Data.CharacterSkills;
import Characters.Data.Skills;

public class Princess extends Character {
    private int trainingPoints;
    private CharacterSkills characterSkills;

    public Princess(int strength, int speed, int intelligence, int charisma, int hp, int trainingPoints, Skills skillsList) {
        this.attributes = new Attributes(strength, speed, intelligence, charisma, hp);
        this.trainingPoints = trainingPoints;
        this.characterSkills = new CharacterSkills(this.attributes, skillsList);
    }

    public int getTrainingPoints() {
        return trainingPoints;
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    public void setTrainingPoints(int trainingPoints) {
        this.trainingPoints = trainingPoints;
    }

    public CharacterSkills getCharacterSkills() {
        return this.characterSkills;
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
