import github.com.classes.Points;
import github.com.figure.classes.Rectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class RectangleTest {
    private Points endPoints = new Points(init());
    public ArrayList<ArrayList<Integer>> init() {
        ArrayList<ArrayList<Integer>> point = new ArrayList<>();

        ArrayList<Integer> firstPoint = new ArrayList<>();
        firstPoint.add(0);
        firstPoint.add(0);

        ArrayList<Integer> secondPoint = new ArrayList<>();
        secondPoint.add(2);
        secondPoint.add(0);

        ArrayList<Integer> thirdPoint = new ArrayList<>();
        thirdPoint.add(2);
        thirdPoint.add(1);

        ArrayList<Integer> fourthPoint = new ArrayList<>();
        fourthPoint.add(0);
        fourthPoint.add(1);

        point.add(firstPoint);
        point.add(secondPoint);
        point.add(thirdPoint);
        point.add(fourthPoint);

        return point;

    }
    @Test
    @DisplayName("testValidity")
    public void testValidity() {

        Rectangle rectangle = new Rectangle(endPoints);
        boolean check = rectangle.isValid();
        then(check).isEqualTo(true);

    }

    @Test
    @DisplayName("testPerimeter")
    public void testPerimeter() {

        Rectangle rectangle = new Rectangle(endPoints);
        then(rectangle.getPerimetr()).isEqualTo(6.00);
    }

    @Test
    @DisplayName("testArea")
    public void testArea() {

        Rectangle rectangle = new Rectangle(endPoints);
        then(rectangle.getArea()).isEqualTo(2.00);
    }
}
