
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();
        //Определяем арифметическое действие:
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (exp.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        //Если не нашли арифметического действия, завершаем программу
        if (actionIndex == -1) {
            System.out.println("Некорректное выражение");
            return;
        }
        //"2+4".split("\\+")-> {"2", "4"}
        String[] data = exp.split(regexActions[actionIndex]);
        //Определяем, находятся ли числа в одном формате (оба римские или оба арабские)
        if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            int a, b;
            //определяем, римские ли это числа
            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman) {
                //Если римские, то конвертируем их в арабские
                //X+V
                //X - 10
                //V - 5
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            } else {

                //конвертируем арабские числа из строки в число
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }

                //выполняем с числами арифметическое действие
                int result;
                switch (actions[actionIndex]) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    default:
                        result = a / b;
                        break;
                }

                //15->XV
                if (isRoman) {
                    //Если числа были римские, возвращаем результат в римском числе
                    System.out.println(converter.intToRoman(result));
                } else {
                    //Если числа были арабские, возвращаем результат в арабском числе
                    System.out.println(result);
                }


            }else{
                System.out.println("Числа должны быть в одном формате");
        }

    }
}
