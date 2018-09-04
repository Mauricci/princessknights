package Characters.Data;

import java.util.ArrayList;
import java.util.List;

public class CharacterSkills {
    private List<Skill> characterSkillList = new ArrayList<>();
    private Skills masterList;

    public CharacterSkills(Attributes attributes, Skills masterList) {
        this.masterList = masterList;

        int[] attrArray = {attributes.getStrength(),
                attributes.getSpeed(),
                attributes.getIntelligence(),
                attributes.getCharisma()};

        for (int i = 0; i < attrArray.length; i++) {
            characterSkillList.addAll(masterList.getSkillWithinRange(masterList.getSkillAttribute(i), 1, attrArray[i]));
        }
    }

    public void updateCharacterSkills(AttributeEnum ae, int attribute) {
        if (!characterSkillList.contains(masterList.getSkillWithinRange(ae, attribute, attribute))) {
            characterSkillList.addAll(masterList.getSkillWithinRange(ae, attribute, attribute));
        }
    }

    public List<Skill> getCharacterSkillList() {
        return characterSkillList;
    }
}
