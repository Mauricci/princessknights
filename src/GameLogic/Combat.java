package GameLogic;

import java.util.Random;

public class Combat {
    public CombatResult calculateCombatResult(CombatVariables playerVariables, CombatVariables monsterVariables){
        double combatStrength = playerVariables.getPower() / monsterVariables.getPower();
        double chanceToWin = 50.0;
        if(combatStrength < 1){
            chanceToWin -= 10*(1-combatStrength);
        }else if(combatStrength>1){
            chanceToWin += 10*combatStrength;
        }
        chanceToWin = chanceToWin + playerVariables.getAbilityModifier() - monsterVariables.getAbilityModifier();

        Random random = new Random();

        double result = chanceToWin*100 - (random.nextInt(100)+1);

        return new CombatResult(result);
    }
}
