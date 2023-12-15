import github.com.classes.Points;
import github.com.figure.classes.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class SquareTest {
    private Points endPoints = new Points(init());

    public ArrayList<ArrayList<Integer>> init() {
        ArrayList<ArrayList<Integer>> point = new ArrayList<>();

        ArrayList<Integer> firstPoint = new ArrayList<>();
        firstPoint.add(0);
        firstPoint.add(0);

        ArrayList<Integer> secondPoint = new ArrayList<>();
        secondPoint.add(1);
        secondPoint.add(0);

        ArrayList<Integer> thirdPoint = new ArrayList<>();
        thirdPoint.add(1);
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

        Square square = new Square(endPoints);
        boolean check = square.isValid();
        then(check).isEqualTo(true);

    }

    @Test
    @DisplayName("testPerimeter")
    public void testPerimeter() {

        Square square = new Square(endPoints);
        then(square.getPerimetr()).isEqualTo(4.00);
    }

    @Test
    @DisplayName("testArea")
    public void testArea() {

        Square square = new Square(endPoints);
        then(square.getArea()).isEqualTo(1.00);
    }

}

