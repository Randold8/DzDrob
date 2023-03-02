public class Calculate {
    public static<T> void addFractions(T fr1, T fr2) throws IllegalArgumentException {
        if (fr1 instanceof Fraction fraction1 && fr2 instanceof Fraction fraction2) {
            Fraction result = new Fraction();
            result.num = fraction1.num * fraction2.den + fraction2.num * fraction1.den;
            result.den = fraction1.den * fraction2.den;
            result.simplify();
            System.out.println(result.num + "/" + result.den);
        }
        else{
            throw new IllegalArgumentException("Метод работает только с двумя дробями!");
        }
    }
    public static<T> void subFractions(T fr1, T fr2) throws IllegalArgumentException {
        if (fr1 instanceof Fraction fraction1 && fr2 instanceof Fraction fraction2) {
            Fraction result = new Fraction();
            result.num = fraction1.num * fraction2.den - fraction2.num * fraction1.den;
            result.den = fraction1.den * fraction2.den;
            result.simplify();
            System.out.println(result.num + "/" + result.den);
        }
        else{
            throw new IllegalArgumentException("Метод работает только с двумя дробями!");
        }
    }
    public static<T> void mulFractions(T fr1, T fr2) throws IllegalArgumentException {
        if (fr1 instanceof Fraction fraction1 && fr2 instanceof Fraction fraction2) {
            Fraction result = new Fraction();
            result.num = fraction1.num * fraction2.num;
            result.den = fraction1.den * fraction2.den;
            result.simplify();
            System.out.println(result.num + "/" + result.den);
        }
        else{
            throw new IllegalArgumentException("Метод работает только с двумя дробями!");
        }
    }
    public static<T> void divFractions(T fr1, T fr2) throws IllegalArgumentException {
        if (fr1 instanceof Fraction fraction1 && fr2 instanceof Fraction fraction2) {
            Fraction result = new Fraction();
            result.num = fraction1.num * fraction2.den;
            result.den = fraction1.den * fraction2.num;
            result.simplify();
            System.out.println(result.num + "/" + result.den);
        }
        else{
            throw new IllegalArgumentException("Метод работает только с двумя дробями!");
        }
    }
}
