package github.com.figure.classes;
import github.com.classes.Points;
import github.com.constains.Constants.*;

import static github.com.constains.Constants.*;

public class Parallelogram extends Figure {

    private double area;
    private double perimetr;

    public Parallelogram(Points points) {
        super(points);
    }

    @Override
    public boolean isValid() {

        boolean validation = false;
        boolean twoDimensional = points.getLengthCoordinates(FIRST_POINT) == TWO_DIMENS
                && points.getLengthCoordinates(SECOND_POINT) == TWO_DIMENS
                && points.getLengthCoordinates(THIRD_POINT) == TWO_DIMENS
                && points.getLengthCoordinates(FOURTH_POINT) == TWO_DIMENS;
        boolean threeDimensional = points.getLengthCoordinates(FIRST_POINT) == THREE_DIMENS
                && points.getLengthCoordinates(SECOND_POINT) == THREE_DIMENS
                && points.getLengthCoordinates(THIRD_POINT) == THREE_DIMENS
                && points.getLengthCoordinates(FOURTH_POINT) == THREE_DIMENS;

        boolean dimensional = twoDimensional || threeDimensional;

        double firstSide = 0;
        double secondSide = 0;
        double thirdSide = 0;
        double fourthSide = 0;
        double firstDiagonal = 0;
        double secondDiagonal = 0;

        double firstDifx = points.getPoint(FIRST_POINT, XCORDINATE) - points.getPoint(SECOND_POINT, XCORDINATE);
        double firstDify = points.getPoint(FIRST_POINT, YCORDINATE) - points.getPoint(SECOND_POINT, YCORDINATE);

        double secondDifx = points.getPoint(SECOND_POINT, XCORDINATE) - points.getPoint(THIRD_POINT, XCORDINATE);
        double secondDify = points.getPoint(SECOND_POINT, YCORDINATE) - points.getPoint(THIRD_POINT, YCORDINATE);

        double thirdDifx = points.getPoint(THIRD_POINT, XCORDINATE) - points.getPoint(FOURTH_POINT, XCORDINATE);
        double thirdDify = points.getPoint(THIRD_POINT, YCORDINATE) - points.getPoint(FOURTH_POINT, YCORDINATE);

        double fourthDifx = points.getPoint(FOURTH_POINT, XCORDINATE) - points.getPoint(FIRST_POINT, XCORDINATE);
        double fourthDify = points.getPoint(FOURTH_POINT, YCORDINATE) - points.getPoint(FIRST_POINT, YCORDINATE);

        double firstDiagonalDifx = points.getPoint(FIRST_POINT, XCORDINATE) - points.getPoint(THIRD_POINT, XCORDINATE);
        double firstDiagonalDify = points.getPoint(FIRST_POINT, YCORDINATE) - points.getPoint(THIRD_POINT, YCORDINATE);

        double secondDiagonalDifx = points.getPoint(SECOND_POINT, XCORDINATE) - points.getPoint(FOURTH_POINT, XCORDINATE);
        double secondDiagonalDify = points.getPoint(SECOND_POINT, YCORDINATE) - points.getPoint(FOURTH_POINT, YCORDINATE);

        if (points.getLengthPoints() == AMOUNT_OF_POINTS_PARALLELOGRAM && dimensional) {
            if (points.getLengthCoordinates(0) == TWO_DIMENS)  {
                firstSide = Math.sqrt(Math.pow(firstDifx, SECOND_DEGREE) + Math.pow(firstDify, SECOND_DEGREE));
                secondSide = Math.sqrt(Math.pow(secondDifx, SECOND_DEGREE) + Math.pow(secondDify, SECOND_DEGREE));
                thirdSide = Math.sqrt(Math.pow(thirdDifx, SECOND_DEGREE) + Math.pow(thirdDify, SECOND_DEGREE));
                fourthSide = Math.sqrt(Math.pow(fourthDifx, SECOND_DEGREE) + Math.pow(fourthDify, SECOND_DEGREE));
                firstDiagonal = Math.sqrt(Math.pow(firstDiagonalDifx, SECOND_DEGREE)
                        + Math.pow(firstDiagonalDify, SECOND_DEGREE));
                secondDiagonal = Math.sqrt(Math.pow(secondDiagonalDifx, SECOND_DEGREE)
                        + Math.pow(secondDiagonalDify, SECOND_DEGREE));

            } else {
                double firstDifz = points.getPoint(FIRST_POINT, ZCORDINATE) - points.getPoint(SECOND_POINT, ZCORDINATE);
                double secondDifz = points.getPoint(SECOND_POINT, ZCORDINATE) - points.getPoint(THIRD_POINT, ZCORDINATE);
                double thirdDifz = points.getPoint(THIRD_POINT, ZCORDINATE) - points.getPoint(FOURTH_POINT, ZCORDINATE);
                double fourthDifz = points.getPoint(FOURTH_POINT, ZCORDINATE) - points.getPoint(FIRST_POINT, ZCORDINATE);
                double firstDiagonalDifz = points.getPoint(FIRST_POINT,ZCORDINATE
                            + points.getPoint(THIRD_POINT, ZCORDINATE));
                double secondDiagonalDifz = points.getPoint(SECOND_POINT,ZCORDINATE
                        + points.getPoint(FOURTH_POINT, ZCORDINATE));

                firstSide = Math.sqrt(Math.pow(firstDifx, SECOND_DEGREE) + Math.pow(firstDify, SECOND_DEGREE)
                            + Math.pow(firstDifz, SECOND_DEGREE));
                secondSide = Math.sqrt(Math.pow(secondDifx, SECOND_DEGREE) + Math.pow(secondDify, SECOND_DEGREE)
                            + Math.pow(secondDifz, SECOND_DEGREE));
                thirdSide = Math.sqrt(Math.pow(thirdDifx, SECOND_DEGREE) + Math.pow(thirdDify, SECOND_DEGREE)
                            + Math.pow(thirdDifz, SECOND_DEGREE));
                fourthSide = Math.sqrt(Math.pow(fourthDifx, SECOND_DEGREE) + Math.pow(fourthDify, SECOND_DEGREE)
                            + Math.pow(fourthDifz, SECOND_DEGREE));
                firstDiagonal = Math.sqrt(Math.pow(firstDiagonalDifx, SECOND_DEGREE)
                            + Math.pow(firstDiagonalDify, SECOND_DEGREE)
                            + Math.pow(firstDiagonalDifz, SECOND_DEGREE));
                secondDiagonal = Math.sqrt(Math.pow(secondDiagonalDifx, SECOND_DEGREE)
                        + Math.pow(secondDiagonalDify, SECOND_DEGREE)
                        + Math.pow(secondDiagonalDifz, SECOND_DEGREE));

            }

            validation = (firstSide == thirdSide)
                    & (secondSide == fourthSide)
                    & (firstSide != secondSide)
                    & (firstDiagonal != secondDiagonal);

            if (validation) {
                System.out.println("The figure is valid");
            } else {
                System.out.println("The figure is invalid");
            }
        } else if (points.getLengthPoints() > AMOUNT_OF_POINTS_PARALLELOGRAM) {
            System.out.println("The number of coordinates is greater than necessary for the figure");
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");

        }
        return validation;
    }

