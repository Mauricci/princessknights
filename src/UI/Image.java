package UI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Image {
    private int width, height;
    private int[] pixels;
    //alpha rendering?


    public Image(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(Image.class.getResourceAsStream(path));             //if null, try replacing this line with the following: image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        width = image.getWidth();
        height = image.getHeight();
        pixels = image.getRGB(0, 0, width, height, null, 0, width);  //get pixel data for an image

        image.flush();
    }

    public Image(int[] pixels, int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }

    //getters & setters
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

    public int[] getPixels() {
        return pixels;
    }

    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }
}
