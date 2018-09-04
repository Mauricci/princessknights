package Characters.Data;

public class Skill {
    protected String skillName;
    protected AttributeEnum attributeEnum;
    protected int unlockedLevel;
    protected double combatMod;
    protected int skillLevel;
    protected boolean skillIsMaxed;

    public Skill(String skillName, AttributeEnum attributeEnum, double combatMod, int unlockedLevel) {
        this.skillName = skillName;
        this.attributeEnum = attributeEnum;
        this.combatMod = combatMod;
        this.unlockedLevel = unlockedLevel;
        this.skillLevel = 1;
        this.skillIsMaxed = false;

    }

    public boolean isSkillIsMaxed() {
        return skillIsMaxed;
    }

    public void setSkillIsMaxed(boolean skillIsMaxed) {
        this.skillIsMaxed = skillIsMaxed;
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