    @Override
    public void square() {
        double result = 0;
        double firstSide = 0;
        double firstDiagonal = 0;
        double secondDiagonal = 0;

        double firstDifx = points.getPoint(FIRST_POINT, XCORDINATE) - points.getPoint(SECOND_POINT, XCORDINATE);
        double firstDify = points.getPoint(FIRST_POINT, YCORDINATE) - points.getPoint(SECOND_POINT, YCORDINATE);
        double firstDiagonalDifx = points.getPoint(FIRST_POINT, XCORDINATE) - points.getPoint(THIRD_POINT, XCORDINATE);
        double firstDiagonalDify = points.getPoint(FIRST_POINT, YCORDINATE) - points.getPoint(THIRD_POINT, YCORDINATE);
        double secondDiagonalDifx = points.getPoint(SECOND_POINT, XCORDINATE) - points.getPoint(FOURTH_POINT, XCORDINATE);
        double secondDiagonalDify = points.getPoint(SECOND_POINT, YCORDINATE) - points.getPoint(FOURTH_POINT, YCORDINATE);

        if (points.getLengthCoordinates(0) == TWO_DIMENS) {
            firstSide = Math.sqrt(Math.pow(firstDifx, SECOND_DEGREE) + Math.pow(firstDify, SECOND_DEGREE));
            firstDiagonal = Math.sqrt(Math.pow(firstDiagonalDifx, SECOND_DEGREE) + Math.pow(firstDiagonalDify, SECOND_DEGREE));
            secondDiagonal = Math.sqrt(Math.pow(secondDiagonalDifx, SECOND_DEGREE) + Math.pow(secondDiagonalDify, SECOND_DEGREE));

        } else if (points.getLengthCoordinates(0) == THREE_DIMENS) {
            double firstDifz = points.getPoint(FIRST_POINT, ZCORDINATE) - points.getPoint(SECOND_POINT, ZCORDINATE);
            double firstDiagonalDifz = points.getPoint(FIRST_POINT, ZCORDINATE) - points.getPoint(THIRD_POINT, ZCORDINATE);
            double secondDiagonalDifz = points.getPoint(SECOND_POINT, ZCORDINATE) - points.getPoint(FOURTH_POINT, ZCORDINATE);

            firstSide = Math.sqrt(Math.pow(firstDifx, SECOND_DEGREE) + Math.pow(firstDify, SECOND_DEGREE))
                    + Math.pow(firstDifz, SECOND_DEGREE);
            firstDiagonal = Math.sqrt(Math.pow(firstDiagonalDifx, SECOND_DEGREE) + Math.pow(firstDiagonalDify, SECOND_DEGREE)
                    + Math.pow(firstDiagonalDifz, SECOND_DEGREE));
            secondDiagonal = Math.sqrt(Math.pow(secondDiagonalDifx, SECOND_DEGREE) + Math.pow(secondDiagonalDify, SECOND_DEGREE)
                    + Math.pow(secondDiagonalDifz, SECOND_DEGREE));

        }

        // теорема косинусов
        // находим полудиагонали, которые являются сторонами треугольника
        // ищем угол, чтобы воспользоваться формулой через полупроизведение диагоналей * на синус
        double secondSide = POLU * firstDiagonal;
        double thirdSide = POLU * secondDiagonal;

        if (secondSide != 0 && thirdSide != 0) {
            double cos = Math.pow(secondSide, SECOND_DEGREE) + Math.pow(thirdSide, SECOND_DEGREE) - Math.pow(firstSide, SECOND_DEGREE);
            cos = cos / (KOEF_THEOREM_COS * secondSide * thirdSide);
            double ugol =  Math.acos(cos);
            result = POLU * firstDiagonal * secondDiagonal * Math.sin(ugol);
        }

        area = result;
        System.out.printf("The figure area - %.2f\n", result);
    }

