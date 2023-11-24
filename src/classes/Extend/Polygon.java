package classes.Extend;
import classes.Figure;
import classes.Points;

public class Polygon extends Figure {

    public Polygon(Points points) {
        super(points);
    }

    @Override
    public boolean isValid() {

        boolean validation = true;
        int size = points.getLength();
        double[] sides = new double[size];
        double Difx;
        double Dify;
        for (int i = 0; i < size; i++) {
            Difx = points.getPoint(0, 0) - points.getPoint(1, 0);
            Dify = points.getPoint(0, 1) - points.getPoint(1, 1);
            sides[i] = Math.sqrt(Math.pow(Difx, 2) + Math.pow(Dify, 2));
        }
        for (int i = 0; i < size - 1; i++) {
            if (sides[i] != sides[i + 1]) {
                return false;
            }
        }
        return  validation;
    }

    @Override
    public void square() {
        double firstDifx = points.getPoint(0, 0) - points.getPoint(1, 0);
        double firstDify = points.getPoint(0, 1) - points.getPoint(1, 1);
        double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

        double ctg = Math.sin(180.0 / points.getLength()) / Math.cos(180.0 / points.getLength());
        double result = (points.getLength() * Math.pow(firstSide, 2)) / 4 * ctg;
        System.out.printf("The figure area - %.2f\n", result);
    }

    @Override
    public void perimeter() {

        double firstDifx = points.getPoint(0, 0) - points.getPoint(1, 0);
        double firstDify = points.getPoint(0, 1) - points.getPoint(1, 1);
        double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

        double result = points.getLength() * firstSide;
        System.out.printf("The figure perimeter - %.2f\n", result);
    }
}
