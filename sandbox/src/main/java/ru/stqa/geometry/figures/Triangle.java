package ru.stqa.geometry.figures;

public class Triangle {
    public static void printTriangleArea(double a1, double b1, double c1) {
        double s = (a1+b1+c1)/2;
        String text = String.format("Площадь треугольника со сторонами %f, %f, %f = %f", a1, b1, c1, TriangleArea(a1, b1, c1, s));
        System.out.println(text);
    }

    public static double TriangleArea(double a1, double b1, double c1, double s) {
        return Math.sqrt(s * (s - a1) * (s - b1) * (s - c1));
    }

    public static void printTrianglePerimeter(double side1, double side2, double side3){
        String text2 = String.format("Периметр треугольника со сторонами %f, %f, %f = %f", side1, side2, side3, perimeterTriangle(side1, side2, side3));
        System.out.println(text2);
}

    public static double perimeterTriangle(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }
}
