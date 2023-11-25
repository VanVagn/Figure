import java.util.ArrayList;
import java.util.Scanner;
import github.com.figure.classes.Figure;
import github.com.classes.Points;
import github.com.enums.TypeFigure;
import github.com.figure.classes.*;

public class Main {

    public static void main(String[] args) {
        Figure figure = inputAndOutputFigure();
    }

    public static Figure inputAndOutputFigure() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            TypeFigure typeFigure = TypeFigure.valueOf(input);
            switch (typeFigure) {
                case END:
                    return null;
                case FIGURE:
                    Points points = inputPoints(scanner);
                    Figure figure = new Figure(points);
                    if (figure.isValid()) {
                        figure.perimeter();
                        figure.square();
                        return figure;
                    }
                    break;
                case CIRCLE:
                    points = inputPoints(scanner);
                    figure = new Circle(points);
                    if (figure.isValid()) {
                        figure.perimeter();
                        figure.square();
                        return figure;
                    }
                    break;
                case SQUARE:
                    points = inputPoints(scanner);
                    figure = new Square(points);
                    if (figure.isValid()) {
                        figure.perimeter();
                        figure.square();
                        return figure;
                    }
                    break;
                case RECTANGLE:
                    points = inputPoints(scanner);
                    figure = new Rectangle(points);
                    if (figure.isValid()) {
                        figure.perimeter();
                        figure.square();
                        return figure;

                    }
                case PARALLELOGRAM:
                    points = inputPoints(scanner);
                    figure = new Parallelogram(points);
                    if (figure.isValid()) {
                        figure.perimeter();
                        figure.square();
                        return figure;
                    }
                case TRIANGLE:
                    points = inputPoints(scanner);
                    figure = new Triangle(points);
                    if (figure.isValid()) {
                        figure.perimeter();
                        figure.square();
                        return figure;
                    }
                case POLYGON:
                    points = inputPoints(scanner);
                    figure = new Polygon(points);
                    if (figure.isValid()) {
                        figure.perimeter();
                        figure.square();
                        return figure;
                    }
                case TRUNCATED_SPHERE:
                    points = inputPoints(scanner);
                    figure = new TruncatedSphere(points);
                    if (figure.isValid()) {
                        figure.perimeter();
                        figure.square();
                        return figure;
                    }
                case CYLINDER:
                    points = inputPoints(scanner);
                    figure = new Cylinder(points);
                    if (figure.isValid()) {
                        figure.perimeter();
                        figure.square();
                        return figure;
                    }
                case CONE:
                    points = inputPoints(scanner);
                    figure = new Cone(points);
                    if (figure.isValid()) {
                        figure.perimeter();
                        figure.square();
                        return figure;
                    }
                case SPHERE:
                    points = inputPoints(scanner);
                    figure = new Sphere(points);
                    if (figure.isValid()) {
                        figure.perimeter();
                        figure.square();
                        return figure;
                    }
            }
        }
    }

    public static Points inputPoints(Scanner scanner) {
        String line = scanner.nextLine();
        Boolean correctInput = true;
        ArrayList<ArrayList<Integer>> points = new ArrayList<ArrayList<Integer>>();
        while (!line.equals("STOP_INPUT")) {
            String[] strPoints = line.split(" ");
            ArrayList<Integer> point = new ArrayList<Integer>();
            for (int i = 0; i < strPoints.length; i++) {
                if (strPoints[i].matches("-?\\d+")) {
                    point.add(Integer.parseInt(strPoints[i]));
                } else {
                    System.out.println("Please, retype");
                    correctInput = false;
                    break;
                }
            }
            if (correctInput) {
                points.add(point);
            }
            line = scanner.nextLine();
        }
        return new Points(points);
    }
}