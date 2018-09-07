package Story;

import Characters.Princess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scenario {
    private Map<String, Scene> scenes;
    private SceneData currentSceneData;

    public Scenario(Map<String, Scene> scenes, String firstID){
        this.scenes = scenes;
        currentSceneData = new SceneData(null,firstID,StoryConstants.AUTO_NEXT_QUESTION);
    }
    public boolean doScenario(Princess princess){
        while(currentSceneData.getFlag() != StoryConstants.SCENARIO_DONE && currentSceneData.getFlag() != StoryConstants.COMBAT_DONE ) {
            currentSceneData = scenes.get(currentSceneData.getId()).doScene(princess);
            if(currentSceneData.getFlag() == StoryConstants.COMBAT_DONE){
                //do some stuff
                System.out.println("Nu har vi gjort en combat!");
            }
        }
        return false;

    }
}
