package github.com.figure.classes;
import github.com.classes.Points;

import static github.com.constains.Constants.*;

public class Polygon extends Figure {

    public Polygon(Points points) {
        super(points);
    }

    @Override
    public boolean isValid() {

        boolean validation = true;
        int size = points.getLength();
        double[] sides = new double[size];
        double Difx;
        double Dify;
        for (int i = 0; i < size; i++) {
            Difx = points.getPoint(0, 0) - points.getPoint(1, 0);
            Dify = points.getPoint(0, 1) - points.getPoint(1, 1);
            sides[i] = Math.sqrt(Math.pow(Difx, 2) + Math.pow(Dify, 2));
        }
        for (int i = 0; i < size - 1; i++) {
            if (sides[i] != sides[i + 1]) {
                return false;
            }
        }
        return  validation;
    }

    @Override
    public void square() {
        double firstDifx = points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE);
        double firstDify = points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE);
        double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

        double ctg = Math.sin(ONE_HUNDRED_EIGHTY_DEGREES / points.getLength()) / Math.cos(ONE_HUNDRED_EIGHTY_DEGREES / points.getLength());
        double result = (points.getLength() * Math.pow(firstSide, 2)) / 4 * ctg;
        System.out.printf("The figure area - %.2f\n", result);
    }

    @Override
    public void perimeter() {

        double firstDifx = points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE);
        double firstDify = points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE);
        double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

        double result = points.getLength() * firstSide;
        System.out.printf("The figure perimeter - %.2f\n", result);
    }
}
