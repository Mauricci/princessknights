import Characters.Data.Skill;
import Characters.Data.SkillAttribute;
import Characters.Data.Skills;

import java.util.ArrayList;
import java.util.List;

public class maintest {

    public static void main(String[] args) {
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill(SkillAttribute.CHARISMA, 5));

        Skills skillmap = new Skills(skills,1,1);
        List<Skill> skillList = skillmap.getSkill(SkillAttribute.CHARISMA, 1);
        for(Skill skill : skillList){
            System.out.println(skill.getSkillAttribute() +", " +skill.getSkillLevel() + ", "+skill.getCombatMod());
        }
    }
}
