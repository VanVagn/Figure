package github.com.classes;
import java.util.ArrayList;

public class Points {

    private ArrayList<ArrayList<Integer>> points;

    public Points(ArrayList<ArrayList<Integer>> points) {

        this.points = points;
    }

    public int getPoint(int indexOne, int indexTwo) {
        return points.get(indexOne).get(indexTwo);
    }

    public int getLengthPoints() {
        return points.size();
    }
    public int getLengthCoordinates(int index) {
        return points.get(index).size();
    }
}
