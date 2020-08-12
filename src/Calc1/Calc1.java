package Calc1;
import java.util.*;
import java.io.IOException;

import static Calc1.RomanOperations.*;
import static Calc1.ArabicOperations.*;
public class Calc1 {

    public static int operation(int a, int b, String op)
    { // метод в котором подаем два числа и операнд
        return switch (op)
                {
                    case "*" -> a * b;
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "/" -> a / b;
                    default -> 0;
                };

    }


    public static boolean checkChislo(String string){ // проверка ввода числа
        try
        {
            Integer.parseInt(string); // преобразует строку string в число
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public static boolean ProverkaOperanda (String value)
    {
        return value.equals("*")  || value.equals("/") || value.equals("+") || value.equals("-");
    } // проверка операнда на соответсвие поданным значениям

    public static boolean ProverkaKolichestvaChisel(String[] value)
    {
        return value.length > 3;
    } // проверка длины строки ввода
    public static void main(String[] args)throws IOException
    {
        Scanner sc = new Scanner(System.in);
        Calc1 q = new Calc1();

        String input = sc.nextLine();
        String[] strings = input.split("\\s"); // парсим строку на элементы и сохраняем в массив
        if (ProverkaOperanda(strings[1]) == false) // если операнд не подходит под заданные значения
        {
            throw new IllegalArgumentException("Неверный операнд!!!"); // выдай исключение
        }
        if (ProverkaKolichestvaChisel(strings)) //если количество чисел проходят проверку
        {

            throw new IllegalArgumentException("Неверный формат ввода!!!");
        }
        if (checkChislo(strings [0]) && checkChislo(strings [2])) //проверка на - являются ли оба значения числами?
        {
            if ((ProverkaOt0Do10ArabskoeChislo(Integer.parseInt(strings[0])) &&
                    ProverkaOt0Do10ArabskoeChislo(Integer.parseInt(strings[2]))) == false) // проверка входят ли оба значения в диапозон от 0 до 10 арабсиких чисел
            {
                throw new IllegalArgumentException("Неверный формат ввода!!!"); // вывод исключения при несоответствии с вышеуказанными проверками
            }
            else
            {
                System.out.println(operation(Integer.parseInt(strings[0]), Integer.parseInt(strings[2]), strings[1])); //вывод результата на экран
            }
        }
        else if ((checkChislo(strings[0]) == false && checkChislo(strings[2]))
                || (checkChislo(strings[2]) == false && checkChislo(strings[0]))) // проверка вариаций (первое не число && второе число, второе не число && первое число)
        {
            throw new IllegalArgumentException("Неверный формат ввода!!!"); //вывод исключения при несоответсвии с вышеуказанной проверкой
        }
        else if ((checkChislo(strings[0]) == false && checkChislo(strings[2]) == false)) // если оба значения не арабские числа , а римские
        {
            if (ProverkaOt1Do10RimskoeChislo(strings[0]) && ProverkaOt1Do10RimskoeChislo(strings[2])) // и эти числа входят в диапозон от 1 до 10 римских значений
            {
                System.out.println(arabicToRoman(operation(romanToArabic(strings [0]), romanToArabic(strings [2]),strings[1])));
            }
            else
            {
                throw new IllegalArgumentException("Неверный формат ввода!!!"); // вывод исключения при несоответствии с вышеуказанными проверками
            }
        }

    }}


