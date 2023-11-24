package classes.Extend;
import classes.Constants;
import classes.Figure;
import classes.Points;

public class Square extends Figure implements Constants {

    public Square(Points points) {
        super(points);
    }

    @Override
    public boolean isValid() {

        boolean validation = false;
        if (points.getLength() == AMOUNT_OF_POINTS_SQUARE) {

            double firstDifx = points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE);
            double firstDify = points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE);
            double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

            double secondDifx = points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_XCORDINATE);
            double secondDify = points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_YCORDINATE);
            double secondSide = Math.sqrt(Math.pow(secondDifx, 2) + Math.pow(secondDify, 2));

            double thirdDifx = points.getPoint(THIRD_POINT, FIRST_POINT_XCORDINATE) - points.getPoint(FOURTH_POINT, FOURTH_POINT_XCORDINATE);
            double thirdDify = points.getPoint(THIRD_POINT, THIRD_POINT_YCORDINATE) - points.getPoint(FOURTH_POINT, FOURTH_POINT_YCORDINATE);
            double thirdSide = Math.sqrt(Math.pow(thirdDifx, 2) + Math.pow(thirdDify, 2));

            double fourthDifx = points.getPoint(FOURTH_POINT, FOURTH_POINT_XCORDINATE) - points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE);
            double fourthDify = points.getPoint(FOURTH_POINT, FOURTH_POINT_YCORDINATE) - points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE);
            double fourthSide = Math.sqrt(Math.pow(fourthDifx, 2) + Math.pow(fourthDify, 2));

            double firstDiagonal = Math.sqrt(Math.pow(firstSide, 2) + Math.pow(secondSide, 2));
            double secondDiagonal = Math.sqrt(Math.pow(thirdSide, 2) + Math.pow(fourthSide, 2));
            validation = (firstSide == secondSide) & (secondSide == thirdSide) & (thirdSide == fourthSide) & (firstDiagonal == secondDiagonal);
            if (validation) {
                System.out.println("The figure is valid");
            } else {
                System.out.println("The figure is invalid");
            }
        } else if (points.getLength() > AMOUNT_OF_POINTS_SQUARE) {
            System.out.println("The number of coordinates is greater than necessary for the figure");
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");

        }
        return validation;
    }

    @Override
    public void square() {
        double firstDifx = points.getPoint(0, 0) - points.getPoint(1, 0);
        double firstDify = points.getPoint(0, 1) - points.getPoint(1, 1);
        double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));
        double result = Math.pow(firstSide, 2);
        System.out.printf("The figure area - %.2f\n", result);
    }

    @Override
    public void perimeter() {
        double firstDifx = points.getPoint(0, 0) - points.getPoint(1, 0);
        double firstDify = points.getPoint(0, 1) - points.getPoint(1, 1);
        double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));
        double result = firstSide * 4;
        System.out.printf("The figure perimeter - %.2f\n", result);
    }
}
