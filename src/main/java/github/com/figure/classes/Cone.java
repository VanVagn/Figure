package github.com.figure.classes;
import github.com.classes.Points;
import github.com.constains.Constants;

import static github.com.constains.Constants.*;

public class Cone extends Figure {
    private double area;

    public Cone(Points points) {
        super(points);
    }

    // threeDimensional проверяет, что координаты трехмерные
    @Override
    public boolean isValid() {

        boolean threeDimensional = points.getLengthCoordinates(FIRST_POINT) == THREE_DIMENS
                && points.getLengthCoordinates(SECOND_POINT) == THREE_DIMENS
                && points.getLengthCoordinates(THIRD_POINT) == THREE_DIMENS;

        if (points.getLengthPoints() == AMOUNT_OF_POINTS_CONE && threeDimensional) {

            double xCenter = points.getPoint(0, FIRST_POINT);
            double yCenter = points.getPoint(0, SECOND_POINT);
            double zCenter = points.getPoint(0, THIRD_POINT);

            for (int indexPoint = 1; indexPoint < AMOUNT_OF_POINTS_CONE; indexPoint++) {
                double x = points.getPoint(indexPoint, XCORDINATE);
                double y = points.getPoint(indexPoint, YCORDINATE);
                double z = points.getPoint(indexPoint, ZCORDINATE);
                if (x - xCenter == 0 && y - yCenter == 0 && z - zCenter == 0) {
                    System.out.println("The Cone is valid. it's a Cone");
                    return false;
                }
            }
            System.out.println("The figure is invalid");
            return true;
        } else if (points.getLengthPoints() > AMOUNT_OF_POINTS_CONE){
            System.out.println("The number of coordinates is greater than necessary for the figure");
            return false;
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");
            return false;
        }
    }

    @Override
    public void square() {

        double firstDifx = points.getPoint(FIRST_POINT, XCORDINATE) - points.getPoint(SECOND_POINT, XCORDINATE);
        double firstDify = points.getPoint(FIRST_POINT, YCORDINATE) - points.getPoint(SECOND_POINT, YCORDINATE);
        double firstDifz = points.getPoint(FIRST_POINT, ZCORDINATE) - points.getPoint(SECOND_POINT, ZCORDINATE);
        double radiuc = Math.sqrt(Math.pow(firstDifx, SECOND_DEGREE) + Math.pow(firstDify, SECOND_DEGREE) + Math.pow(firstDifz, SECOND_DEGREE));

        double secondDifx = points.getPoint(SECOND_POINT, XCORDINATE) - points.getPoint(THIRD_POINT, XCORDINATE);
        double secondDify = points.getPoint(SECOND_POINT, YCORDINATE) - points.getPoint(THIRD_POINT, YCORDINATE);
        double secondDifz = points.getPoint(SECOND_POINT, ZCORDINATE) - points.getPoint(THIRD_POINT, ZCORDINATE);
        double generatrix = Math.sqrt(Math.pow(secondDifx, SECOND_DEGREE) + Math.pow(secondDify, SECOND_DEGREE) + Math.pow(secondDifz, SECOND_DEGREE));

        double result = PI * Math.pow(radiuc, SECOND_DEGREE) + PI * radiuc * generatrix;
        area = result;
        System.out.printf("The Cone area - %.2f\n", result);
    }

    public String getPerimeter() {
        return ("The Cone has no perimeter");
    }

    public double getArea() {
        square();
        return area;
    }
}
