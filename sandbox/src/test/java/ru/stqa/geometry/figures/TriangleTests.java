package ru.stqa.geometry.figures;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test

    void canCalculatePerimeter(){
        Assertions.assertEquals(12, Triangle.perimeterTriangle(3,4,5));
    }

    @Test

    void canCalculateSquare(){
        Assertions.assertEquals(6, Triangle.TriangleArea(3,4,5, 6));
    }
}
