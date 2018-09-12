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
        Scene firstScene = this.scenes.get(firstID);
        DialogData dialogData = new DialogData(firstScene.getFirstDialogID(), "", firstScene.getFirstDialogFlag(),null);
        currentSceneData = new SceneData(firstID,StoryConstants.AUTO_NEXT_DIALOG, dialogData);
    }
    public SceneData doScenario(Princess princess,int choice){
        if(currentSceneData.getFlag() != StoryConstants.SCENARIO_DONE) {
            if(currentSceneData.getDialogData().flag == StoryConstants.DONE) {
                if(currentSceneData.getId() != null){
                    String id = currentSceneData.getDialogData().getSelectedChoice();
                    Scene scene = scenes.get(id);
                    currentSceneData = scene.doScene(princess, choice);
                }
            }
            else {
                String id = currentSceneData.getId();
                Scene scene = scenes.get(id);
                currentSceneData = scene.doScene(princess, choice);
            }
        }
        return currentSceneData;
    }
}
