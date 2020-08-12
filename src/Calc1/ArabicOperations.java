package Calc1;

public class ArabicOperations {
    public static int romanToArabic(String value)
    {
        return switch (value)
                {
                    case "I" -> 1;
                    case "II" -> 2;
                    case "III" -> 3;
                    case "IV" -> 4;
                    case "V" -> 5;
                    case "VI" -> 6;
                    case "VII" -> 7;
                    case "VIII" -> 8;
                    case "IX" -> 9;
                    case "X" -> 10;
                    default -> 0;
                };

    }




    public static boolean ProverkaOt0Do10ArabskoeChislo (int value) // проверка значения ввода Арабского числа от 0 до 10 включительно
    {
        return value < 11 && value > 0;
    }
}
