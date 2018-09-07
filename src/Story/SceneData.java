package Story;

import GameLogic.CombatResult;

class SceneData {
    String id;
    int flag;

    SceneData(CombatResult combatResult, String id, int flag){
        this.id = id;
        this.flag = flag;
    }

    String getId() {
        return id;
    }

    int getFlag() {
        return flag;
    }
}
