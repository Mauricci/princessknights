package Characters.Data;

import java.util.ArrayList;
import java.util.List;

public class CharacterSkills {
    private List<Skill> characterSkillList = new ArrayList<>();

    public CharacterSkills(Attributes attributes, Skills masterList) {
        int [] attrArray = {attributes.getStrength(),
                attributes.getSpeed(),
                attributes.getIntelligence(),
                attributes.getCharisma()};

        for (int i = 0; i < attrArray.length; i++) {
            masterList.getSkillWithinRange(masterList.getSkillAttribute(i), 1, attrArray[i]);
        }
    }

    public void updateCharacterSkills(AttributeEnum ae, int attribute) {

    }
}
