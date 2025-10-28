package ru.stqa.geometry.figures;

public record Square(double side) {

    public static void printSquareArea(Square s) {
        System.out.println(String.format("Площадь квадрата со стороной %f = %f", s.side,  s.squareArea()));
    }




    public double squareArea() {
        return this.side * this.side;
    }

    public double perimeter() {
        return 4 * this.side;
    }
}
