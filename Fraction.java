import static java.lang.Long.parseLong;
public class Fraction {
    static class LesserFraction {
        long num,den = 0;
    }
    long num, den = 0;
    String showable = "";
    private long findGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
    public <T> void add(T fr1) throws IllegalArgumentException {
        if (fr1 instanceof Fraction fraction1) {
            Fraction result = new Fraction();
            result.num = this.num * fraction1.den + fraction1.num * this.den;
            result.den = this.den * fraction1.den;
            result.simplify();
            System.out.println(result.num + "/" + result.den);
        }
        else{
            throw new IllegalArgumentException("Метод работает только с 1 дробью");
        }
    }
    //Simplify the fraction automatically for every object of the class
    void simplify() throws ArithmeticException{
        long gcd = findGCD(this.num, this.den);
        this.num /= gcd;
        this.den /= gcd;
        //If the denominator is negative, move the negative sign to the numerator
        if (this.den < 0) {
            this.den *= -1;
            this.num *= -1;
        }
        if (this.num == 0) {
            throw new ArithmeticException("Нельзя получить дробь если один из аргументов - ноль.");
        }
        if (this.den == 0) {
            throw new ArithmeticException("Я вам запрещаю делить на ноль.");
        }
        this.showable = this.num + "/" + this.den;
    }
    public void show() {
        System.out.println(showable);
    }
    private LesserFraction smallFraction, tempnum, tempden = null;
    private static long findPower(int y) {
        long result = 1;
        for (int i = 0; i < y; i++) {
            result *= 10;
        }
        return result;
    }
    public <T> void set(T arg){
        convertArguments(arg,1);
        if (smallFraction != null) {
            this.num = smallFraction.num;
            this.den = smallFraction.den;
        }
        simplify();
    }
    public void set() {
        this.num = 1;
        this.den = 1;
    }
    public <T> void set(T num, T den){
        this.num = convertArguments(num,2);
        if (smallFraction != null) {
            this.tempnum = smallFraction;
            smallFraction = null;
        }
        this.den = convertArguments(den,2);
        if (smallFraction != null) {
            this.tempden = smallFraction;
            smallFraction = null;
        }
        if (tempnum != null || tempden != null) {
            if (tempnum != null && tempden != null) {
                this.num = tempnum.num * tempden.den;
                this.den = tempnum.den * tempden.num;
            } else if (tempnum != null) {
                this.num = tempnum.num;
                this.den = tempnum.den * this.den;
            } else {
                this.num = this.num * tempden.den;
                this.den = tempden.num;
            }
        }

        simplify();
    }
    private <T> long convertArguments(T arg, int num) throws IllegalArgumentException {
        long result;
        String str;
        String[] splitstr;
        IllegalArgumentException conversionError = new NumberFormatException("Ввод невозможно преобразовать в дробь.");
        switch (arg.getClass().getSimpleName()) {
            case "Integer":
            case "Long":
                if (num == 1) {
                    throw conversionError;
                } else {
                    if (arg instanceof Integer){
                        result = ((Integer) arg).longValue();
                    } else {
                        result = (Long)arg;
                    }
                }
                break;
            case "Float":
            case "Double":
                if (arg instanceof Float) {
                    str = Float.toString((Float) arg);
                } else {
                    str = Double.toString((Double) arg);
                }
                splitstr = str.split("\\.");
                int power = splitstr[1].length();
                    smallFraction = new LesserFraction();
                    smallFraction.num = parseLong(splitstr[0] + splitstr[1]);
                    smallFraction.den = findPower(power);
                return 0;
            case "Fraction":
                Fraction temparg = (Fraction) arg;
                    smallFraction = new LesserFraction();
                    smallFraction.num = temparg.num;
                    smallFraction.den = temparg.den;
                return 0;
            case "String":
                str = arg.toString().replaceAll(" ", "");
                splitstr = str.split("/");
                switch (splitstr.length) {
                    case 1:
                        if (num == 1) {
                            throw conversionError;
                        } else {
                            try {
                                Integer.parseInt(splitstr[0]);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                throw new NumberFormatException("Полученную в качестве аргумента строку невозможно конвертировать в число или дробь");
                            }
                            result = parseLong(splitstr[0]);
                        }
                        break;
                    case 2:
                            smallFraction = new LesserFraction();
                            smallFraction.num = parseLong(splitstr[0]);
                            smallFraction.den = parseLong(splitstr[1]);
                            return 0;

                    default:
                        throw new IllegalArgumentException("Полученную в качестве аргумента строку невозможно конвертировать в число или дробь");
                }
                break;
            default:
                throw new IllegalArgumentException("Дробь нельзя создать с этими вводными параметрами! " + arg.getClass().getSimpleName() );
        }
        return result;

    }

}

