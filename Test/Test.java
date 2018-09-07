import Characters.Attributes.AttributeEnum;
import Characters.Enemy;
import Characters.Princess;
import Characters.Skills.Skill;
import Characters.Skills.Skills;
import Repository.Repository;
import Story.Dialog;
import Story.Scenario;
import TrainingLogic.TrainingLogic;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Repository repository = new Repository(args[0]);

        //DBtest to get enemy -- OK --
        Enemy testEnemy = repository.getEnemyForScene("Test");
        System.out.println(testEnemy.getName());


        //DBTest to get skills of one attribute -- OK --
        List<Skill> allSkills = repository.getAllSkills();
        System.out.println(allSkills.get(1).getName()
                            + " "
                            + allSkills.get(1).getAttributeEnum()
                            + " "
                            + allSkills.get(1).getDescription()
                            + ". Låses upp på "
                            + allSkills.get(1).getUnlockedLevel()
                            + ". Bonus: "
                            + allSkills.get(1).getCombatMod());

        //Test to get all skills of one attribute
        System.out.println("\nSTRENGTH LIST");
        Skills strSkills = new Skills(allSkills);
        List<Skill> strengthList = strSkills.getSkillWithinRange(AttributeEnum.STRENGTH, 1, 10);
        for (Skill skill : strengthList) {
            System.out.println(skill.getName()
                    + " "
                    + skill.getAttributeEnum()
                    + " "
                    + skill.getDescription()
                    + ". Låses upp på "
                    + skill.getUnlockedLevel()
                    + ". Bonus: "
                    + skill.getCombatMod());
        }
        
        System.out.println("\nINTELLIGENCE LIST");
        Skills intSkills = new Skills(allSkills);
        List<Skill> intList = intSkills.getSkillWithinRange(AttributeEnum.INTELLIGENCE, 1, 10);
        for (Skill skill : intList) {
            System.out.println(skill.getName()
                    + " "
                    + skill.getAttributeEnum()
                    + " "
                    + skill.getDescription()
                    + ". Låses upp på "
                    + skill.getUnlockedLevel()
                    + ". Bonus: "
                    + skill.getCombatMod());
        }

        //DBTest get dialog by dialogID
        Dialog testDialog = repository.getDialog("S1_S1_Intro");

//        List<Skill> skills = new ArrayList<>();
//        skills.add(new Skill("Skill 1", "Skill description", AttributeEnum.CHARISMA, 5, 10));
//        skills.add(new Skill("Skill 2", "Skill description", AttributeEnum.CHARISMA, 3, 5));
//        skills.add(new Skill("Skill 3", "Skill description", AttributeEnum.CHARISMA, 6, 3));
//        skills.add(new Skill("Skill 4", "Skill description", AttributeEnum.CHARISMA, 6, 2));
//        skills.add(new Skill("Skill 5", "Skill description", AttributeEnum.CHARISMA, 6, 1));
//
//        Skills skillmap = new Skills(skills);
//
//        List<Skill> skillList = skillmap.getSkillWithinRange(AttributeEnum.CHARISMA, 1, 5);
//
//        for(Skill skill : skillList){
//            System.out.println(skill.getName() + ", " +
//                    skill.getAttributeEnum() +", " +
//                    skill.getUnlockedLevel() + ", " +
//                    skill.getCombatMod());
//        }
//
//        Princess princess = new Princess(10, 10, 10, 10,5,20, skillmap);
//        TrainingLogic trainingLogic = new TrainingLogic();
//        Skill skill = skillList.get(1);
//        for (int i = 0; i < 15; i++) {
//            trainingLogic.trainPrincess(princess, skill);
//            System.out.println(skill.getName() + " " + skill.getSkillLevel());
//            System.out.println("princess charisma " + princess.getAttributes().getCharisma());
//        }
    }
}
