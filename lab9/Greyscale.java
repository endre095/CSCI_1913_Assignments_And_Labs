public class Greyscale extends Transformation {
    public Greyscale() {
        super();
    }

    @Override 
    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {
        int tempRed = originalColor.getRed();
        int tempGreen = originalColor.getGreen();
        int tempBlue = originalColor.getBlue();
        int tempGrey = (tempRed + tempGreen + tempBlue) / 3;
        return new RGBColor(tempGrey, tempGrey, tempGrey);
        }
    }

