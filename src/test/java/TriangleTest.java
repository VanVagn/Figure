import github.com.classes.Points;
import github.com.figure.classes.Triangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class TriangleTest {
    private Points endPoints = new Points(init());

    public ArrayList<ArrayList<Integer>> init() {
        ArrayList<ArrayList<Integer>> point = new ArrayList<>();

        ArrayList<Integer> firstPoint = new ArrayList<>();
        firstPoint.add(0);
        firstPoint.add(0);

        ArrayList<Integer> secondPoint = new ArrayList<>();
        secondPoint.add(0);
        secondPoint.add(3);

        ArrayList<Integer> thirdPoint = new ArrayList<>();
        thirdPoint.add(4);
        thirdPoint.add(0);

        point.add(firstPoint);
        point.add(secondPoint);
        point.add(thirdPoint);

        return point;

    }
    @Test
    @DisplayName("testValidity")
    public void testValidity() {

        Triangle triangle = new Triangle(endPoints);
        boolean check = triangle.isValid();
        then(check).isEqualTo(true);

    }

    @Test
    @DisplayName("testPerimeter")
    public void testPerimeter() {

        Triangle triangle = new Triangle(endPoints);
        then(triangle.getPerimetr()).isEqualTo(12.00);
    }

    @Test
    @DisplayName("testArea")
    public void testArea() {

        Triangle triangle = new Triangle(endPoints);
        then(triangle.getArea()).isEqualTo(6.00);
    }
}
