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
        Scene firstScene = scenes.get(firstID);
        currentSceneData = new SceneData(null,firstID,StoryConstants.AUTO_NEXT_QUESTION,new DialogData(firstScene.getFirstDialogID(),firstScene.getFirstDialogFlag(),null));
    }
    public SceneData doScenario(Princess princess,int choice){
        if(currentSceneData.getFlag() != StoryConstants.SCENARIO_DONE && currentSceneData.getFlag() != StoryConstants.COMBAT_DONE ) {
            currentSceneData = scenes.get(currentSceneData.getId()).doScene(princess, choice);
            if(currentSceneData.getFlag() == StoryConstants.COMBAT_DONE){
                //do some stuff
                System.out.println("Nu har vi gjort en combat!");
            }
        }
        return currentSceneData;

    }
}
