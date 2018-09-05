import Characters.Princess;
import Characters.Skills.Skills;
import Story.Scenario;
import UI.Window;

import java.util.ArrayList;
import java.util.Scanner;

public class PrincessKnights {
    public static void main(String[] args) {
        boolean running = true;
        Princess princess = new Princess(5,5,5,5,5,5,new Skills(new ArrayList<>()));
        while(running){
            Scanner scanner = new Scanner(System.in);
            Scenario scenario = new Scenario(new ArrayList<>());
            scenario.doScenario(princess);
        }
    }
}
