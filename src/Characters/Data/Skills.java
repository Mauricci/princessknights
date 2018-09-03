package Characters.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Skills {
    public Map<SkillAttribute, Map<Integer, List<Skill>>> skills = new HashMap<>();

    public Skills(List<Skill> masterList, int maxValue, int amountOfAttributes) {
        skills.put(SkillAttribute.STRENGTH, new HashMap<>());
        skills.put(SkillAttribute.INTELLIGENCE, new HashMap<>());
        skills.put(SkillAttribute.SPEED, new HashMap<>());
        skills.put(SkillAttribute.CHARISMA, new HashMap<>());



        for(int attribute = 0; attribute<amountOfAttributes;attribute++){
            Map<Integer, List<Skill>> listMap = new HashMap<>();
            for(int attributeValue = 1; attributeValue<maxValue; attributeValue++){
                List<Skill> currentList = new ArrayList<>();
                listMap.put(attributeValue,currentList);
            }

            skills.put(getSkillAttribute(attribute), listMap);
        }


        for(Skill skill : masterList){
            skills.get(skill.skillAttribute).get(skill.skillLevel).add(skill);
        }
        //method call to dbrepo to get list of all skills, use for-loop
    }

    private SkillAttribute getSkillAttribute(int attribute) {
        SkillAttribute skillAttribute = SkillAttribute.STRENGTH;
        switch(attribute){
            case 1:
                skillAttribute = SkillAttribute.SPEED;
                break;
            case 2:
                skillAttribute = SkillAttribute.INTELLIGENCE;
                break;
            case 3:
                skillAttribute = SkillAttribute.CHARISMA;
                break;
        }
        return skillAttribute;
    }

    public List<Skill> getSkill(SkillAttribute skillAttribute, int value){
        return skills.get(skillAttribute).get(value);
    }

    //method with input int level and princess-object
    // with for-loop to create a map of character skills
}
