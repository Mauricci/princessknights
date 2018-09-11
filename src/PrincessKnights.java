import UI.Window;

public class PrincessKnights {

    public static void main(String[] args) {
        Window window = new Window(null);
        Game game = new Game(args[0], window);
        boolean running = true;
        while(running){
            game.StartGame();
        }
    }
}