    @Override
    public void perimeter() {

        double firstSide = 0;
        double secondSide = 0;

        double firstDifx = points.getPoint(FIRST_POINT, XCORDINATE) - points.getPoint(SECOND_POINT, XCORDINATE);
        double firstDify = points.getPoint(FIRST_POINT, YCORDINATE) - points.getPoint(SECOND_POINT, YCORDINATE);
        double secondDifx = points.getPoint(SECOND_POINT, XCORDINATE) - points.getPoint(THIRD_POINT, XCORDINATE);
        double secondDify = points.getPoint(SECOND_POINT, YCORDINATE) - points.getPoint(THIRD_POINT, YCORDINATE);

        if (points.getLengthCoordinates(0) == TWO_DIMENS) {
            firstSide = Math.sqrt(Math.pow(firstDifx, SECOND_DEGREE) + Math.pow(firstDify, SECOND_DEGREE));
            secondSide = Math.sqrt(Math.pow(secondDifx, SECOND_DEGREE) + Math.pow(secondDify, SECOND_DEGREE));

        } else if (points.getLengthCoordinates(0) == THREE_DIMENS) {
            double firstDifz = points.getPoint(FIRST_POINT, ZCORDINATE) - points.getPoint(SECOND_POINT, ZCORDINATE);
            double secondDifz = points.getPoint(SECOND_POINT, ZCORDINATE) - points.getPoint(THIRD_POINT, ZCORDINATE);

            firstSide = Math.sqrt(Math.pow(firstDifx, SECOND_DEGREE) + Math.pow(firstDify, SECOND_DEGREE))
                    + Math.pow(firstDifz, SECOND_DEGREE);
            secondSide = Math.sqrt(Math.pow(secondDifx, SECOND_DEGREE) + Math.pow(secondDify, SECOND_DEGREE))
                    + Math.pow(secondDifz, SECOND_DEGREE);


        }
        double result = (firstSide + secondSide) * KOEF_PERIMETR;
        this.perimetr = result;
        System.out.printf("The figure perimeter - %.2f\n", result);
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
