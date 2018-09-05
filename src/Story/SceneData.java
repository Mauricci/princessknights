package Story;

import GameLogic.CombatResult;

public class SceneData {
    int id;
    int flag;

    public SceneData(CombatResult combatResult, int id, int flag){
        this.id = id;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public int getFlag() {
        return flag;
    }
}
