package Characters.Skills;

import Characters.Attributes.AttributeEnum;
import Characters.Attributes.Attributes;
import Repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class CharacterSkills {
    private List<Skill> characterSkillList = new ArrayList<>();
    private Skills masterList;
    private Repository repository;

    public CharacterSkills(Repository repository, Attributes attributes) {
        this.repository = repository;

        List<Skill> allSkills = repository.getAllSkills();
        this.masterList = new Skills(allSkills);

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
