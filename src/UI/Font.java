package UI;

public class Font {
    public static final Font STANDARD = new Font("/fonts/comic.png");

    private Image fontImage;
    private int[] offSets;
    private int[] widths;

    public Font(String path) {
        fontImage = new Image(path);

        offSets = new int[256];
        widths = new int[256];

        int unicode = 0;

        for (int i = 0; i < fontImage.getWidth(); i++) {
            if(fontImage.getPixels()[i] == 0xff0000ff) {
                offSets[unicode] = i;
            }
            if(fontImage.getPixels()[i] == 0xffffff00) {
                widths[unicode] = i - offSets[unicode];
                unicode++;
            }
        }
    }

    //getter & setters
    public Image getFontImage() {
        return fontImage;
    }

    public void setFontImage(Image fontImage) {
        this.fontImage = fontImage;
    }

    public int[] getOffSets() {
        return offSets;
    }

    public void setOffSets(int[] offSets) {
        this.offSets = offSets;
    }

    public int[] getWidths() {
        return widths;
    }

    public void setWidths(int[] widths) {
        this.widths = widths;
    }
}
