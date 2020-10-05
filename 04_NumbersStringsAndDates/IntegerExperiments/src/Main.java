public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;
        int i = sumDigits(12345);
        int j = sumDigits(10);
        int k = sumDigits(5059191);
        System.out.println("=============================");
        int i1 = sumDigits2(12345);
        int j1 = sumDigits2(10);
        int k1 = sumDigits2(876547865);

        char h = '9';
        int q1 = Character.getNumericValue(h); // возвращает int значение.
        System.out.println(q1);
        int q2 = Character.digit(h , 10); // возвращает цифровое значение
        System.out.println(q2);
    }

    public static Integer sumDigits(Integer number) { //публичный, статичный, класс, название метода. ( входные параметры типа Integer)
        String numbers = Integer.toString(number);   //преобразование в строчный тип.
        int result = 0;                               // инициализация переменной для суммирования
        for (int i = 0; i < numbers.length(); i++) {  //цикл для перебора строки по символам. lenght() возвращает количество символов
            result = result + Integer.parseInt(Character.toString(numbers.charAt(i))); //результат= результат +  Integer.parseInt возврат из числа типа int(возврат строкового объекта (номер позиции в строке))
        }
        System.out.println("сумма цифр числа " + number + " = " + result);
        return result;
    }

    public static Integer sumDigits2(Integer number) {
        String numbers = Integer.toString(number);
        int result = 0;
        for (int i = 0; i < numbers.length(); i++) {
            result = result + Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        System.out.println("сумма цифр числа " + number + " =" + result);
        return result;
    }
}
