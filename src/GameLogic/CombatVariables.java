package GameLogic;

import Characters.Character;
import Characters.Data.AttributeEnum;
import Characters.Data.Skill;

public class CombatVariables {
    private double power;
    private double abilityModifier;

    public CombatVariables(Character character, AttributeEnum attributeEnum, Skill skill) {
        this.power = character.getAttribute(attributeEnum) + skill.getCombatMod();
//        this.abilityModifier = character.

    }

    public CombatVariables(Character character, AttributeEnum attributeEnum) {
        this.power = character.getAttribute(attributeEnum);

    }

    public double getPower(){
        return power;
    }

    public double getAbilityModifier() {
        return 0.0;
    }
}
