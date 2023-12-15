import github.com.classes.Points;
import github.com.figure.classes.Sphere;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class SphereTest {
    private final Points endPoints = new Points(init());

    public ArrayList<ArrayList<Integer>> init() {
        ArrayList<ArrayList<Integer>> point = new ArrayList<>();

        ArrayList<Integer> centerPoint = new ArrayList<>();
        centerPoint.add(0);
        centerPoint.add(0);
        centerPoint.add(1);

        ArrayList<Integer> pointOnSphere = new ArrayList<>();
        pointOnSphere.add(0);
        pointOnSphere.add(0);
        pointOnSphere.add(0);

        point.add(centerPoint);
        point.add(pointOnSphere);

        return point;

    }
    @Test
    @DisplayName("testValidity")
    public void testValidity() {

        Sphere sphere = new Sphere(endPoints);
        boolean check = sphere.isValid();
        then(check).isEqualTo(true);

    }

    @Test
    @DisplayName("testPerimeter")
    public void testPerimeter() {

        Sphere sphere = new Sphere(endPoints);
        then(sphere.getPerimeter()).isEqualTo("The Sphere has no perimeter");
    }

    @Test
    @DisplayName("testArea")
    public void testArea() {

        Sphere sphere = new Sphere(endPoints);
        double elipson = 0.01;
        double expected = 12.56;
        double actual = sphere.getArea();
        System.out.println(sphere.getArea());
        Assert.assertEquals(expected, actual, elipson);
    }
}
