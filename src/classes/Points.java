package classes;

import java.util.ArrayList;

public class Points {

    private ArrayList<ArrayList<Integer>> points;
    public Points(ArrayList<ArrayList<Integer>> points) {

        this.points = points;
    }
    public int getPoint(int indexOne, int indexTwo) {
        return points.get(indexOne).get(indexTwo);
    }
    public int getLength() {
        return points.size();
    }
}
