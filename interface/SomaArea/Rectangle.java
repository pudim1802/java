package SomaArea;

public class Rectangle implements Shape{
    private final double altura;
    private final double largura;

    public Rectangle(double altura,double largura){
        this.altura = altura;
        this.largura = largura;

    }


    @Override
    public double surFaceArea(){
        return altura * largura;

    }



}
