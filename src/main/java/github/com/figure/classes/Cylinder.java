package github.com.figure.classes;
import github.com.classes.Points;

public class Cylinder extends Figure {

    public Cylinder(Points points) {
        super(points);
    }

    @Override
    public boolean isValid() {

        if (points.getLength() == 3) {
            for (int i = 0; i < 3; i++) {
                double x = points.getPoint(i, 0);
                double y = points.getPoint(i, 1);
                double z = points.getPoint(i, 2);
                if (Math.pow(x, 2) + Math.pow(y, 2) != Math.pow(z, 2)) {
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
        double high = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2) + Math.pow(firstDifz, 2));

        double secondDifx = points.getPoint(1, 0) - points.getPoint(2, 0);
        double secondDify = points.getPoint(1, 1) - points.getPoint(2, 1);
        double secondDifz = points.getPoint(1, 2) - points.getPoint(2, 2);
        double secondSide = Math.sqrt(Math.pow(secondDifx, 2) + Math.pow(secondDify, 2) + Math.pow(secondDifz, 2));

        double thirdDifx = points.getPoint(2, 0) - points.getPoint(0, 0);
        double thirdDify = points.getPoint(2, 1) - points.getPoint(0, 1);
        double thirdDifz = points.getPoint(2, 2) - points.getPoint(0, 2);
        double thirdSide = Math.sqrt(Math.pow(thirdDifx, 2) + Math.pow(thirdDify, 2) + Math.pow(thirdDifz, 2));

        double radiuc = Math.min(secondSide, thirdSide);
        double result = 2 * Math.PI * Math.pow(radiuc, 2) + 2 * Math.PI * radiuc * high;
        System.out.printf("The figure area - %.2f\n", result);
    }

}
