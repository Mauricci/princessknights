package Characters.Data;

public class Skill {
    protected SkillAttribute skillAttribute;
    protected int unlockedLevel;
    protected double combatMod;
    protected int skillLevel;

    public Skill(SkillAttribute skillAttribute, double combatMod, int unlockedLevel) {
        this.skillAttribute = skillAttribute;
        this.combatMod = combatMod;
        this.unlockedLevel = unlockedLevel;
        skillLevel = 1;

    }

    public SkillAttribute getSkillAttribute() {
        return skillAttribute;
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
