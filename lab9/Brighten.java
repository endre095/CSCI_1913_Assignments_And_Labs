public class Brighten extends Transformation {
    private final int amount;

    public Brighten(int amount) {
        super();
        this.amount = amount;
    }
    /*
     * creates a brighten object which can be used to brighten an image
     */

    @Override
    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {
        int[] tempColors = {originalColor.getRed(), originalColor.getGreen(), originalColor.getBlue()};
        for (int j = 0; j < tempColors.length; j++) {
            int result = RGBColor.clamp(tempColors[j] + amount);
            tempColors[j] = result;
        }   
        return new RGBColor(tempColors[0], tempColors[1], tempColors[2]);
    }
    /*
     * this transformation puts the original color's rgb vals into an array, then
     * iterates through them and uses the RGBColor's clamp function to set them to
     * the correct value, it then returns the brigtened color
     */
}
