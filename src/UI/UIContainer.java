package UI;

public class UIContainer implements Runnable{

    private Thread thread;
    private Window window;
    private Renderer renderer;
    private AbstractGame game;
    //keyboard/mouse events here?

    private boolean running = false;
    private final double UPDATE_CAP = 1.0/60.0;             //to get 60 fps/sec
    private int width = 320;
    private int height = 240;
    private float scale = 4f;
    private String title = "Princess Knights v1.0";

    public UIContainer(AbstractGame game) { this.game = game; }

    public void start() {
        window = new Window(this);
        renderer = new Renderer(this);
        thread = new Thread(this);
        thread.run();
    }

    @Override
    public void run() {
        running = true;

        boolean render;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;             //scale accuracy to milliseconds
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        while (running) {
            render = false;

            //check time passed since last update
            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while(unprocessedTime >= UPDATE_CAP) {
                unprocessedTime -= UPDATE_CAP;
                render = true;
                game.update(this, (float)UPDATE_CAP);
               //TODO: insert instance of game to be updated here                                                             //game.update(this(float)UPDATE_CAP);
               //check for input updates (key/ mouse events)                             //input.update()
                if(frameTime >= 1.0) {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS: " + fps);
                }
            }
            if(render) {
                renderer.clear();
                game.render(this, renderer);
                renderer.process();
                //renders font in cyan, in top left corner
                renderer.drawFont("FPS: " + fps, 0, 0, 0xff00ffff);
                window.update();
                frames++;
            } else {
                try{
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        //dispose();
    }

    //getters & setters
    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
