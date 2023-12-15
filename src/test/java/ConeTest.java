import github.com.classes.Points;
import github.com.figure.classes.Cone;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class ConeTest {
    private Points endPoints = new Points(init());

    public ArrayList<ArrayList<Integer>> init() {
        ArrayList<ArrayList<Integer>> point = new ArrayList<>();

        ArrayList<Integer> centerPoint = new ArrayList<>();
        centerPoint.add(0);
        centerPoint.add(0);
        centerPoint.add(0);

        ArrayList<Integer> pointOnCircle = new ArrayList<>();
        pointOnCircle.add(1);
        pointOnCircle.add(0);
        pointOnCircle.add(0);

        ArrayList<Integer> TopPoint = new ArrayList<>();
        TopPoint.add(0);
        TopPoint.add(0);
        TopPoint.add(2);

        point.add(centerPoint);
        point.add(pointOnCircle);
        point.add(TopPoint);

        return point;

    }
    @Test
    @DisplayName("testValidity")
    public void testValidity() {

        Cone cone = new Cone(endPoints);
        boolean check = cone.isValid();
        then(check).isEqualTo(true);

    }

    @Test
    @DisplayName("testPerimeter")
    public void testPerimeter() {

        Cone cone = new Cone(endPoints);
        then(cone.getPerimeter()).isEqualTo("The Cone has no perimeter");
    }

    @Test
    @DisplayName("testArea")
    public void testArea() {

        Cone cone = new Cone(endPoints);
        double expected = 10.17;
        double elipson = 0.01;
        double actual = cone.getArea();
        Assert.assertEquals(expected, actual, elipson);
    }
}
