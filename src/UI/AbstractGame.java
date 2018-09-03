package UI;

public abstract class AbstractGame {
    public abstract void update(UIContainer container, float dt);
    public abstract void render(UIContainer container, Renderer rend);
}
