import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.mongodb.client.model.Sorts.descending;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    private static Document document;

    public static void main(String[] args) throws Exception {
        int count = 0;
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("students");
        MongoCollection<Document> collection = database.getCollection("students");
        collection.drop();
        String csvFile = "src/resources/mongo.csv";
        Scanner scanner = new Scanner(new File(csvFile));
        while (scanner.hasNext()) {
            List<String> line = Separator.parseLine(scanner.nextLine());
            document = new Document()
                    .append("Name", line.get(0))
                    .append("Age", line.get(1))
                    .append("Courses", line.get(2));
            collection.insertOne(document);
        }
        scanner.close();

        List<Document> list = collection.find().sort(descending("Age")).into(new ArrayList<>());
//        list.forEach(System.out::println);

        for (int i = 0; i < list.size(); i++) {
           if (((Integer.parseInt(list.get(i).get("Age").toString()))) > 40){
               count += 1;
           };
        }
        System.out.println(ANSI_CYAN + "Колличество студентов = " + collection.countDocuments() + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "Колличество студентов старше 40 = " + count + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Курсы самого старого студента: " + list.get(0).get("Courses") + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Имя самого молодого студента : " + list.get(list.size() - 1).get("Name") + ANSI_RESET);
    }


}