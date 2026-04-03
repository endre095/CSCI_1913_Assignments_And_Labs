public class TransformationUtils {
    
    public static void transformMany(Transformation[] transformations, String inputFile, String outputFile) {
        RGBImage currentImage = RGBImageUtil.load(inputFile);
        int imageW = currentImage.getWidth();
        int imageH = currentImage.getHeight();


        for (Transformation T : transformations) {
            for (int i = 0; i < imageW; i++) {
                for (int j = 0; j < imageH; j++) {
                    RGBColor currentColor = currentImage.getColor(i,j);
                    RGBColor tempColor = T.doTransform(i, j, currentColor, currentImage);
                    currentImage.setColor(i, j, tempColor);
                }
            }
        }
        RGBImageUtil.saveImage(currentImage, outputFile);
    }
    /*
     * this function first grabs the image from the specified folder in RGBImage,
     * then iterates through each transfomation object, and uses its version of the
     * doTransform to transform the image color to the correct color according to
     * each transformation, after it saves the image to the correct filepath
     * specified in RGBImage
     */
}
