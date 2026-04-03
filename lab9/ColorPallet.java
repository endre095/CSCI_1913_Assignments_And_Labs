public class ColorPallet extends Transformation{
    private final RGBColor[] pallet;

    public ColorPallet(RGBColor[] pallet) {
        super();
        this.pallet = pallet;
    }
    /*
     * creates a colorPallet object which has some array of RGBColors
     */

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
    /*
     * this function creates an array which houses all distances between the colors
     * in the member color array, and the current color specified in the parameters,
     * this then sorts through the array and finds the index of the smallest
     * distance, or closest distance to the original color and returns it
     */
}
    

