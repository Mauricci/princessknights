import UI.NewWindow;

public class PrincessKnights {

    public static void main(String[] args) {
//        Window window = new Window(null);
        NewWindow window = new NewWindow();
        window.setVisible(true);
        Game game = new Game(args[0], window);
        boolean running = true;
        while(running){
            game.StartGame();
        }
    }
}
