package TrainingLogic;

import Characters.Data.AttributeEnum;
import Characters.Data.Skill;
import Characters.Princess;

public class TrainingLogic {
    private final int SKILLMAXLEVEL = 10;

    public void trainAttribute(Princess princess, Skill skill, int cost) {
        //connect to click on increment training in window

        checkSkillAndRemoveCost(princess, skill, cost);
        addStatToPrincess(princess, skill);
    }


    public void addStatToPrincess(Princess princess, Skill skill) {
        if (skill.getSkillLevel() == SKILLMAXLEVEL) {
            AttributeEnum ae = skill.getAttributeEnum();
            switch (ae) {
                case STRENGTH:
                    princess.addStrength(1);
                    break;
                case SPEED:
                    princess.addSpeed(1);
                    break;
                case INTELLIGENCE:
                    princess.addIntelligence(1);
                case CHARISMA:
                    princess.addCharisma(1);
            }
        }
    }
    public void checkSkillAndRemoveCost(Princess princess, Skill skill, int cost) {
        if (skill.getSkillLevel() < SKILLMAXLEVEL) {
            if (princess.getTrainingPoints() >= cost) {
                skill.incrementSkill();
                princess.setTrainingPoints(princess.getTrainingPoints() - cost);
            }
        }
        //else error
    }
}
