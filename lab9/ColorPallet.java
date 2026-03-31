public class ColorPallet extends Transformation{
    private final RGBColor[] pallet;

    public ColorPallet(RGBColor[] pallet) {
        super();
        this.pallet = pallet;
    }

    @Override
    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {
        double[] distances = new double[this.pallet.length];
        int i = 0;
    
        for (RGBColor color : this.pallet) {
            distances[i] = RGBColor.distance(originalColor, color);
            i++;
        }
        int smallestIndex = 0;
        double smallestVal = distances[0];
        for (int j = 0; j < distances.length; j++) {
            if (distances[j] < smallestVal) {
                smallestVal = distances[j];
                smallestIndex = j;
                }
            }
        int tempRed = this.pallet[smallestIndex].getRed();
        int tempGreen = this.pallet[smallestIndex].getGreen();
        int tempBlue = this.pallet[smallestIndex].getBlue();
        return new RGBColor(tempRed, tempGreen, tempBlue);
    }
}
    

