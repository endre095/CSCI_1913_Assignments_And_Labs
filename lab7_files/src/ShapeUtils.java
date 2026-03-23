

public class ShapeUtils {
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2.0) + Math.pow((p2.getY() - p1.getY()), 2.0));
    }
    /*
    returns the distance between two points by using the pythagorean theorem
     */
    public static Point getCenter(Point[] points) {
        Point returnPoint;
        if (points.length == 0) {
            returnPoint = new Point(0.0,0.0);
            return returnPoint;
        }
        else {
            double x_total = 0;
            double y_total = 0;
            double len = (double) points.length;
            
            for (int i = 0; i < len; i++) {
                x_total += points[i].getX();
                y_total += points[i].getY();
            }
            returnPoint = new Point(x_total/len, y_total/len);
            return returnPoint;
        }
    }
    /*
    creates a point object, and either returns a null point with coordiantes (0.0) of arrary empty,
    otherwise, goes through point[] and sums x/y then divides by total elements and returns a new
    point with these averages.
     */

    public static double getArea(Circle circ) {
        return Circle.getArea(circ);
    }
    /*
    returns circle area of a non-instance 
     */

    public static double getArea(Ring ring) {
        return ring.getArea();
    }
    /*
    returns area of a ring object
     */

    public static boolean isIn(Circle circle, Point point) {
        if (distance(circle.getCenter(), point) <= circle.getRadius()) {
            return true;
        }
        else {
            return false;
        }
    }
    /*
    returns true if the distance between the center of the circle and the points are less than
    or equal to the radius of the circle, else returns false.
    */
}
