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
            for(int attributeValue = 1; attributeValue<=maxValue; attributeValue++){
                List<Skill> currentList = new ArrayList<>();
                listMap.put(attributeValue,currentList);
            }

            skills.put(getSkillAttribute(attribute), listMap);
        }


        for(Skill skill : masterList){
            Map<Integer, List<Skill>> skilllist = skills.get(skill.skillAttribute);
            skills.get(skill.skillAttribute).get(skill.unlockedLevel).add(skill);
        }
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

    public List<Skill> getSkillWithinRange(SkillAttribute skillAttribute, int minRange, int maxRange){
        List<Skill> returnThis = new ArrayList<>();
        for(int i = minRange; i <= maxRange; i++) {
            returnThis.addAll(skills.get(skillAttribute).get(i));
        }
        return returnThis;
    }
}
