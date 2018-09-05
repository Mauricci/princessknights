package Story;

import Characters.Princess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scenario {
    //collection av scener
    private Map<Integer, Scene> scenes;
    private SceneData currentSceneData;

    public Scenario(Map<Integer, Scene> scenes, int firstID){
        this.scenes = scenes;
        currentSceneData = new SceneData(null,firstID,StoryConstants.AUTONEXTQUESTION);
    }
    public boolean doScenario(Princess princess){
        while(currentSceneData.getFlag() != StoryConstants.SCENARIODONE && currentSceneData.getFlag() != StoryConstants.COMBATDONE ) {
            currentSceneData = scenes.get(currentSceneData.getId()).doScene(princess);
            if(currentSceneData.getFlag() == StoryConstants.COMBATDONE){
                //do some stuff
                System.out.println("Nu har vi gjort en combat!");
            }
        }
        return false;

    }
}
