import java.util.Scanner;

/**
 * ДОБАВИТЬМАГАЗИН Девяточка
 * ДОБАВИТЬТОВАР Вафли 54
 * ВЫСТАВИТЬТОВАР Вафли Девяточка
 * ================================
 * СТАТИСТИКА_ТОВАРОВ
 * ---общее количество товаров,
 * ---среднюю цену товара,
 * ---самый дорогой и самый дешевый товар,
 * ---количество товаров дешевле 100 рублей.
 */
public class Main {
    public static void main(String[] args) {
        String enterCommand = "null";
        while (!enterCommand.equals("ВЫХОД")) {
            Scanner reader = new Scanner(System.in);
            enterCommand = reader.nextLine();
            MainStore mainStore = new MainStore();
            mainStore.chooseCommand(enterCommand);
        }
    }
}
