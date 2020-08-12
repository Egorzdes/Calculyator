package Calc1;


public class RomanOperations {

    public static String arabicToRoman(int value)
    {
        StringBuilder result = new StringBuilder();
        int currentvalue = value;

        while (currentvalue != 0)
        {
            RomanDigit FittingValue = RomanDigit.getFittingValue(currentvalue); //
            currentvalue -= FittingValue.arabicvalue; // из текущего значения вычти подходящее значение
            result.append(FittingValue.toString());
        }

        return result.toString();
    }
    public static boolean ProverkaOt1Do10RimskoeChislo (String value)
    { // провека ввода римских чисел от 1 до 10
        return value.equals("I") ||
                value.equals("II") ||
                value.equals("III") ||
                value.equals("IV") ||
                value.equals("V") ||
                value.equals("VI") ||
                value.equals("VII") ||
                value.equals("VIII") ||
                value.equals("IX") ||
                value.equals("X");
    }
}

enum RomanDigit {
    M(1000), CM(900), D(500), CD(400),
    C(100),  XC(90),  L(50),  XL(40),
    X(10),   IX(9),   V(5),   IV(4),
    I(1);

    int arabicvalue;
    RomanDigit(int arabicvalue) //конструктор enum RomanDigit
    {

        this.arabicvalue = arabicvalue;
    }
    int getArabicValue() { // метод возврата arabicvalue

        return this.arabicvalue;
    }

    static RomanDigit getFittingValue(int chislo) { // метод проводит поиск значений по enum, находит наименьшее значение ближайшее к введенному арабскому значению и возвращает соответствующее ему римское значение
        for (RomanDigit current: RomanDigit.values()) {
            if (current.arabicvalue <= chislo) {
                return current;
            }
        }
        return RomanDigit.I;
    }
}