import github.com.classes.Points;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import github.com.figure.classes.Circle;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class Circle_Test {
    private Points endPoints = new Points(init());

    public ArrayList<ArrayList<Integer>> init() {
        ArrayList<ArrayList<Integer>> point = new ArrayList<>();

        ArrayList<Integer> centerPoint = new ArrayList<>();
        centerPoint.add(0);
        centerPoint.add(0);

        ArrayList<Integer> pointOnCircle = new ArrayList<>();
        pointOnCircle.add(1);
        pointOnCircle.add(0);

        point.add(centerPoint);
        point.add(pointOnCircle);
        return point;

    }
    @Test
    @DisplayName("testValidity")
    public void testValidity() {

        Circle circle = new Circle(endPoints);
        boolean check = circle.isValid();
        then(check).isEqualTo(true);

    }

    @Test
    @DisplayName("testPerimeter")
    public void testPerimeter() {

        Circle circle = new Circle(endPoints);
        then(circle.getPerimetr()).isEqualTo(6.28);
    }

    @Test
    @DisplayName("testArea")
    public void testArea() {

        Circle circle = new Circle(endPoints);
        then(circle.getArea()).isEqualTo(3.14);
    }

}