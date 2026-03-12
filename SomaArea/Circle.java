package SomaArea;

public class Circle implements Shape{
    private final double r;



    public Circle(double r){
        this.r = r;
    }



    @Override
    public double surFaceArea(){
        double result = (r*r)* 3;
        return result;

    }


}
