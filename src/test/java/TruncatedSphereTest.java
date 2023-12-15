import github.com.classes.Points;
import github.com.figure.classes.TruncatedSphere;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class TruncatedSphereTest {
    private final Points endPoints = new Points(init());

    public ArrayList<ArrayList<Integer>> init() {
        ArrayList<ArrayList<Integer>> point = new ArrayList<>();

        ArrayList<Integer> centerPoint = new ArrayList<>();
        centerPoint.add(0);
        centerPoint.add(0);
        centerPoint.add(0);

        ArrayList<Integer> pointOnSphere = new ArrayList<>();
        pointOnSphere.add(0);
        pointOnSphere.add(0);
        pointOnSphere.add(10);

        ArrayList<Integer> pointOnSurfaceSection = new ArrayList<>();
        pointOnSurfaceSection.add(10);
        pointOnSurfaceSection.add(0);
        pointOnSurfaceSection.add(0);

        point.add(centerPoint);
        point.add(pointOnSphere);
        point.add(pointOnSurfaceSection);

        return point;

    }
    @Test
    @DisplayName("testValidity")
    public void testValidity() {

        TruncatedSphere truncatedSphere = new TruncatedSphere(endPoints);
        boolean check = truncatedSphere.isValid();
        then(check).isEqualTo(true);

    }

    @Test
    @DisplayName("testPerimeter")
    public void testPerimeter() {

        TruncatedSphere truncatedSphere = new TruncatedSphere(endPoints);
        then(truncatedSphere.getPerimeter()).isEqualTo("The Truncated_Sphere has no perimeter");
    }

    @Test
    @DisplayName("testArea")
    public void testArea() {

        TruncatedSphere truncatedSphere = new TruncatedSphere(endPoints);
        double elipson = 0.01;
        double expected = 942.48;
        double actual = truncatedSphere.getArea();
        System.out.println(truncatedSphere.getArea());
        Assert.assertEquals(expected, actual, elipson);
    }
}
