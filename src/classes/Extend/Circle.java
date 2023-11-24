package classes.Extend;
import classes.Figure;
import classes.Constants;
import classes.Points;

public class Circle extends Figure implements Constants {

    public Circle(Points points) {
        super(points);
    }

    @Override
    public boolean isValid() {
        boolean validation = false;
        if (points.getLength() == AMOUNT_OF_POINTS_CIRCLE) {
            if (radius() > 0) {
                System.out.println("The figure is valid");
                validation = true;
            } else {
                System.out.println("The figure is invalid");
            }
        } else if (points.getLength() > AMOUNT_OF_POINTS_CIRCLE){
            System.out.println("The number of coordinates is greater than necessary for the figure");
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");

        }
        return validation;
    }

    @Override
    public void square() {
        double result = Math.PI * Math.pow(radius(), SECOND_DEGREE);
        System.out.printf("The figure area - %.2f\n", result);
    }

    @Override
    public void perimeter() {
        double result = KOEF_PERIMETR_CIRCLE * Math.PI * radius();
        System.out.printf("The figure perimeter - %.2f\n", result);
    }

    public double radius() {
        double xcordinate = points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE) - points.getPoint(SECOND_POINT,SECOND_POINT_XCORDINATE);
        double ycordinate = points.getPoint(FIRST_POINT,FIRST_POINT_YCORDINATE) - points.getPoint(SECOND_POINT,SECOND_POINT_YCORDINATE);
        double radiusSecondDegree = Math.pow(xcordinate, SECOND_DEGREE) + Math.pow(ycordinate, SECOND_DEGREE);
        return Math.sqrt(radiusSecondDegree);
    }
}