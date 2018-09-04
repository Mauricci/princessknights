package Characters;

import Characters.Attributes.Attributes;

public class Enemy extends Character {
    public Enemy(int strength, int speed, int intelligence, int charisma, int hp) {
        this.attributes = new Attributes(strength, speed, intelligence, charisma, hp);
    }
}
