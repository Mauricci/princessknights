package Story;

import GameLogic.CombatResult;

public class SceneData {
    String id;
    int flag;

    public SceneData(CombatResult combatResult, String id, int flag){
        this.id = id;
        this.flag = flag;
    }

    public String getId() {
        return id;
    }

    public int getFlag() {
        return flag;
    }
}
