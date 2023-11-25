package github.com.figure.classes;
import github.com.classes.Points;
import static github.com.constains.Constants.*;

public class Triangle extends Figure {

    public Triangle(Points points) {
        super(points);
    }

    @Override
    public boolean isValid() {

        boolean validation = false;
        if (points.getLength() == AMOUNT_OF_POINTS_TRIANGLE) {

            double firstDifx = points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE);
            double firstDify = points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE);
            double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

            double secondDifx = points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_XCORDINATE);
            double secondDify = points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_YCORDINATE);
            double secondSide = Math.sqrt(Math.pow(secondDifx, 2) + Math.pow(secondDify, 2));

            double thirdDifx = points.getPoint(THIRD_POINT, THIRD_POINT_XCORDINATE) - points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE);
            double thirdDify = points.getPoint(THIRD_POINT, THIRD_POINT_YCORDINATE) - points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE);
            double thirdSide = Math.sqrt(Math.pow(thirdDifx, 2) + Math.pow(thirdDify, 2));
            validation = (firstSide + secondSide > thirdSide) & (firstSide + thirdSide > secondSide) & (secondSide + thirdSide > firstSide);

            if (validation) {
                System.out.println("The figure is valid");
            } else {
                System.out.println("The figure is invalid");
            }
        } else if (points.getLength() > AMOUNT_OF_POINTS_TRIANGLE) {
            System.out.println("The number of coordinates is greater than necessary for the figure");
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");

        }
        return validation;
    }

    @Override
    public void perimeter() {

        double firstDifx = points.getPoint(FIRST_POINT, FOURTH_POINT_XCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE);
        double firstDify = points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE);
        double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

        double secondDifx = points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_XCORDINATE);
        double secondDify = points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_YCORDINATE);
        double secondSide = Math.sqrt(Math.pow(secondDifx, 2) + Math.pow(secondDify, 2));

        double thirdDifx = points.getPoint(THIRD_POINT, THIRD_POINT_XCORDINATE) - points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE);
        double thirdDify = points.getPoint(THIRD_POINT, THIRD_POINT_YCORDINATE) - points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE);
        double thirdSide = Math.sqrt(Math.pow(thirdDifx, 2) + Math.pow(thirdDify, 2));

        double result = firstSide + secondSide + thirdSide;
        System.out.printf("The figure perimeter - %.2f\n", result);
    }

    @Override
    public void square() {

        double firstDifx = points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE);
        double firstDify = points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE);
        double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

        double secondDifx = points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_XCORDINATE);
        double secondDify = points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_YCORDINATE);
        double secondSide = Math.sqrt(Math.pow(secondDifx, 2) + Math.pow(secondDify, 2));

        double thirdDifx = points.getPoint(THIRD_POINT, THIRD_POINT_XCORDINATE) - points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE);
        double thirdDify = points.getPoint(THIRD_POINT, THIRD_POINT_YCORDINATE) - points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE);
        double thirdSide = Math.sqrt(Math.pow(thirdDifx, 2) + Math.pow(thirdDify, 2));

        double poluperimetr = (firstSide + secondSide + thirdSide) * 0.5;
        double result = Math.sqrt(poluperimetr * (poluperimetr - firstSide) * (poluperimetr - secondSide) * (poluperimetr - thirdSide));
        System.out.printf("The figure area - %.2f\n", result);
    }
}
