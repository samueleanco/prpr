package ch.fhnw.ch.tutorials.grundkurs2;

import java.util.ArrayList;
import java.util.Collection;

public class ShapeCollectionChallenge {

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Triangle(3,4,5));
        shapes.add(new Triangle(2,2,1));

        System.out.println(shareAreaSum(shapes));
    }
    static double shareAreaSum(Collection<Shape> shapes) {
        double sum = 0;
        for (Shape s : shapes) {
            sum+= s.area();
        }
        return sum;
    }
}
