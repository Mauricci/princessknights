package Story;

import Characters.Princess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scenario {
    //collection av scener
    private Map<Integer, Scene> scenarioMap = new HashMap<>();
    private SceneData currentSceneData;

    public Scenario(List<Integer> scenesID){
        //ladda in alla scener i en map

    }
    public void doScenario(Princess princess){
        while(currentSceneData.getFlag() != StoryConstants.SCENARIODONE && currentSceneData.getFlag() != StoryConstants.COMBATDONE ) {
            currentSceneData = scenarioMap.get(currentSceneData.getId()).doScene(princess);
            if(currentSceneData.getFlag() == StoryConstants.COMBATDONE){
                //do some stuff
                System.out.println("Nu har vi gjort en combat!");
            }
        }

    }
}
