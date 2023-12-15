package github.com.figure.classes;
import github.com.classes.Points;
import static github.com.constains.Constants.*;

public class Triangle extends Figure {

    public Triangle(Points points) {
        super(points);
    }
    private double area;
    private double perimetr;

    @Override
    public boolean isValid() {

        boolean validation = false;
        boolean twoDimensional = points.getLengthCoordinates(FIRST_POINT) == TWO_DIMENS
                && points.getLengthCoordinates(SECOND_POINT) == TWO_DIMENS
                && points.getLengthCoordinates(THIRD_POINT) == TWO_DIMENS;
        boolean threeDimensional = points.getLengthCoordinates(FIRST_POINT) == THREE_DIMENS
                && points.getLengthCoordinates(SECOND_POINT) == THREE_DIMENS
                && points.getLengthCoordinates(THIRD_POINT) == THREE_DIMENS;
        boolean dimensional = twoDimensional || threeDimensional;

        if (points.getLengthPoints() == AMOUNT_OF_POINTS_TRIANGLE && dimensional) {
            double firstSide = 0;
            double secondSide = 0;
            double thirdSide = 0;

            double firstDifx = points.getPoint(FIRST_POINT, XCORDINATE) - points.getPoint(SECOND_POINT, XCORDINATE);
            double firstDify = points.getPoint(FIRST_POINT, YCORDINATE) - points.getPoint(SECOND_POINT, YCORDINATE);
            double secondDifx = points.getPoint(SECOND_POINT, XCORDINATE) - points.getPoint(THIRD_POINT, XCORDINATE);
            double secondDify = points.getPoint(SECOND_POINT, YCORDINATE) - points.getPoint(THIRD_POINT, YCORDINATE);
            double thirdDifx = points.getPoint(THIRD_POINT, XCORDINATE) - points.getPoint(FIRST_POINT, XCORDINATE);
            double thirdDify = points.getPoint(THIRD_POINT, YCORDINATE) - points.getPoint(FIRST_POINT, YCORDINATE);

            if (points.getLengthCoordinates(0) == TWO_DIMENS) {
                firstSide = Math.sqrt(Math.pow(firstDifx, SECOND_DEGREE) + Math.pow(firstDify, SECOND_DEGREE));
                secondSide = Math.sqrt(Math.pow(secondDifx, SECOND_DEGREE) + Math.pow(secondDify, SECOND_DEGREE));
                thirdSide = Math.sqrt(Math.pow(thirdDifx, SECOND_DEGREE) + Math.pow(thirdDify, SECOND_DEGREE));

            } else {
                double firstDifz = points.getPoint(FIRST_POINT, ZCORDINATE) - points.getPoint(SECOND_POINT, ZCORDINATE);
                double secondDifz = points.getPoint(SECOND_POINT, ZCORDINATE) - points.getPoint(THIRD_POINT, ZCORDINATE);
                double thirdDifz = points.getPoint(THIRD_POINT, ZCORDINATE) - points.getPoint(FIRST_POINT, ZCORDINATE);
                firstSide = Math.sqrt(Math.pow(firstDifx, SECOND_DEGREE) + Math.pow(firstDify, SECOND_DEGREE)
                            + Math.pow(firstDifz, SECOND_DEGREE));
                secondSide = Math.sqrt(Math.pow(secondDifx, SECOND_DEGREE) + Math.pow(secondDify, SECOND_DEGREE)
                            + Math.pow(secondDifz, SECOND_DEGREE));
                thirdSide = Math.sqrt(Math.pow(thirdDifx, SECOND_DEGREE) + Math.pow(thirdDify, SECOND_DEGREE)
                            + Math.pow(thirdDifz, SECOND_DEGREE));
            }


            validation = (firstSide + secondSide > thirdSide)
                    & (firstSide + thirdSide > secondSide)
                    & (secondSide + thirdSide > firstSide);

            if (validation) {
                System.out.println("The figure is valid");
            } else {
                System.out.println("The figure is invalid");
            }
        } else if (points.getLengthPoints() > AMOUNT_OF_POINTS_TRIANGLE) {
            System.out.println("The number of coordinates is greater than necessary for the figure");
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");

        }
        return validation;
    }

