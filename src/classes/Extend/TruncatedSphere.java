package classes.Extend;
import classes.Figure;
import classes.Points;

public class TruncatedSphere extends Figure {

    public TruncatedSphere(Points points) {
        super(points);
    }

    @Override
    public boolean isValid() {

        boolean validation = false;
        if (points.getLength() == 2) {
            if (radius() > 0) {
                System.out.println("The figure is valid");
                validation = true;
            } else {
                System.out.println("The figure is invalid");
            }
        } else if (points.getLength() > 2){
            System.out.println("The number of coordinates is greater than necessary for the figure");
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");

        }
        return validation;
    }

    @Override
    public void square() {
        double high = radius() - Math.abs(points.getPoint(2, 2));
        double result = 4 * Math.PI * Math.pow(radius(), 2) - 2 * Math.PI * radius() * high;
        System.out.printf("The figure area - %.2f\n", result);
    }

    public double radius() {
        double xcordinate = points.getPoint(0,0) - points.getPoint(1,0);
        double ycordinate = points.getPoint(0,1) - points.getPoint(1,1);
        double zcordinate = points.getPoint(0,2) - points.getPoint(1,2);
        double help = Math.pow(xcordinate, 2) + Math.pow(ycordinate, 2) + Math.pow(zcordinate, 2);
        return Math.sqrt(help);
    }
}
