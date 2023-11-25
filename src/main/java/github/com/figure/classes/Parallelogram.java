package github.com.figure.classes;
import github.com.classes.Points;
import github.com.constains.Constants.*;

import static github.com.constains.Constants.*;

public class Parallelogram extends Figure {

    public Parallelogram(Points points) {
        super(points);
    }

    @Override
    public boolean isValid() {

        boolean validation = false;
        if (points.getLength() == AMOUNT_OF_POINTS_PARALLELOGRAM) {

            double firstDifx = points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE);
            double firstDify = points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE);
            double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

            double secondDifx = points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_XCORDINATE);
            double secondDify = points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_YCORDINATE);
            double secondSide = Math.sqrt(Math.pow(secondDifx, 2) + Math.pow(secondDify, 2));

            double thirdDifx = points.getPoint(THIRD_POINT, THIRD_POINT_XCORDINATE) - points.getPoint(FOURTH_POINT, FOURTH_POINT_XCORDINATE);
            double thirdDify = points.getPoint(THIRD_POINT, THIRD_POINT_YCORDINATE) - points.getPoint(FOURTH_POINT, FOURTH_POINT_YCORDINATE);
            double thirdSide = Math.sqrt(Math.pow(thirdDifx, 2) + Math.pow(thirdDify, 2));

            double fourthDifx = points.getPoint(FOURTH_POINT, FOURTH_POINT_XCORDINATE) - points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE);
            double fourthDify = points.getPoint(FOURTH_POINT, FOURTH_POINT_YCORDINATE) - points.getPoint(FIRST_POINT, SECOND_POINT_YCORDINATE);
            double fourthSide = Math.sqrt(Math.pow(fourthDifx, 2) + Math.pow(fourthDify, 2));

            double firstDiagonalDifx = points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_XCORDINATE);
            double firstDiagonalDify = points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_YCORDINATE);
            double firstDiagonal = Math.sqrt(Math.pow(firstDiagonalDifx, 2) + Math.pow(firstDiagonalDify, 2));

            double secondDiagonalDifx = points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE) - points.getPoint(FOURTH_POINT, FOURTH_POINT_XCORDINATE);
            double secondDiagonalDify = points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE) - points.getPoint(FOURTH_POINT, FOURTH_POINT_YCORDINATE);
            double secondDiagonal = Math.sqrt(Math.pow(secondDiagonalDifx, 2) + Math.pow(secondDiagonalDify, 2));

            validation = (firstSide == thirdSide) & (secondSide == fourthSide) & (firstSide != secondSide) & (firstDiagonal != secondDiagonal);

            if (validation) {
                System.out.println("The figure is valid");
            } else {
                System.out.println("The figure is invalid");
            }
        } else if (points.getLength() > AMOUNT_OF_POINTS_PARALLELOGRAM) {
            System.out.println("The number of coordinates is greater than necessary for the figure");
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");

        }
        return validation;
    }

    @Override
    public void square() {

        double firstDifx = points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE);
        double firstDify = points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE);
        double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

        double firstDiagonalDifx = points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_XCORDINATE);
        double firstDiagonalDify = points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_YCORDINATE);
        double firstDiagonal = Math.sqrt(Math.pow(firstDiagonalDifx, 2) + Math.pow(firstDiagonalDify, 2));

        double secondDiagonalDifx = points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE) - points.getPoint(FOURTH_POINT, FOURTH_POINT_XCORDINATE);
        double secondDiagonalDify = points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE) - points.getPoint(FOURTH_POINT, FOURTH_POINT_YCORDINATE);
        double secondDiagonal = Math.sqrt(Math.pow(secondDiagonalDifx, 2) + Math.pow(secondDiagonalDify, 2));

        double secondSide = 0.5 * firstDiagonal;
        double thirdSide = 0.5 * secondDiagonal;

        double cos = Math.pow(secondSide, 2) + Math.pow(thirdSide, 2) - Math.pow(firstSide, 2);
        cos = cos / (2 * secondSide * thirdSide);
        double ugol =  Math.acos(cos);

        double result = 0.5 * firstDiagonal * secondDiagonal * Math.sin(ugol);
        System.out.printf("The figure area - %.2f\n", result);
    }

    @Override
    public void perimeter() {

        double firstDifx = points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE);
        double firstDify = points.getPoint(FIRST_POINT, FOURTH_POINT_YCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE);
        double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

        double secondDifx = points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_XCORDINATE);
        double secondDify = points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_YCORDINATE);
        double secondSide = Math.sqrt(Math.pow(secondDifx, 2) + Math.pow(secondDify, 2));

        double result = (firstSide + secondSide) * 2;
        System.out.printf("The figure perimeter - %.2f\n", result);
    }
}
