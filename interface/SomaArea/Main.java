package SomaArea;

public class Main {

    static void main(String[] args) {

        Calculator calculator = new Calculator();

        calculator.sumSurfacaeArea(new Circle(10));
        calculator.sumSurfacaeArea(new Rectangle(6 , 5));
        int S = (int)  calculator.sumSurfacaeArea(new Square(20));



        System.out.println(S);





    }
}
