import UI.*;

public class PrincessKnights extends AbstractGame {
    private Image image;
    private Font font;

    public PrincessKnights() {
        image = new Image("/images/test.png");
        font = new Font("/fonts/comic.png");
    }

    //method to update animation (ImageTile)
    @Override
    public void update(UIContainer container, float dt) {

    }

    //use this method to render images
    @Override
    public void render(UIContainer container, Renderer rend) {
        rend.clear();
        rend.drawImage(image, 50, 50);
        rend.drawRect(100, 100, 50, 50, 0x00000000);
        rend.drawFont("Hej hej, det här är en fin font", 0, 0, 0xffffffff);
    }

    public static void main(String[] args) {
        UIContainer ui = new UIContainer(new PrincessKnights());
        ui.start();
    }
}
