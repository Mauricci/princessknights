import Characters.Data.Skill;
import Characters.Data.SkillAttribute;
import Characters.Data.Skills;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill(SkillAttribute.CHARISMA, 5));
        skills.add(new Skill(SkillAttribute.CHARISMA, 3));
        skills.add(new Skill(SkillAttribute.CHARISMA, 6));
        skills.add(new Skill(SkillAttribute.CHARISMA, 6));
        skills.add(new Skill(SkillAttribute.CHARISMA, 6));

        Skills skillmap = new Skills(skills,5,4);
        List<Skill> skillList = skillmap.getSkillWithinRange(SkillAttribute.CHARISMA, 1, 5);
        for(Skill skill : skillList){
            System.out.println(skill.getSkillAttribute() +", " +skill.getUnlockedLevel() + ", "+skill.getCombatMod());
        }
    }
}
