import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.lookup;
import static com.mongodb.client.model.Aggregates.unwind;
import static com.mongodb.client.model.Accumulators.avg;
import static com.mongodb.client.model.Accumulators.max;
import static com.mongodb.client.model.Accumulators.min;
import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

import java.util.*;

public class MainStore {
    private final String ADD_SHOP = "ДОБАВИТЬ_МАГАЗИН";
    private final String ADD_ITEM = "ДОБАВИТЬ_ТОВАР";
    private final String SHOW_ITEM = "ВЫСТАВИТЬ_ТОВАР";
    private final String STATISTIC = "СТАТИСТИКА_ТОВАРОВ";
    private final String EXIT = "ВЫХОД";

    MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
    MongoDatabase commercialNetwork = mongoClient.getDatabase("Shop");
    //    MongoDatabase product = mongoClient.getDatabase("Product");
    MongoCollection<Document> shopCollection = commercialNetwork.getCollection("Shop");
    MongoCollection<Document> productCollection = commercialNetwork.getCollection("Product");
    Block<Document> printBlock = document -> System.out.println(document.toJson());



    public void chooseCommand(String incomingCommandName) {
        String nameProduct = "";
/**
 * Добавление магазина
 * shopName - название магазина
 */
        if (incomingCommandName.contains(ADD_SHOP)) {
            String shopName = incomingCommandName.substring(16);
            addShop(shopName);
        }
/**
 * Добавление товара
 * nameProduct - название товара
 * productPrice - цена товара
 */
        if (incomingCommandName.contains(ADD_ITEM)) {
            String tempProductName = incomingCommandName.substring(14);
            for (int i = 0; i < tempProductName.length(); i++) {
                if (Character.isAlphabetic(tempProductName.charAt(i))) {
                    nameProduct = nameProduct.concat(Character.toString(tempProductName.charAt(i)));
                }
            }
            int productPrice = Integer.parseInt(tempProductName.substring(nameProduct.length()));
            addProduct(nameProduct, productPrice);
        }
/**
 * Выставление товара в магазине
 * shopName - название магазина
 * nameProductTransfer - название товара
 * productPrice - цена товара
 */
        if (incomingCommandName.contains(SHOW_ITEM)) {
            int x = 0;
            String a = incomingCommandName.substring(14);
            for (int i = 1; i < a.length(); i++) {
                if (Character.isUpperCase(a.charAt(i))) {
                    x = i;
                }
            }
            String shopName = a.substring(1, x);
            String nameProductTransfer = a.substring(x);
            transferProductToShop(shopName, nameProductTransfer);
        }
        if (incomingCommandName.contains(STATISTIC)) {
            productStatistics();

        }

    }


    public void addProduct(String nameProduct, Integer productPrice) {
        List<Document> documentsProduct = new ArrayList<Document>();
        Document doc1 = new Document("name", nameProduct).append("productPrice", productPrice);
        documentsProduct.add(doc1);
        productCollection.insertOne(doc1);
        productCollection.find().forEach(printBlock);
    }

    public void addShop(String shopName) {
        List<Document> documents = new ArrayList<Document>();
        Document doc1 = new Document("name", shopName)
                .append("product", Collections.emptyList());
        documents.add(doc1);
        shopCollection.insertOne(doc1);
        shopCollection.find().forEach(printBlock);
    }

    public void transferProductToShop(String shopName, String nameProduct) {

        shopCollection.updateOne(eq("name", shopName),
                combine(set("name", shopName), push("product", nameProduct)),
                new UpdateOptions().upsert(true).bypassDocumentValidation(true));

        shopCollection.find(eq("name", shopName)).forEach(printBlock);
    }

    public void productStatistics() {
        AggregateIterable<Document> result = shopCollection
                .aggregate(Arrays.asList(lookup("Product", "product", "name", "lookarray"),
                        unwind("$lookarray"),
                        group("$name", sum("count", 1L),
                                avg("avg", "$lookarray.productPrice"),
                                max("max", "$lookarray.productPrice"),
                                min("min", "$lookarray.productPrice"))));

        for (Document document : result) {
            System.out.println(document);
        }


    }
}
