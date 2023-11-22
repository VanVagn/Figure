package classes.Extend;

import classes.Figure;
import classes.Points;

public class Cone extends Figure {
    public Cone(Points points) {
        super(points);
    }

    @Override
    public boolean isValid() {

        if (points.getLength() == 3) {
            for (int i = 0; i < 3; i++) {
                double x = points.getPoint(i, 0);
                double y = points.getPoint(i, 1);
                double z = points.getPoint(i, 2);
                if (Math.pow(x, 2) + Math.pow(y, 2) - Math.pow(z, 2) == 0) {
                    System.out.println("The figure is valid");
                    return false;
                }
            }
            System.out.println("The figure is invalid");
            return true;
        } else if (points.getLength() > 3){
            System.out.println("The number of coordinates is greater than necessary for the figure");
            return false;
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");
            return false;
        }
    }

    @Override
    public void square() {

        double firstDifx = points.getPoint(0, 0) - points.getPoint(1, 0);
        double firstDify = points.getPoint(0, 1) - points.getPoint(1, 1);
        double firstDifz = points.getPoint(0, 2) - points.getPoint(1, 2);
        double radiuc = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2) + Math.pow(firstDifz, 2));

        double secondDifx = points.getPoint(1, 0) - points.getPoint(2, 0);
        double secondDify = points.getPoint(1, 1) - points.getPoint(2, 1);
        double secondDifz = points.getPoint(1, 2) - points.getPoint(2, 2);
        double generatrix = Math.sqrt(Math.pow(secondDifx, 2) + Math.pow(secondDify, 2) + Math.pow(secondDifz, 2));

        double result = Math.PI * Math.pow(radiuc, 2) + Math.PI * radiuc * generatrix;
        System.out.printf("The figure area - %.2f\n", result);
    }

    @Override
    public void perimeter() {
        System.out.println("The figure has no perimeter");
    }
}
