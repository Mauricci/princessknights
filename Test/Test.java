import Characters.Data.Skill;
import Characters.Data.AttributeEnum;
import Characters.Data.Skills;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Skill 1", AttributeEnum.CHARISMA, 5, 10));
        skills.add(new Skill("Skill 2", AttributeEnum.CHARISMA, 3, 5));
        skills.add(new Skill("Skill 3", AttributeEnum.CHARISMA, 6, 3));
        skills.add(new Skill("Skill 4", AttributeEnum.CHARISMA, 6, 2));
        skills.add(new Skill("Skill 5", AttributeEnum.CHARISMA, 6, 1));

        Skills skillmap = new Skills(skills,10,4);

        List<Skill> skillList = skillmap.getSkillWithinRange(AttributeEnum.CHARISMA, 1, 5);

        for(Skill skill : skillList){
            System.out.println(skill.getSkillName() + ", " +
                    skill.getAttributeEnum() +", " +
                    skill.getUnlockedLevel() + ", " +
                    skill.getCombatMod());
        }
    }
}
