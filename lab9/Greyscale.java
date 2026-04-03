public class Greyscale extends Transformation {
    public Greyscale() {
        super();
    }
    /*
     * creates a greyscale object, no extra parameters
     */

    @Override 
    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {
        int tempRed = originalColor.getRed();
        int tempGreen = originalColor.getGreen();
        int tempBlue = originalColor.getBlue();
        int tempGrey = (tempRed + tempGreen + tempBlue) / 3;
        return new RGBColor(tempGrey, tempGrey, tempGrey);
        }
        /*
         * this transformation simply averages out all the colors in the current
         * location in the image, and then sets the return color to be this average for
         * all three values
         */
    }

