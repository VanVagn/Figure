import github.com.classes.Points;
import github.com.figure.classes.Cylinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class CylinderTest {
    private final Points endPoints = new Points(init());

    public ArrayList<ArrayList<Integer>> init() {
        ArrayList<ArrayList<Integer>> point = new ArrayList<>();

        ArrayList<Integer> lowCenterPoint = new ArrayList<>();
        lowCenterPoint.add(0);
        lowCenterPoint.add(0);
        lowCenterPoint.add(0);

        ArrayList<Integer> topCenterPoint = new ArrayList<>();
        topCenterPoint.add(0);
        topCenterPoint.add(0);
        topCenterPoint.add(2);

        ArrayList<Integer> anyPointOnLowOrTopCircle = new ArrayList<>();
        anyPointOnLowOrTopCircle.add(1);
        anyPointOnLowOrTopCircle.add(0);
        anyPointOnLowOrTopCircle.add(0);

        point.add(lowCenterPoint);
        point.add(topCenterPoint);
        point.add(anyPointOnLowOrTopCircle);

        return point;

    }
    @Test
    @DisplayName("testValidity")
    public void testValidity() {

        Cylinder cylinder = new Cylinder(endPoints);
        boolean check = cylinder.isValid();
        then(check).isEqualTo(true);

    }

    @Test
    @DisplayName("testPerimeter")
    public void testPerimeter() {

        Cylinder cylinder = new Cylinder(endPoints);
        then(cylinder.getPerimeter()).isEqualTo("The Cylinder has no perimeter");
    }

    @Test
    @DisplayName("testArea")
    public void testArea() {

        Cylinder cylinder = new Cylinder(endPoints);
        double elipson = 0.01;
        double expected = 18.85;
        double actual = cylinder.getArea();
        System.out.println(cylinder.getArea());
        Assert.assertEquals(expected, actual, elipson);
    }
}
