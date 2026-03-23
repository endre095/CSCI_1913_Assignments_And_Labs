import java.awt.Color; //had to import this to change colors

public class DrawSolar {
    
    public static void main(String[] args) {
        final double screenSize = 1024;
        ShapeDrawer drawer1 = new ShapeDrawer(1024.0,1024.0);
        Color colorSetter = Color.RED;
        Color fillerSetter = Color.YELLOW;
        drawer1.setStroke(colorSetter);

        //Drawing sun
        Point center = new Point(screenSize/2.0, screenSize/2.0);
        Circle sun = new Circle(center, 35.0);
        drawer1.setFill(fillerSetter);
        drawer1.draw(sun);

        //Drawing first planet/ring

        colorSetter = Color.WHITE;
        drawer1.setStroke(colorSetter);

        Circle bigCircle = new Circle(center, 130.0);
        Ring ring1 = new Ring(bigCircle, 2.5);
        drawer1.setFill(fillerSetter);
        drawer1.draw(ring1);

        colorSetter = Color.CYAN;
        drawer1.setStroke(colorSetter);
        fillerSetter = Color.GREEN;

        Point planet1Pos = new Point(screenSize/2 - bigCircle.getRadius(), screenSize/2);
        Circle planet1 = new Circle(planet1Pos, 10.0);
        drawer1.setFill(fillerSetter);
        drawer1.draw(planet1);

        if (drawer1.writeToFile("solar.png")) {
            System.out.println("PRINTED");
        }
        else {
            System.out.println("PRINT NO WORKY");
        }


    }

}
