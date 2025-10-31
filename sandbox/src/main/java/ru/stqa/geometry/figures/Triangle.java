package ru.stqa.geometry.figures;

public record Triangle(double a1, double b1,double c1) {

    public static double areaTriangle(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void printTriangleArea(double a, double b, double c) {
        String text = String.format("Площадь треугольника со сторонами %f, %f, %f = %f", a, b, c, areaTriangle(a, b, c));
        System.out.println(text);
    }

    public static double perimeterTriangle(double aside, double bside, double cside) {
        return aside + bside + cside;
    }

    public static void printTrianglePerimeter(double aside1, double bside1, double cside1){
        String text2 = String.format("Периметр треугольника со сторонами %f, %f, %f = %f", aside1, bside1, cside1, perimeterTriangle(aside1, bside1, cside1));
        System.out.println(text2);
    }

    public double areaTriangle() {
        double p = (this.a1 + this.b1 + this.c1) / 2;
        return Math.sqrt(p * (p - this.a1) * (p - this.b1) * (p - this.c1));
    }

    public double perimeterTriangle() {
        return this.a1+this.b1+this.c1;
    }
}