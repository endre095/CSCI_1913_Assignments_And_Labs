public class Stamp extends Transformation {
    private final RGBImage toStamp;

    public Stamp(RGBImage toStamp) {
        super();
        this.toStamp = toStamp;
    }

    @Override
    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {
        int stampX = this.toStamp.getWidth();
        int stampY = this.toStamp.getHeight();
        RGBImage currStamp = this.toStamp;
        int redTemp1 = image.getColor(x,y).getRed();
        int greenTemp1 = image.getColor(x, y).getGreen();
        int blueTemp1 = image.getColor(x, y).getBlue();
        int redTemp2 = currStamp.getColor(x, y).getRed();
        int greenTemp2 = currStamp.getColor(x, y).getGreen();
        int blueTemp2 = currStamp.getColor(x, y).getBlue();
        int redFinal = (redTemp1 + redTemp2) / 2;
        int greenFinal = (greenTemp1 + greenTemp2) / 2;
        int blueFinal = (blueTemp1 + blueTemp2) / 2;

        if (x >= 0 && x <= stampX) {
            return new RGBColor(redFinal, greenFinal, blueFinal);
        }
        else if (y >= 0 && y <= stampY) {
            return new RGBColor(redFinal, greenFinal, blueFinal);
        }
        return originalColor;
    }
}
