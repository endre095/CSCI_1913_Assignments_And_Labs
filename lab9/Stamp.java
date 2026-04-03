public class Stamp extends Transformation {
    private final RGBImage toStamp;

    public Stamp(RGBImage toStamp) {
        super();
        this.toStamp = toStamp;
    }
    /*
     * this constructor creates the stamp object with the image to be stamped as its
     * parameter
     */

    public RGBColor avgTwoColors(RGBImage one, RGBImage two, int x, int y) {
        RGBColor c1 = one.getColor(x,y);
        RGBColor c2 = two.getColor(x,y);
        int redTemp1 = c1.getRed();
        int greenTemp1 = c1.getGreen();
        int blueTemp1 = c1.getBlue();
        int redTemp2 = c2.getRed();
        int greenTemp2 = c2.getGreen();
        int blueTemp2 = c2.getBlue();
        int redFinal = (redTemp1 + redTemp2) / 2;
        int greenFinal = (greenTemp1 + greenTemp2) / 2;
        int blueFinal = (blueTemp1 + blueTemp2) / 2;
        return new RGBColor(redFinal, greenFinal, blueFinal);
    }
    /*
     * averages two colors RGB values by summing them together and dividing by two
     * for each value in the color, uses the x and y position in the image to
     * determine the colors
     */

    @Override
    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {
        int stampX = this.toStamp.getWidth();
        int stampY = this.toStamp.getHeight();

        if (x < stampX && y < stampY) {
            return avgTwoColors(image, toStamp, x, y);
        }
        return originalColor;
    }
    /*
     * this transformation checks if the point x,y is within the bounds of the stamp
     * image, if it is, it returns the average color between the two images
     */
}
