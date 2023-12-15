package github.com.figure.classes;
import github.com.constains.Constants;
import github.com.classes.Points;

public class Circle extends Figure implements Constants {

    private double area;
    private double perimetr;
    private int dimension;

    public Circle(Points points) {
        super(points);
    }

    @Override
    public boolean isValid() {
        if (points.getLengthPoints() == AMOUNT_OF_POINTS_CIRCLE) {
            boolean twoDimensional = points.getLengthCoordinates(FIRST_POINT) == TWO_DIMENS
                    && points.getLengthCoordinates(SECOND_POINT) == TWO_DIMENS;
            boolean threeDimensional = points.getLengthCoordinates(FIRST_POINT) == THREE_DIMENS
                    && points.getLengthCoordinates(SECOND_POINT) == THREE_DIMENS;
            if (twoDimensional || threeDimensional) {
                if (radius() > 0) {
                    System.out.println("The figure is valid. it's a Circle");
                    return true;
                } else {
                    System.out.println("The figure is invalid");
                }
            } else {
                System.out.println("The figure is invalid. The amount of coordinates must be 2 or 3");
            }

        } else if (points.getLengthPoints() > AMOUNT_OF_POINTS_CIRCLE){
            System.out.println("The number of coordinates is greater than necessary for the figure");
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");

        }
        return false;
    }

    @Override
    public void square() {
        double result = PI * Math.pow(radius(), SECOND_DEGREE);
        area = result;
        System.out.printf("The Circle area - %.2f\n", result);
    }

    @Override
    public void perimeter() {
        double result = KOEF_PERIMETR * PI * radius();
        perimetr = result;
        System.out.printf("The Circle perimeter - %.2f\n", result);
    }

    public double radius() {
        double radiusSecondDegree = 0;
        double xcordinate = points.getPoint(FIRST_POINT, XCORDINATE) - points.getPoint(SECOND_POINT, XCORDINATE);
        double ycordinate = points.getPoint(FIRST_POINT, YCORDINATE) - points.getPoint(SECOND_POINT, YCORDINATE);
        dimension = points.getLengthCoordinates(FIRST_POINT);
        if (dimension == TWO_DIMENS) {
            radiusSecondDegree = Math.pow(xcordinate, SECOND_DEGREE) + Math.pow(ycordinate, SECOND_DEGREE);
        } else if (dimension == THREE_DIMENS) {
            double zcordinate =  points.getPoint(FIRST_POINT, ZCORDINATE) - points.getPoint(SECOND_POINT, ZCORDINATE);
            radiusSecondDegree = Math.pow(xcordinate, SECOND_DEGREE) + Math.pow(ycordinate, SECOND_DEGREE) + Math.pow(zcordinate, SECOND_DEGREE);
        }
        return Math.sqrt(radiusSecondDegree);
    }

    public double getArea() {
        square();
        return area;
    }

    public double getPerimetr() {
        perimeter();
        return perimetr;
    }
}