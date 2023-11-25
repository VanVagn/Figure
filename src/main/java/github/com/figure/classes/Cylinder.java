package github.com.figure.classes;
import github.com.classes.Points;
import static github.com.constains.Constants.*;

public class Cylinder extends Figure {

    public Cylinder(Points points) {
        super(points);
    }

    @Override
    public boolean isValid() {

        if (points.getLength() == AMOUNT_OF_POINTS_CYLINDER) {
            for (int indexPoint = 0; indexPoint < AMOUNT_OF_POINTS_CYLINDER; indexPoint++) {
                double x = points.getPoint(indexPoint, XCORDINATE);
                double y = points.getPoint(indexPoint, YCORDINATE);
                double z = points.getPoint(indexPoint, ZCORDINATE);
                if (Math.pow(x, 2) + Math.pow(y, 2) != Math.pow(z, 2)) {
                    System.out.println("The figure is valid");
                    return false;
                }
            }
            System.out.println("The figure is invalid");
            return true;
        } else if (points.getLength() > AMOUNT_OF_POINTS_CYLINDER){
            System.out.println("The number of coordinates is greater than necessary for the figure");
            return false;
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");
            return false;
        }

    }

    @Override
    public void square() {

        double firstDifx = points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE);
        double firstDify = points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE);
        double firstDifz = points.getPoint(FIRST_POINT, FIRST_POINT_ZCORDINATE) - points.getPoint(SECOND_POINT, SECOND_POINT_ZCORDINATE);
        double high = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2) + Math.pow(firstDifz, 2));

        double secondDifx = points.getPoint(SECOND_POINT, SECOND_POINT_XCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_XCORDINATE);
        double secondDify = points.getPoint(SECOND_POINT, SECOND_POINT_YCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_YCORDINATE);
        double secondDifz = points.getPoint(SECOND_POINT, SECOND_POINT_ZCORDINATE) - points.getPoint(THIRD_POINT, THIRD_POINT_ZCORDINATE);
        double secondSide = Math.sqrt(Math.pow(secondDifx, 2) + Math.pow(secondDify, 2) + Math.pow(secondDifz, 2));

        double thirdDifx = points.getPoint(THIRD_POINT, THIRD_POINT_XCORDINATE) - points.getPoint(FIRST_POINT, FIRST_POINT_XCORDINATE);
        double thirdDify = points.getPoint(THIRD_POINT, THIRD_POINT_YCORDINATE) - points.getPoint(FIRST_POINT, FIRST_POINT_YCORDINATE);
        double thirdDifz = points.getPoint(THIRD_POINT, THIRD_POINT_ZCORDINATE) - points.getPoint(FIRST_POINT, FIRST_POINT_ZCORDINATE);
        double thirdSide = Math.sqrt(Math.pow(thirdDifx, 2) + Math.pow(thirdDify, 2) + Math.pow(thirdDifz, 2));

        double radiuc = Math.min(secondSide, thirdSide);
        double result = 2 * Math.PI * Math.pow(radiuc, 2) + 2 * Math.PI * radiuc * high;
        System.out.printf("The figure area - %.2f\n", result);
    }

}
