package Characters.Data;

public class Skill {
    protected SkillAttribute skillAttribute;
    protected int skillLevel;
    protected double combatMod;

    public Skill(SkillAttribute skillAttribute, double combatMod) {
        this.skillAttribute = skillAttribute;
        this.combatMod = combatMod;
        skillLevel = 1;
    }

    public SkillAttribute getSkillAttribute() {
        return skillAttribute;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public double getCombatMod() {
        return combatMod;
    }
}
