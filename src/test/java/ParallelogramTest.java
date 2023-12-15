import github.com.classes.Points;
import github.com.figure.classes.Parallelogram;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class ParallelogramTest {
    private Points endPoints = new Points(init());
    public ArrayList<ArrayList<Integer>> init() {
        ArrayList<ArrayList<Integer>> point = new ArrayList<>();

        ArrayList<Integer> firstPoint = new ArrayList<>();
        firstPoint.add(0);
        firstPoint.add(0);

        ArrayList<Integer> secondPoint = new ArrayList<>();
        secondPoint.add(3);
        secondPoint.add(0);

        ArrayList<Integer> thirdPoint = new ArrayList<>();
        thirdPoint.add(6);
        thirdPoint.add(4);

        ArrayList<Integer> fourthPoint = new ArrayList<>();
        fourthPoint.add(3);
        fourthPoint.add(4);

        point.add(firstPoint);
        point.add(secondPoint);
        point.add(thirdPoint);
        point.add(fourthPoint);

        return point;

    }
    @Test
    @DisplayName("testValidity")
    public void testValidity() {

        Parallelogram parallelogram = new Parallelogram(endPoints);
        boolean check = parallelogram.isValid();
        then(check).isEqualTo(true);

    }

    @Test
    @DisplayName("testPerimeter")
    public void testPerimeter() {

        Parallelogram parallelogram = new Parallelogram(endPoints);
        then(parallelogram.getPerimetr()).isEqualTo(16.00);
    }

    @Test
    @DisplayName("testArea")
    public void testArea() {

        Parallelogram parallelogram = new Parallelogram(endPoints);
        then(parallelogram.getArea()).isEqualTo(12.00);
    }
}

