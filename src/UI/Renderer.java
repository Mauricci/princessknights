package UI;

import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.List;


public class Renderer {
    private Font font = Font.STANDARD;
    private List<ImageRequest> imageRequest = new ArrayList<>();

    private int pixelWidth;
    private int pixelHeight;
    private int[] pixels;

    private boolean processing = false;

    public Renderer(UIContainer container) {
        pixelWidth = container.getWidth();
        pixelHeight = container.getHeight();
        pixels = ((DataBufferInt)container.getWindow().getImage().getRaster().getDataBuffer()).getData();   //image pixel data
    }

    public void clear() {
        for(int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void process() {
        processing = true;

        for(int i = 0; i < imageRequest.size(); i++) {
            ImageRequest ir = imageRequest.get(i);
            drawImage(ir.image, ir.offX, ir.offY);
        }
        imageRequest.clear();
        processing = false;
    }

    public void setPixel(int x, int y, int colorBounds) {
        //invisible color needed?
        if (x < 0 || x>= pixelWidth || y < 0 || y >=pixelHeight) {
            return;
        }
    }

    public void drawFont(String text, int offX, int offY, int color) {
        int offSet = 0;

        for(int i = 0; i < text.length(); i++) {
            int unicode = text.codePointAt(i);

            for(int y = 0; y < font.getFontImage().getHeight(); y++) {
                for(int x = 0; x < font.getWidths()[unicode]; x++) {
                    if (font.getFontImage().getPixels()[(x + font.getOffSets()[unicode]) + y * font.getFontImage().getWidth()] == 0xffffffff) {   //loop through font image grid to find characters and print them out in white
                        setPixel(x + offX + offSet, y + offY, color);
                    }
                }
            }
            offSet += font.getWidths()[unicode];
        }
    }

    public void drawImage(Image image, int offX, int offY) {
        //don't rednder images if/when outside of window
        if(processing) {
            imageRequest.add(new ImageRequest(image, offX, offY));
            return;
        }
        if(offX  < - image.getWidth())
            return;
        if(offY < - image.getHeight())
            return;
        if(offX >= pixelWidth)
            return;
        if(offY >= pixelHeight)
            return;

        //clipping images when they go outside of screen
        int offScreenX = 0;
        int offScreenY = 0;
        int offScreenWidth = image.getWidth();
        int offScreenHeight = image.getHeight();

        if(offX < 0) {
            offScreenX -= offX;
        }
        if(offY < 0) {
            offScreenY -= offY;
        }
        if(offScreenWidth + offX >= pixelWidth) {
            offScreenWidth -= offScreenWidth + offX - pixelWidth;
        }
        if(offScreenHeight + offY >= pixelHeight) {
            offScreenHeight -= offScreenHeight + offY - pixelHeight;
        }

        //test code to draw an image @ a given location
        for(int y = offScreenY; y < offScreenHeight; y++) {
            for(int x = offScreenX; x < offScreenWidth; x++) {
                setPixel(x + offX, y + offY, image.getPixels()[x + y * image.getWidth()]);
            }
        }
    }

    //code to implement simple animations (e.g firework when winning a fight
//    public void drawImageTile(Image image, int offX, int offY, int tileX, int tileY) {
//        if(processing) {
//            imageRequest.add(new ImageRequest(image.))
//        }
//        //don't render images outside of window code
//        if (offX < - image.getTileWidth())
//            return;
//        if (offY < - image.getTileHeight())
//            return;
//        if (offX >= pixelWidth)                         //try adding -48 (for example) after pixelWidth to test, if image disappears the code works
//            return;
//        if (offY >= pixelHeight)                        //try adding -48 (for example) after pixelHeight to test, if image disappears the code works
//            return;
//
//        //variable for clipping code
//        int offScreenX = 0;
//        int offScreenY = 0;
//        int offScreenWidth = image.getTileWidth();
//        int offScreenHeight = image.getTileHeight();
//
//
//        //Clipping images when outside of screen to save FPS
//        if (offX < 0) {
//            offScreenX -= offX;
//            //System.out.println(offScreenX);                             //test, if number in console is increasing when image is outside, then it doesn't render
//        }
//
//        if (offY < 0) {
//            offScreenY -= offY;
//            //System.out.println(offScreenY);                             //test, if number in console is increasing when image is outside, then it doesn't render
//        }
//
//        if (offScreenWidth + offX >= pixelWidth) {
//            offScreenWidth -= offScreenWidth + offX - pixelWidth;
//            //System.out.println(offScreenWidth);                      //test, if number in console is decreasing when image is outside, then it doesn't render
//        }
//
//        if (offScreenHeight + offY >= pixelHeight) {
//            offScreenHeight -= offScreenHeight + offY - pixelHeight;
//            //System.out.println(offScreenHeight);                    //test, if number in console is decreasing when image is outside, then it doesn't render
//        }
//
//        for (int y =offScreenY; y<offScreenHeight; y++) {
//            for (int x =offScreenX; x<offScreenWidth; x++) {
//                setPixel(x + offX, y + offY, image.getPixels() [ (x + tileX * image.getTileWidth()) + (y + tileY * image.getTileHeight()) * image.getWidth()]);
//            }
//        }
//    }

    public void drawRect(int offX, int offY, int width, int height, int color) {
        for(int y = 0; y <= height; y++) {
            setPixel(offX, y + offY, color);
            setPixel(offX + width, y + offY, color);
        }
        for(int x = 0; x <= width; x++) {
            setPixel(x+ offX, offY, color);
            setPixel(x + offX, offY + height, color);
        }
    }
    //maybe add drawFilledRect() if needed
}
