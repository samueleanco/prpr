package ch.fhnw.ch.tutorials.grundkurs2;

import java.util.ArrayList;

public class StreamShapeChallenge {

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Triangle(3,4,5));
        shapes.add(new Triangle(2,2,1));

        double sum = shapes.stream()
                .mapToDouble(Shape::area)
                .sum();

        System.out.println(sum);
    }
}
