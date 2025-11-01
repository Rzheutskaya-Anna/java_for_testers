package ru.stqa.geometry.figures;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(12, new Triangle(3.0, 4.0, 5.0).perimeterTriangle());
    }

    @Test
    void canCalculateArea() {
        var s = new Triangle(3.0, 4.0, 5.0);
        double result = s.areaTriangle();
        Assertions.assertEquals(6, result);
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-3.0, 4.0, 5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {

        }
    }

    @Test
    void cannotCreateTriangleWithInvalidSides() {
        try {
            new Triangle(1.0, 4.0, 15);
            Assertions.fail();
        } catch (IllegalArgumentException exception){
        }
    }

    @Test
    void canCreateValidTriangle() {
        try {
            new Triangle(3.0, 4.0, 5.0);
        } catch (IllegalArgumentException e) {
            Assertions.fail("Valid triangle should not throw exception");
        }
    }

}