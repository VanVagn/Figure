import github.com.classes.Points;
import github.com.figure.classes.Parallelogram;
import github.com.figure.classes.Polygon;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class PolygonTest {
    private Points endPointsTwo = new Points(initTwo());
    private Points endPointsThree = new Points(initThree());
    public ArrayList<ArrayList<Integer>> initTwo() {
        ArrayList<ArrayList<Integer>> point = new ArrayList<>();

        ArrayList<Integer> firstPoint = new ArrayList<>();
        firstPoint.add(0);
        firstPoint.add(0);

        ArrayList<Integer> secondPoint = new ArrayList<>();
        secondPoint.add(1);
        secondPoint.add(0);

        ArrayList<Integer> thirdPoint = new ArrayList<>();
        thirdPoint.add(2);
        thirdPoint.add(1);

        ArrayList<Integer> fourthPoint = new ArrayList<>();
        fourthPoint.add(1);
        fourthPoint.add(2);

        ArrayList<Integer> fivePoint = new ArrayList<>();
        fivePoint.add(0);
        fivePoint.add(2);

        point.add(firstPoint);
        point.add(secondPoint);
        point.add(thirdPoint);
        point.add(fourthPoint);
        point.add(fivePoint);


        return point;
    }
    public ArrayList<ArrayList<Integer>> initThree() {
        ArrayList<ArrayList<Integer>> point = new ArrayList<>();

        ArrayList<Integer> firstPoint = new ArrayList<>();
        firstPoint.add(0);
        firstPoint.add(0);
        firstPoint.add(0);

        ArrayList<Integer> secondPoint = new ArrayList<>();
        secondPoint.add(1);
        secondPoint.add(0);
        secondPoint.add(0);

        ArrayList<Integer> thirdPoint = new ArrayList<>();
        thirdPoint.add(2);
        thirdPoint.add(1);
        thirdPoint.add(0);

        ArrayList<Integer> fourthPoint = new ArrayList<>();
        fourthPoint.add(1);
        fourthPoint.add(2);
        fourthPoint.add(0);

        ArrayList<Integer> fivePoint = new ArrayList<>();
        fivePoint.add(0);
        fivePoint.add(2);
        fivePoint.add(0);

        point.add(firstPoint);
        point.add(secondPoint);
        point.add(thirdPoint);
        point.add(fourthPoint);
        point.add(fivePoint);

        return point;

    }

    @Test

    public void testValidity() {

        Polygon polygonTwo = new Polygon(endPointsTwo);
        Polygon polygonThree = new Polygon(endPointsThree);
        boolean check = polygonTwo.isValid();
        boolean anotherCheck = polygonThree.isValid();
        then(check).isEqualTo(true);
        then(anotherCheck).isEqualTo(true);


    }

    @Test
    public void testPerimeter() {

        Polygon polygonTwo = new Polygon(endPointsTwo);
        Polygon polygonThree = new Polygon(endPointsThree);
        double elipson = 0.01;
        double expected = 6.83;
        Assert.assertEquals(expected, polygonThree.getPerimetr(), elipson);
        Assert.assertEquals(expected, polygonTwo.getPerimetr(), elipson);

    }

    @Test
    public void testArea() {

        Polygon polygonTwo = new Polygon(endPointsTwo);
        Polygon polygonThree = new Polygon(endPointsThree);
        then(polygonTwo.getArea()).isEqualTo(3.00);
        then(polygonThree.getArea()).isEqualTo(3.00);
    }

}
