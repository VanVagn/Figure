package classes.Extend;

import classes.Figure;
import classes.Points;

public class Triangle extends Figure {
    public Triangle(Points points) {
        super(points);
    }

    @Override
    public boolean isValid() {

        boolean validation = false;
        if (points.getLength() == 3) {

            double firstDifx = points.getPoint(0, 0) - points.getPoint(1, 0);
            double firstDify = points.getPoint(0, 1) - points.getPoint(1, 1);
            double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

            double secondDifx = points.getPoint(1, 0) - points.getPoint(2, 0);
            double secondDify = points.getPoint(1, 1) - points.getPoint(2, 1);
            double secondSide = Math.sqrt(Math.pow(secondDifx, 2) + Math.pow(secondDify, 2));

            double thirdDifx = points.getPoint(2, 0) - points.getPoint(0, 0);
            double thirdDify = points.getPoint(2, 1) - points.getPoint(0, 1);
            double thirdSide = Math.sqrt(Math.pow(thirdDifx, 2) + Math.pow(thirdDify, 2));
            validation = (firstSide + secondSide > thirdSide) & (firstSide + thirdSide > secondSide) & (secondSide + thirdSide > firstSide);

            if (validation) {
                System.out.println("The figure is valid");
            } else {
                System.out.println("The figure is invalid");
            }
        } else if (points.getLength() > 3) {
            System.out.println("The number of coordinates is greater than necessary for the figure");
        } else {
            System.out.println("The number of coordinates is less than necessary for the figure");

        }
        return validation;
    }
    @Override
    public void perimeter() {

        double firstDifx = points.getPoint(0, 0) - points.getPoint(1, 0);
        double firstDify = points.getPoint(0, 1) - points.getPoint(1, 1);
        double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

        double secondDifx = points.getPoint(1, 0) - points.getPoint(2, 0);
        double secondDify = points.getPoint(1, 1) - points.getPoint(2, 1);
        double secondSide = Math.sqrt(Math.pow(secondDifx, 2) + Math.pow(secondDify, 2));

        double thirdDifx = points.getPoint(2, 0) - points.getPoint(0, 0);
        double thirdDify = points.getPoint(2, 1) - points.getPoint(0, 1);
        double thirdSide = Math.sqrt(Math.pow(thirdDifx, 2) + Math.pow(thirdDify, 2));

        double result = firstSide + secondSide + thirdSide;
        System.out.printf("The figure perimeter - %.2f\n", result);
    }

    @Override
    public void square() {

        double firstDifx = points.getPoint(0, 0) - points.getPoint(1, 0);
        double firstDify = points.getPoint(0, 1) - points.getPoint(1, 1);
        double firstSide = Math.sqrt(Math.pow(firstDifx, 2) + Math.pow(firstDify, 2));

        double secondDifx = points.getPoint(1, 0) - points.getPoint(2, 0);
        double secondDify = points.getPoint(1, 1) - points.getPoint(2, 1);
        double secondSide = Math.sqrt(Math.pow(secondDifx, 2) + Math.pow(secondDify, 2));

        double thirdDifx = points.getPoint(2, 0) - points.getPoint(0, 0);
        double thirdDify = points.getPoint(2, 1) - points.getPoint(0, 1);
        double thirdSide = Math.sqrt(Math.pow(thirdDifx, 2) + Math.pow(thirdDify, 2));

        double poluperimetr = (firstSide + secondSide + thirdSide) * 0.5;
        double result = Math.sqrt(poluperimetr * (poluperimetr - firstSide) * (poluperimetr - secondSide) * (poluperimetr - thirdSide));
        System.out.printf("The figure area - %.2f\n", result);
    }
}
