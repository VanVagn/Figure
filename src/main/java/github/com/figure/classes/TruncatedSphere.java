package github.com.figure.classes;
import github.com.classes.Points;

import static github.com.constains.Constants.*;

public class TruncatedSphere extends Figure {
    private double area;

    public TruncatedSphere(Points points) {
        super(points);
    }

    @Override
    public boolean isValid() {
        boolean validation = false;
        boolean threeDimensional = points.getLengthCoordinates(FIRST_POINT) == THREE_DIMENS
                && points.getLengthCoordinates(SECOND_POINT) == THREE_DIMENS;

        if (points.getLengthPoints() == AMOUNT_OF_POINTS_TRUNCATED_SPHERE && threeDimensional) {
            if (radius() > 0) {
                System.out.println("The figure is valid. it's a Truncated_Sphere");
                validation = true;
            } else {
                System.out.println("The figure is invalid");
            }
        } else if (points.getLengthPoints() > AMOUNT_OF_POINTS_TRUNCATED_SPHERE){
            System.out.println("The number of coordinates is greater than necessary for the figure");
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");

        }
        return validation;
    }

    @Override
    public void square() {

        double high = radius() - Math.abs(points.getPoint(THIRD_POINT, ZCORDINATE));
        double result = KOEF_SPHERE * PI * Math.pow(radius(), SECOND_DEGREE)
                - KOEF_SEGMENT * PI * radius() * high + PI * Math.pow(radius(), SECOND_DEGREE);
        area = result;
        System.out.printf("The Truncated_Sphere area - %.2f\n", result);
    }

    public double radius() {
        double xcordinate = points.getPoint(FIRST_POINT, XCORDINATE) - points.getPoint(SECOND_POINT, XCORDINATE);
        double ycordinate = points.getPoint(FIRST_POINT, YCORDINATE) - points.getPoint(SECOND_POINT, YCORDINATE);
        double zcordinate = points.getPoint(FIRST_POINT, ZCORDINATE) - points.getPoint(SECOND_POINT, ZCORDINATE);
        double help = Math.pow(xcordinate, SECOND_DEGREE) + Math.pow(ycordinate, SECOND_DEGREE)
                + Math.pow(zcordinate, SECOND_DEGREE);
        return Math.sqrt(help);
    }

    public String getPerimeter() {
        return ("The Truncated_Sphere has no perimeter");
    }

    public double getArea() {
        square();
        return area;
    }
}
