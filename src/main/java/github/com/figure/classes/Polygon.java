package github.com.figure.classes;
import github.com.classes.Points;

import static github.com.constains.Constants.*;

public class Polygon extends Figure {

    private double area;
    private double perimetr;
    public Polygon(Points points) {
        super(points);

    }

    @Override
    public boolean isValid() {

        boolean validation = true;
        boolean twoDimensional = true;
        boolean threeDimensional = true;
        if (points.getLengthPoints() > MINIM_AMOUNT) {
            int dimen = checkDimens();
            if (dimen == TWO_DIMENS) {
                for (int i = 0; i < points.getLengthPoints(); i++) {
                    int j = (i + SECOND_POINT) % points.getLengthPoints();
                    int k = (i + THIRD_POINT) % points.getLengthPoints();
                    double[] vector1 = new double[TWO_DIMENS];
                    double[] vector2 = new double[TWO_DIMENS];

                    vector1[FIRST_POINT] = points.getPoint(j, XCORDINATE) - points.getPoint(i, XCORDINATE);
                    vector1[SECOND_POINT] = points.getPoint(j, YCORDINATE) - points.getPoint(i, YCORDINATE);

                    vector2[FIRST_POINT] = points.getPoint(k, XCORDINATE) - points.getPoint(j, XCORDINATE);
                    vector2[SECOND_POINT] = points.getPoint(k, YCORDINATE) - points.getPoint(j, YCORDINATE);

                    double determinant = vector1[FIRST_POINT] * vector2[SECOND_POINT] - vector2[FIRST_POINT] * vector1[SECOND_POINT];
                    if (determinant == 0) {
                        System.out.println("The figure is invalid");
                        validation = false;
                    }
                }
            } else if (dimen == THREE_DIMENS) {
                for (int i = 0; i < points.getLengthPoints(); i++) {
                    int j = (i + SECOND_POINT) % points.getLengthPoints();
                    int k = (i + THIRD_POINT) % points.getLengthPoints();
                    double[] vector1 = new double[THREE_DIMENS];
                    double[] vector2 = new double[THREE_DIMENS];

                    vector1[FIRST_POINT] = points.getPoint(j, XCORDINATE) - points.getPoint(i, XCORDINATE);
                    vector1[SECOND_POINT] = points.getPoint(j, YCORDINATE) - points.getPoint(i, YCORDINATE);
                    vector1[THIRD_POINT] = points.getPoint(j, ZCORDINATE) - points.getPoint(i, ZCORDINATE);

                    vector2[FIRST_POINT] = points.getPoint(k, XCORDINATE) - points.getPoint(j, XCORDINATE);
                    vector2[SECOND_POINT] = points.getPoint(k, YCORDINATE) - points.getPoint(j, YCORDINATE);
                    vector2[THIRD_POINT] = points.getPoint(k, ZCORDINATE) - points.getPoint(j, ZCORDINATE);

                    double firstDeterminant = vector1[FIRST_POINT] * vector2[SECOND_POINT] - vector2[FIRST_POINT] * vector1[SECOND_POINT];
                    double secondDeterminant = vector1[FIRST_POINT] * vector2[THIRD_POINT] - vector2[FIRST_POINT] * vector1[THIRD_POINT];
                    double thirdDeterminant = vector1[FIRST_POINT] * vector2[SECOND_POINT] - vector2[FIRST_POINT] * vector1[SECOND_POINT];

                    if (firstDeterminant - secondDeterminant + thirdDeterminant == 0) {
                        System.out.println("The figure is invalid");
                        validation = false;
                    }
                }
            } else {
                System.out.println("The figure is invalid");
            }
        }
        System.out.println("The figure is valid");
        return validation;
    }

    @Override
    public void square() {
        double result = 0;
        int size = points.getLengthPoints();

        if (points.getLengthCoordinates(0) == TWO_DIMENS) {
            for (int i = 0; i < size; i++) {
                int j = (i + 1) % size;
                int x1 = points.getPoint(i, XCORDINATE);
                int y1 = points.getPoint(i, YCORDINATE);
                int x2 = points.getPoint(j, XCORDINATE);
                int y2 = points.getPoint(j, YCORDINATE);
                result += x1 * y2 - x2 * y1;
            }
        } else {
            for (int i = 1; i < points.getLengthPoints() - 1; i++) {
                int j = i + 1;
                int x1 = points.getPoint(i, XCORDINATE) - points.getPoint(FIRST_POINT, XCORDINATE);
                int y1 = points.getPoint(i, YCORDINATE) - points.getPoint(FIRST_POINT, YCORDINATE);
                int z1 = points.getPoint(i, ZCORDINATE) - points.getPoint(FIRST_POINT, ZCORDINATE);
                int x2 = points.getPoint(j, XCORDINATE) - points.getPoint(FIRST_POINT, ZCORDINATE);
                int y2 = points.getPoint(j, YCORDINATE) - points.getPoint(FIRST_POINT, YCORDINATE);
                int z2 = points.getPoint(j, ZCORDINATE) - points.getPoint(FIRST_POINT, ZCORDINATE);

                result += Math.sqrt(Math.pow(y1 * z2 - y2 * z1, SECOND_DEGREE) + Math.pow((x1 * z2 - x2 * z1), SECOND_DEGREE) + Math.pow(x1 * y2 - x2 * y1, SECOND_DEGREE));
            }
        }
        result *= POLU;
        area = result;
        System.out.printf("The figure area - %.2f\n", result);
    }

    @Override
    public void perimeter() {
        double result = 0;
        double Difx = 0;
        double Dify = 0;
        double Difz = 0;
        if (points.getLengthCoordinates(0) == TWO_DIMENS) {
            for (int i = 0; i < points.getLengthPoints(); i++) {
                int j = (i + 1) % points.getLengthPoints();
                Difx = points.getPoint(i, XCORDINATE) - points.getPoint(j, XCORDINATE);
                Dify = points.getPoint(i, YCORDINATE) - points.getPoint(j, YCORDINATE);
                result += Math.sqrt(Math.pow(Difx, SECOND_DEGREE) + Math.pow(Dify, SECOND_DEGREE));
            }
        } else {
            for (int i = 0; i < points.getLengthPoints(); i++) {
                int j = (i + 1) % points.getLengthPoints();
                Difx = points.getPoint(i, XCORDINATE) - points.getPoint(j, XCORDINATE);
                Dify = points.getPoint(i, YCORDINATE) - points.getPoint(j, YCORDINATE);
                Difz = points.getPoint(i, ZCORDINATE) - points.getPoint(j, ZCORDINATE);

                result += Math.sqrt(Math.pow(Difx, SECOND_DEGREE) + Math.pow(Dify, SECOND_DEGREE)
                        + Math.pow(Difz, SECOND_DEGREE));
                System.out.println(result);
            }
        }
        perimetr = result;
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
    public int checkDimens() {
        boolean flag = true;
        for (int i = 0; i < points.getLengthPoints(); i++) {
            if (points.getLengthCoordinates(i) != TWO_DIMENS) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return TWO_DIMENS;
        }
        flag = true;
        for (int i = 0; i < points.getLengthPoints(); i++) {
            if (points.getLengthCoordinates(i) != THREE_DIMENS) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return THREE_DIMENS;
        }
        return 0;
    }
}
