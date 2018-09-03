package Characters.Data;

public class Skill {
    protected String skillName;
    protected AttributeEnum attributeEnum;
    protected int unlockedLevel;
    protected double combatMod;
    protected int skillLevel;

    public Skill(String skillName, AttributeEnum attributeEnum, double combatMod, int unlockedLevel) {
        this.skillName = skillName;
        this.attributeEnum = attributeEnum;
        this.combatMod = combatMod;
        this.unlockedLevel = unlockedLevel;
        skillLevel = 1;

    }

    public String getSkillName() { return skillName;}

    public AttributeEnum getAttributeEnum() {
        return attributeEnum;
    }

    public int getUnlockedLevel() {
        return unlockedLevel;
    }

    public double getCombatMod() {
        return combatMod;
    }

    public int getSkillLevel() { return skillLevel;}

    public void incrementSkill() {
        this.skillLevel++;
    }
}
