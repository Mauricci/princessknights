package Characters.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Skills {
    public Map<AttributeEnum, Map<Integer, List<Skill>>> skills = new HashMap<>();

    public Skills(List<Skill> masterList, int maxValue, int amountOfAttributes) {
        skills.put(AttributeEnum.STRENGTH, new HashMap<>());
        skills.put(AttributeEnum.INTELLIGENCE, new HashMap<>());
        skills.put(AttributeEnum.SPEED, new HashMap<>());
        skills.put(AttributeEnum.CHARISMA, new HashMap<>());

        for(int attribute = 0; attribute<amountOfAttributes;attribute++){
            Map<Integer, List<Skill>> listMap = new HashMap<>();
            for(int attributeValue = 1; attributeValue<=maxValue; attributeValue++){
                List<Skill> currentList = new ArrayList<>();
                listMap.put(attributeValue,currentList);
            }
            skills.put(getSkillAttribute(attribute), listMap);
        }

        for(Skill skill : masterList){
            skills.get(skill.attributeEnum).get(skill.unlockedLevel).add(skill);
        }
    }

    private AttributeEnum getSkillAttribute(int attribute) {
        AttributeEnum attributeEnum = AttributeEnum.STRENGTH;
        switch(attribute){
            case 1:
                attributeEnum = AttributeEnum.SPEED;
                break;
            case 2:
                attributeEnum = AttributeEnum.INTELLIGENCE;
                break;
            case 3:
                attributeEnum = AttributeEnum.CHARISMA;
                break;
        }
        return attributeEnum;
    }

    public List<Skill> getSkillWithinRange(AttributeEnum attributeEnum, int minRange, int maxRange){
        List<Skill> returnThis = new ArrayList<>();

        for(int i = minRange; i <= maxRange; i++) {
            returnThis.addAll(skills.get(attributeEnum).get(i));
        }
        return returnThis;
    }
}
