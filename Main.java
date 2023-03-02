public class Main {
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();
        Fraction fraction3 = new Fraction();
        fraction1.set(2.7,"1/5");
        fraction2.set(fraction1);
        fraction3.set();
        fraction1.show();
        fraction2.show();
        fraction3.show();
        Calculate.addFractions(fraction1,fraction2);
        Calculate.subFractions(fraction1,fraction2);
        Calculate.mulFractions(fraction1,fraction2);
        Calculate.divFractions(fraction1,fraction2);
    }

}