    @Override
    public void perimeter() {

        double firstSide = 0;
        double secondSide = 0;
        double thirdSide = 0;

        double firstDifx = points.getPoint(FIRST_POINT, XCORDINATE) - points.getPoint(SECOND_POINT, XCORDINATE);
        double firstDify = points.getPoint(FIRST_POINT, YCORDINATE) - points.getPoint(SECOND_POINT, YCORDINATE);
        double secondDifx = points.getPoint(SECOND_POINT, XCORDINATE) - points.getPoint(THIRD_POINT, XCORDINATE);
        double secondDify = points.getPoint(SECOND_POINT, YCORDINATE) - points.getPoint(THIRD_POINT, YCORDINATE);
        double thirdDifx = points.getPoint(THIRD_POINT, XCORDINATE) - points.getPoint(FIRST_POINT, XCORDINATE);
        double thirdDify = points.getPoint(THIRD_POINT, YCORDINATE) - points.getPoint(FIRST_POINT, YCORDINATE);

        if (points.getLengthCoordinates(0) == TWO_DIMENS) {
            firstSide = Math.sqrt(Math.pow(firstDifx, SECOND_DEGREE) + Math.pow(firstDify, SECOND_DEGREE));
            secondSide = Math.sqrt(Math.pow(secondDifx, SECOND_DEGREE) + Math.pow(secondDify, SECOND_DEGREE));
            thirdSide = Math.sqrt(Math.pow(thirdDifx, SECOND_DEGREE) + Math.pow(thirdDify, SECOND_DEGREE));

        } else if (points.getLengthCoordinates(0) == THREE_DIMENS){
            double firstDifz = points.getPoint(FIRST_POINT, ZCORDINATE) - points.getPoint(SECOND_POINT, ZCORDINATE);
            double secondDifz = points.getPoint(SECOND_POINT, ZCORDINATE) - points.getPoint(THIRD_POINT, ZCORDINATE);
            double thirdDifz = points.getPoint(THIRD_POINT, ZCORDINATE) - points.getPoint(FIRST_POINT, ZCORDINATE);
            firstSide = Math.sqrt(Math.pow(firstDifx, SECOND_DEGREE) + Math.pow(firstDify, SECOND_DEGREE)
                    + Math.pow(firstDifz, SECOND_DEGREE));
            secondSide = Math.sqrt(Math.pow(secondDifx, SECOND_DEGREE) + Math.pow(secondDify, SECOND_DEGREE)
                    + Math.pow(secondDifz, SECOND_DEGREE));
            thirdSide = Math.sqrt(Math.pow(thirdDifx, SECOND_DEGREE) + Math.pow(thirdDify, SECOND_DEGREE)
                    + Math.pow(thirdDifz, SECOND_DEGREE));
        }

        double result = firstSide + secondSide + thirdSide;
        perimetr = result;
        System.out.printf("The figure perimeter - %.2f\n", result);
    }

    @Override
    public void square() {
        double firstSide = 0;
        double secondSide = 0;
        double thirdSide = 0;

        double firstDifx = points.getPoint(FIRST_POINT, XCORDINATE) - points.getPoint(SECOND_POINT, XCORDINATE);
        double firstDify = points.getPoint(FIRST_POINT, YCORDINATE) - points.getPoint(SECOND_POINT, YCORDINATE);
        double secondDifx = points.getPoint(SECOND_POINT, XCORDINATE) - points.getPoint(THIRD_POINT, XCORDINATE);
        double secondDify = points.getPoint(SECOND_POINT, YCORDINATE) - points.getPoint(THIRD_POINT, YCORDINATE);
        double thirdDifx = points.getPoint(THIRD_POINT, XCORDINATE) - points.getPoint(FIRST_POINT, XCORDINATE);
        double thirdDify = points.getPoint(THIRD_POINT, YCORDINATE) - points.getPoint(FIRST_POINT, YCORDINATE);

        if (points.getLengthCoordinates(0) == TWO_DIMENS) {
            firstSide = Math.sqrt(Math.pow(firstDifx, SECOND_DEGREE) + Math.pow(firstDify, SECOND_DEGREE));
            secondSide = Math.sqrt(Math.pow(secondDifx, SECOND_DEGREE) + Math.pow(secondDify, SECOND_DEGREE));
            thirdSide = Math.sqrt(Math.pow(thirdDifx, SECOND_DEGREE) + Math.pow(thirdDify, SECOND_DEGREE));

        } else if (points.getLengthCoordinates(0) == THREE_DIMENS){
            double firstDifz = points.getPoint(FIRST_POINT, ZCORDINATE) - points.getPoint(SECOND_POINT, ZCORDINATE);
            double secondDifz = points.getPoint(SECOND_POINT, ZCORDINATE) - points.getPoint(THIRD_POINT, ZCORDINATE);
            double thirdDifz = points.getPoint(THIRD_POINT, ZCORDINATE) - points.getPoint(FIRST_POINT, ZCORDINATE);
            firstSide = Math.sqrt(Math.pow(firstDifx, SECOND_DEGREE) + Math.pow(firstDify, SECOND_DEGREE)
                    + Math.pow(firstDifz, SECOND_DEGREE));
            secondSide = Math.sqrt(Math.pow(secondDifx, SECOND_DEGREE) + Math.pow(secondDify, SECOND_DEGREE)
                    + Math.pow(secondDifz, SECOND_DEGREE));
            thirdSide = Math.sqrt(Math.pow(thirdDifx, SECOND_DEGREE) + Math.pow(thirdDify, SECOND_DEGREE)
                    + Math.pow(thirdDifz, SECOND_DEGREE));
        }

        double poluperimetr = (firstSide + secondSide + thirdSide) * POLU;
        double result = Math.sqrt(poluperimetr * (poluperimetr - firstSide) * (poluperimetr - secondSide) * (poluperimetr - thirdSide));
        area = result;
        System.out.printf("The figure area - %.2f\n", result);
    }

    public double getPerimetr() {
        perimeter();
        return perimetr;
    }

    public double getArea() {
        square();
        return area;
    }
}
