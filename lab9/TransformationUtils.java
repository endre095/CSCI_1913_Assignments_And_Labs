public class TransformationUtils {
    
    public static void transformMany(Transformation[] transformations, String inputFile, String outputFile) {
        RGBImage currentImage = RGBImageUtil.load(inputFile);
        int imageW = currentImage.getWidth();
        int imageH = currentImage.getHeight();


        for (Transformation T : transformations) {
            for (int i = 0; i < imageW; i++) {
                for (int j = 0; j < imageH; j++) {
                    RGBColor currentColor = currentImage.getColor(i,j);
                    T.doTransform(i, j, currentColor, currentImage);
                }
            }
        }
        RGBImageUtil.saveImage(currentImage, outputFile);
    }
}
