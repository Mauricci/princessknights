package TrainingLogic;

import Characters.Data.AttributeEnum;
import Characters.Data.Skill;
import Characters.Princess;

public class TrainingLogic {
    private final int SKILLMAXLEVEL = 10;
    private final int SKILLCOST = 1;

    public void trainAttribute(Princess princess, Skill skill) {
        //connect to click on increment training in window

        checkSkillAndRemoveCost(princess, skill);
        addStatToPrincess(princess, skill);
    }

    public void checkSkillAndRemoveCost(Princess princess, Skill skill) {
        if (skill.getSkillLevel() < SKILLMAXLEVEL) {
            if (princess.getTrainingPoints() >= SKILLCOST) {
                skill.incrementSkill();
                princess.setTrainingPoints(princess.getTrainingPoints() - SKILLCOST);
            }
        }
    }

    public void addStatToPrincess(Princess princess, Skill skill) {
        if (skill.getSkillLevel() == SKILLMAXLEVEL && !skill.isSkillIsMaxed()) {
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
