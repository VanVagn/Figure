package classes.Extend;

import classes.Figure;
import classes.Points;

public class Rectangle extends Figure {
    public Rectangle(Points points) {
        super(points);
    }

    public boolean isValid() {

        boolean validation = false;
        if (points.getLength() == 4) {

            double firstDifx = points.getPoint(0, 0) - points.getPoint(1, 0);
            double firstDify = points.getPoint(0, 1) - points.getPoint(1, 1);
            double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

            double secondDifx = points.getPoint(1, 0) - points.getPoint(2, 0);
            double secondDify = points.getPoint(1, 1) - points.getPoint(2, 1);
            double secondSide = Math.sqrt(Math.pow(secondDifx, 2) + Math.pow(secondDify, 2));

            double thirdDifx = points.getPoint(2, 0) - points.getPoint(3, 0);
            double thirdDify = points.getPoint(2, 1) - points.getPoint(3, 1);
            double thirdSide = Math.sqrt(Math.pow(thirdDifx, 2) + Math.pow(thirdDify, 2));

            double fourthDifx = points.getPoint(3, 0) - points.getPoint(0, 0);
            double fourthDify = points.getPoint(3, 1) - points.getPoint(0, 1);
            double fourthSide = Math.sqrt(Math.pow(fourthDifx, 2) + Math.pow(fourthDify, 2));

            double firstDiagonal = Math.sqrt(Math.pow(firstSide, 2) + Math.pow(secondSide, 2));
            double secondDiagonal = Math.sqrt(Math.pow(thirdSide, 2) + Math.pow(fourthSide, 2));
            validation = (firstSide == thirdSide) & (secondSide == fourthSide) & (firstSide != secondSide) & (firstDiagonal == secondDiagonal);

            if (validation) {
                System.out.println("The figure is valid");
            } else {
                System.out.println("The figure is invalid");
            }
        } else if (points.getLength() > 4) {
            System.out.println("The number of coordinates is greater than necessary for the figure");
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");

        }
        return validation;
    }

    @Override
    public void square() {

        double firstDifx = points.getPoint(0, 0) - points.getPoint(1, 0);
        double firstDify = points.getPoint(0, 1) - points.getPoint(1, 1);
        double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

        double secondDifx = points.getPoint(1, 0) - points.getPoint(2, 0);
        double secondDify = points.getPoint(1, 1) - points.getPoint(2, 1);
        double secondSide = Math.sqrt(Math.pow(secondDifx, 2) + Math.pow(secondDify, 2));

        double result = firstSide * secondSide;
        System.out.printf("The figure area - %.2f\n", result);
    }

    @Override
    public void perimeter() {

        double firstDifx = points.getPoint(0, 0) - points.getPoint(1, 0);
        double firstDify = points.getPoint(0, 1) - points.getPoint(1, 1);
        double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

        double secondDifx = points.getPoint(1, 0) - points.getPoint(2, 0);
        double secondDify = points.getPoint(1, 1) - points.getPoint(2, 1);
        double secondSide = Math.sqrt(Math.pow(secondDifx, 2) + Math.pow(secondDify, 2));

        double result = (firstSide + secondSide) * 2;
        System.out.printf("The figure perimeter - %.2f\n", result);
    }
}
