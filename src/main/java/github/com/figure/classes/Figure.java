package github.com.figure.classes;

import github.com.constains.Constants;
import github.com.classes.Points;

public class Figure {

    protected Points points;

    public Figure(Points points) {
        this.points = points;
    }

    public boolean isValid() {
        System.out.println("The figure is figure");
        return true;
    }

    public void square() {
        System.out.println("The figure has no area");
    }

    public void perimeter() {
        System.out.println("The figure has no perimeter");
    }

}
