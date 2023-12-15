package github.com.figure.classes;

import github.com.classes.Points;

import static github.com.constains.Constants.*;

public class Sphere extends Figure {

    private double area;

    public Sphere(Points points) {
        super(points);
    }

    public double radius() {
        double xcordinate = points.getPoint(FIRST_POINT, XCORDINATE) - points.getPoint(SECOND_POINT, XCORDINATE);
        double ycordinate = points.getPoint(FIRST_POINT, YCORDINATE) - points.getPoint(SECOND_POINT, YCORDINATE);
        double zcordinate = points.getPoint(FIRST_POINT, ZCORDINATE) - points.getPoint(SECOND_POINT, ZCORDINATE);
        double help = Math.pow(xcordinate, SECOND_DEGREE) + Math.pow(ycordinate, SECOND_DEGREE)
                + Math.pow(zcordinate, SECOND_DEGREE);
        return Math.sqrt(help);
    }

    @Override
    public boolean isValid() {
        boolean validation = false;
        boolean threeDimensional = points.getLengthCoordinates(FIRST_POINT) == THREE_DIMENS
                && points.getLengthCoordinates(SECOND_POINT) == THREE_DIMENS;

        if (points.getLengthPoints() == AMOUNT_OF_POINTS_SPHERE && threeDimensional) {
            if (radius() > 0) {
                System.out.println("The figure is valid. it's a Sphere");
                validation = true;
            } else {
                System.out.println("The figure is invalid");
            }
        } else if (points.getLengthPoints() > AMOUNT_OF_POINTS_SPHERE){
            System.out.println("The number of coordinates is greater than necessary for the figure");
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");

        }
        return validation;
    }

    @Override
    public void square() {
        double result = KOEF_SPHERE * Math.PI * Math.pow(radius(), SECOND_DEGREE);
        area = result;
        System.out.printf("The Sphere area - %.2f\n", result);
    }

    public String getPerimeter() {
        return ("The Sphere has no perimeter");
    }

    public double getArea() {
        square();
        return area;
    }
}
