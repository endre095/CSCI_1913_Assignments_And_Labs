public class Brighten extends Transformation {
    private final int amount;

    public Brighten(int amount) {
        super();
        this.amount = amount;
    }

    @Override
    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {
        int[] tempColors = {originalColor.getRed(), originalColor.getGreen(), originalColor.getBlue()};
        for (int num : tempColors) {
            if (num - this.amount < 0) {
                num = 0;
            }
            else if (num + this.amount > 255) {
                num = 255;
            }
            else {
                num += amount;
            }
        }
        return new RGBColor(tempColors[0], tempColors[1], tempColors[2]);
    }
}
