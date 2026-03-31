public class AddBorder extends Transformation {
    private final int width;
    private final RGBColor borderColor;

    public AddBorder(int width, RGBColor borderColor) {
        super();
        this.width = width;
        this.borderColor = borderColor;
    }
    @Override
    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {
        int imageW = image.getWidth();
        int imageH = image.getHeight();
        int borderW = this.width;
        RGBColor tempColor = new RGBColor(this.borderColor.getRed(), this.borderColor.getGreen(), this.borderColor.getBlue());
        if ((x >= 0 && x <= borderW) || (x <= imageW && x > imageW-borderW)) {
            return tempColor;
        }
        else if ((y >= 0 && y <= borderW) || (y <= imageH && y >= imageH-borderW)) {
            return tempColor;
        }
        return originalColor;
    }
}
