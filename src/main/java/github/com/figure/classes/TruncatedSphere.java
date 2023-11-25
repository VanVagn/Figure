package github.com.figure.classes;
import github.com.classes.Points;

import static github.com.constains.Constants.*;

public class TruncatedSphere extends Figure {

    public TruncatedSphere(Points points) {
        super(points);
    }

    @Override
    public boolean isValid() {

        boolean validation = false;
        if (points.getLength() == AMOUNT_OF_POINTS_TRUNCATED_SPHERE) {
            if (radius() > 0) {
                System.out.println("The figure is valid");
                validation = true;
            } else {
                System.out.println("The figure is invalid");
            }
        } else if (points.getLength() > AMOUNT_OF_POINTS_TRUNCATED_SPHERE){
            System.out.println("The number of coordinates is greater than necessary for the figure");
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");

        }
        return validation;
    }

    @Override
    public void square() {

        double high = radius() - Math.abs(points.getPoint(THIRD_POINT, THIRD_POINT_ZCORDINATE));
        double result = 4 * Math.PI * Math.pow(radius(), 2) - 2 * Math.PI * radius() * high;
        System.out.printf("The figure area - %.2f\n", result);
    }

    public double radius() {
        double xcordinate = points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE);
        double ycordinate = points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE) - points.getPoint(SECOND_POINT,   SECOND_POINT_YCORDINATE);
        double zcordinate = points.getPoint(FIRST_POINT, FIRST_POINT_ZCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_ZCORDINATE);
        double help = Math.pow(xcordinate, 2) + Math.pow(ycordinate, 2) + Math.pow(zcordinate, 2);
        return Math.sqrt(help);
    }
}
