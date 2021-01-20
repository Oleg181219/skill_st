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
//import com.mongodb.MongoClient;
//import com.mongodb.client.AggregateIterable;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.model.Updates;
//import org.bson.BsonDocument;
//import org.bson.Document;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import static com.mongodb.client.model.Accumulators.*;
//import static com.mongodb.client.model.Aggregates.*;
//import static com.mongodb.client.model.Filters.*;
//
//public class Main {
//    public static void main(String[] args) {
//        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
//        MongoDatabase mongoDatabase = mongoClient.getDatabase("local");
//
//        //Создаем коллекцию stores и goods
//        MongoCollection<Document> stores = mongoDatabase.getCollection("stores");
//        MongoCollection<Document> goods = mongoDatabase.getCollection("goods");
//
//        //Очищаем после предыдущих экспериментов
////        stores.drop();
////        goods.drop();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        //переменная для строки введенной пользователем
//        String input = null;
//        //признак окончания цикла
//        boolean quit = false;
//
//        while (!quit) {
//            System.out.println("\nВведите команду:");
//            //читаем строку из консоли
//            try {
//                input = reader.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            //разделяем команду и параметры
//            String[] command = input.trim().split("\\s+");
//            switch (command[0].toUpperCase()) {
//                case "ДОБАВИТЬ_МАГАЗИН":
//                    //проверяем команду на корректность
//                    if (command.length != 2) {
//                        System.out.println("Некорректное название магазина!"); break; }
//                    //проверяем наличие такого же магазина в коллекции
//                    if (stores.find(BsonDocument.parse("{Name: {$eq: \"" + command[1] + "\"}}")).first() != null) {
//                        System.out.println("Такой магазин уже существует!");
//                        break;
//                    };
//                    //Создаем документ представляющий запись по одному магазину
//                    Document storesRecordDocument = new Document()
//                            .append("Name", command[1])
//                            .append("Goods", new ArrayList<>());
//                    //Вставляем документ в коллекцию
//                    stores.insertOne(storesRecordDocument);
//                    System.out.println("Ок");
//                    break;
//                case "ДОБАВИТЬ_ТОВАР":
//                    //проверяем команду на корректность
//                    if (command.length != 3) {
//                        System.out.println("Некорректное наименование товара!"); break; }
//                    //проверка цены
//                    try { Integer.parseInt(command[2]); }
//                    catch (Exception e) {
//                        System.out.println("Некорректно указана цена товара!");
//                        break;
//                    }
//                    //проверяем наличие такого же товара в коллекции
//                    if (goods.find(BsonDocument.parse("{Name: {$eq: \"" + command[1] + "\"}}")).first() != null) {
//                        System.out.println("Такой товар уже существует! Обновлена цена товара. Цена в магазинах не меняется! Товар нужно выставить снова!");
//                        goods.updateOne(eq("Name", command[1]), Updates.set("Price", Integer.parseInt(command[2])));
//                        System.out.println("Ок");
//                        break;
//                    };
//                    //Создаем документ представляющий запись по товарной позиции
//                    Document goodsRecordDocument = new Document()
//                            .append("Name", command[1])
//                            .append("Price", Integer.parseInt(command[2]));
//                    //Вставляем документ в коллекцию
//                    goods.insertOne(goodsRecordDocument);
//                    System.out.println("Ок");
//                    break;
//                case "ВЫСТАВИТЬ_ТОВАР":
//                    //проверяем команду на корректность
//                    if (command.length != 3) { System.out.println("Неверное число параметров!");; break; }
//                    //проверяем существование товара и магазина
//                    if (goods.find(BsonDocument.parse("{Name: {$eq: \"" + command[1] + "\"}}")).first() == null)
//                    { System.out.println("Нет такого товара!"); break; }
//                    if (stores.find(BsonDocument.parse("{Name: {$eq: \"" + command[2] + "\"}}")).first() == null)
//                    { System.out.println("Нет такого магазина!"); break; }
//                    //Обновляем документ коллекции stores добавлением объекта goods
//                    stores.updateOne(eq("Name", command[2]), Updates.addToSet("Goods",
//                            goods.find(BsonDocument.parse("{Name: {$eq: \"" + command[1] + "\"}}")).first()));
//                    System.out.println("Ок");
//                    break;
//                case "СТАТИСТИКА_ТОВАРОВ":
//                    //проверка корректности команды
//                    if (command.length != 1) { System.out.println("Команда не должна иметь параметров!"); break; }
//                    for (Document doc : stores.find()) {
//                        System.out.println("\nСтатистика для магазина " + doc.get("Name") + ":");
//                        //общее количество товаров в магазине, если товаров нет, то переходим к следующему магазину
//                        try {
//                            System.out.println("\nОбщее количество товаров: " + stores
//                                    .aggregate(Arrays.asList(
//                                            match(eq("Name", doc.get("Name"))),
//                                            unwind("$Goods"),
//                                            count())).first().get("count"));
//                        }
//                        catch (Exception e) {
//                            System.out.println("В магазине не выставлен ни один товар!");
//                            continue;
//                        }
//                        //средняя цена товаров в магазине
//                        System.out.println("Средняя цена товаров: " + stores
//                                .aggregate(Arrays.asList(
//                                        match(eq("Name", doc.get("Name"))),
//                                        unwind("$Goods"),
//                                        group(null, avg("average", "$Goods.Price")))).first().get("average"));
//                        //самый дорогой товар
//                        System.out.println("Стоимость самого дорогого товара: " + stores
//                                .aggregate(Arrays.asList(
//                                        match(eq("Name", doc.get("Name"))),
//                                        unwind("$Goods"),
//                                        group(null, max("maxPrice", "$Goods.Price")))).first().get("maxPrice"));
//                        //самый дешевый товар
//                        System.out.println("Стоимость самого дешевого товара: " + stores
//                                .aggregate(Arrays.asList(
//                                        match(eq("Name", doc.get("Name"))),
//                                        unwind("$Goods"),
//                                        group(null, min("minPrice", "$Goods.Price")))).first().get("minPrice"));
//                        //товары со стоимостью ниже 100
//                        System.out.println("Товары стоимостью ниже 100: ");
//                        AggregateIterable<Document> lowerPriceList = stores.aggregate(Arrays.asList(
//                                unwind("$Goods"),
//                                match(and(eq("Name", doc.get("Name")), lt("Goods.Price", 100)))));
//                        if (lowerPriceList.first() == null) System.out.println("В магазине не найдено ни одного товара стоимостью ниже 100!");
//                        for (Document lowerPriceItem : lowerPriceList) {
//                            Document nestedObject = (Document) lowerPriceItem.get("Goods");
//                            System.out.println("Наименование: " + nestedObject.get("Name") + "; Стоимость: " + nestedObject.get("Price"));
//                        }
//
//                    }
//                    break;
//                case "ВЫХОД":
//                    quit = true;
//                    break;
//                default:
//                    System.out.println("Неверная команда!");
//            }
//
//        }
//        System.out.println("Ок");
//    }
//}
