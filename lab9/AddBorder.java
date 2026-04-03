public class AddBorder extends Transformation {
    private final int width;
    private final RGBColor borderColor;

    public AddBorder(int width, RGBColor borderColor) {
        super();
        this.width = width;
        this.borderColor = borderColor;
    }
    /*
     * creates a addborder object which has a width and color associated to it
     */


    @Override
    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {
        int imageW = image.getWidth();
        int imageH = image.getHeight();
        int borderW = this.width;
        if (x < borderW || x >= imageW-borderW || y < borderW || y >= imageH - borderW) {
            return this.borderColor;
    }
    return originalColor;
    }
    /*
     * checks the input pixel to see if it is within the proper bounds to change
     * the border color, it has to be between 0 and the border color for both x and
     * y, and must also be greater than the image width - border width
     */
}
