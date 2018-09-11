import Characters.Princess;
import Characters.Skills.CharacterSkills;
import Characters.Skills.Skill;
import Characters.Skills.Skills;
import Story.*;
import UI.Drawable;
import UI.Window;
import Repository.Repository;
import Story.Dialog;
import Story.Scenario;
import Story.Scene;
import Story.StoryConstants;
import TrainingLogic.TrainingLogic;
import java.util.*;

public class PrincessKnights {


    public static void main(String[] args) {
        Window window = new Window(null);

        Game game = new Game(args[0], window);
        boolean running = true;

        while(running){
            game.StartGame();
        }
    }
}
