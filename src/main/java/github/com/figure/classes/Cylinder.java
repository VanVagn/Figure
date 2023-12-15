package github.com.figure.classes;
import github.com.classes.Points;
import static github.com.constains.Constants.*;

public class Cylinder extends Figure {
    private double area;

    public Cylinder(Points points) {
        super(points);

    }

    @Override
    public boolean isValid() {

        boolean threeDimensional = points.getLengthCoordinates(FIRST_POINT) == THREE_DIMENS
                && points.getLengthCoordinates(SECOND_POINT) == THREE_DIMENS
                && points.getLengthCoordinates(THIRD_POINT) == THREE_DIMENS;

        if (points.getLengthPoints() == AMOUNT_OF_POINTS_CYLINDER && threeDimensional) {
            double xCenterFirst = points.getPoint(FIRST_POINT, XCORDINATE);
            double yCenterFirst = points.getPoint(FIRST_POINT, YCORDINATE);
            double zCenterFirst = points.getPoint(FIRST_POINT, ZCORDINATE);

            double xCenterSecond = points.getPoint(SECOND_POINT, XCORDINATE);
            double yCenterSecond = points.getPoint(SECOND_POINT, YCORDINATE);
            double zCenterSecond = points.getPoint(SECOND_POINT, ZCORDINATE);

            double xPointOnCircle = points.getPoint(THIRD_POINT, XCORDINATE);
            double yPointOnCircle = points.getPoint(THIRD_POINT, YCORDINATE);
            double zPointOnCircle = points.getPoint(THIRD_POINT, ZCORDINATE);

            boolean diffFirst = xPointOnCircle - xCenterFirst == 0
                    && yPointOnCircle - yCenterFirst == 0
                    && zPointOnCircle - zCenterFirst == 0;
            boolean diffSecond = xPointOnCircle - xCenterSecond == 0
                    && yPointOnCircle - yCenterSecond == 0
                    && zPointOnCircle - zCenterSecond == 0;
            boolean diffCenters = xCenterSecond - xCenterFirst == 0
                    && yCenterSecond - yCenterFirst == 0
                    && zCenterSecond - zCenterFirst == 0;

            if (diffFirst || diffSecond || diffCenters) {
                System.out.println("The figure is invalid");
                return false;
            }
            System.out.println("The figure is valid. it's a Cylinder");
            return true;

        } else if (points.getLengthPoints() > AMOUNT_OF_POINTS_CYLINDER){
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
        double high = Math.sqrt(Math.pow(firstDifx, SECOND_DEGREE) + Math.pow(firstDify, SECOND_DEGREE) + Math.pow(firstDifz, SECOND_DEGREE));

        double secondDifx = points.getPoint(SECOND_POINT, XCORDINATE) - points.getPoint(THIRD_POINT, XCORDINATE);
        double secondDify = points.getPoint(SECOND_POINT, YCORDINATE) - points.getPoint(THIRD_POINT, YCORDINATE);
        double secondDifz = points.getPoint(SECOND_POINT, ZCORDINATE) - points.getPoint(THIRD_POINT, ZCORDINATE);
        double secondSide = Math.sqrt(Math.pow(secondDifx, SECOND_DEGREE) + Math.pow(secondDify, SECOND_DEGREE) + Math.pow(secondDifz, SECOND_DEGREE));

        double thirdDifx = points.getPoint(THIRD_POINT, XCORDINATE) - points.getPoint(FIRST_POINT, XCORDINATE);
        double thirdDify = points.getPoint(THIRD_POINT, YCORDINATE) - points.getPoint(FIRST_POINT, YCORDINATE);
        double thirdDifz = points.getPoint(THIRD_POINT, ZCORDINATE) - points.getPoint(FIRST_POINT, ZCORDINATE);
        double thirdSide = Math.sqrt(Math.pow(thirdDifx, SECOND_DEGREE) + Math.pow(thirdDify, SECOND_DEGREE) + Math.pow(thirdDifz, SECOND_DEGREE));

        double radiuc = Math.min(secondSide, thirdSide);
        double result = KOEF_CYLINDER * Math.PI * Math.pow(radiuc, SECOND_DEGREE) + KOEF_CYLINDER * Math.PI * radiuc * high;
        area = result;
        System.out.printf("The Cylinder area - %.2f\n", result);
    }

    public String getPerimeter() {
        return ("The Cylinder has no perimeter");
    }

    public double getArea() {
        square();
        return area;
    }
}
