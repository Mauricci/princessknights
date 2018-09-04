package TrainingLogic;

import Characters.CharacterConstants;
import Characters.Data.AttributeEnum;
import Characters.Data.Skill;
import Characters.Princess;

public class TrainingLogic {

    public void trainAttribute(Princess princess, Skill skill) {
        //connect to click on increment training in window

        checkSkillAndRemoveCost(princess, skill);
        addStatToPrincess(princess, skill);
    }

    public void checkSkillAndRemoveCost(Princess princess, Skill skill) {
        if (skill.getSkillLevel() < CharacterConstants.SKILL_MAX_LEVEL) {
            if (princess.getTrainingPoints() >= CharacterConstants.SKILL_COST) {
                skill.incrementSkill();
                princess.setTrainingPoints(princess.getTrainingPoints() - CharacterConstants.SKILL_COST);
            }
        }
    }

    public void addStatToPrincess(Princess princess, Skill skill) {
        if (skill.getSkillLevel() == CharacterConstants.SKILL_MAX_LEVEL && !skill.isSkillIsMaxed()) {
            AttributeEnum ae = skill.getAttributeEnum();
            switch (ae) {
                case STRENGTH:
                    princess.addStrength(1);
                    skill.setSkillIsMaxed(true);
                    break;
                case SPEED:
                    princess.addSpeed(1);
                    skill.setSkillIsMaxed(true);
                    break;
                case INTELLIGENCE:
                    princess.addIntelligence(1);
                    skill.setSkillIsMaxed(true);
                    break;
                case CHARISMA:
                    princess.addCharisma(1);
                    skill.setSkillIsMaxed(true);
                    break;
            }
        }
    }
}
