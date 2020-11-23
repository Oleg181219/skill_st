import Metro.Line;
import Metro.Station;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class MoscowMetro {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public static void main(String[] args) throws IOException {
        String numLine = null;
        ArrayList<Station> stations = new ArrayList<>();
        Line lines;
        ArrayList<String> demoLine = new ArrayList<>();
        ArrayList<Line> line = new ArrayList<>();
        ArrayList<Cloneable> msKMetro = new ArrayList<>();
        HashMap<String, ArrayList<String>> stationMsk = new HashMap<>();

        try {
            Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
            Elements links = doc.select("span[class]");
            String string = links.toString();

            String[] strings = string.split("\n");

            for (int i = 0; i < strings.length; i++) {

                if (strings[i].contains("data-line=\"")) {
                    String[] lineString = strings[i].split("\"");
                    String lineName = lineString[4].substring(lineString[4].indexOf('>') + 1, lineString[4].indexOf('<'));
                    numLine = lineString[3];
                    demoLine.add(numLine);
                    lines = new Line(numLine, lineName);
                    line.add(lines);
                }

                if (strings[i].contains("<span class=\"name\"")) {
                    String stationName = strings[i].substring(strings[i].indexOf('>') + 1, strings[i].lastIndexOf('<'));
                    Station station = new Station(stationName, numLine);
                    stations.add(station);
                }
            }
            for (String temp : demoLine) {
                ArrayList<String> temp2 = new ArrayList<>();
                for (int i = 0; i < stations.size(); i++) {
                    if (temp.equals(stations.get(i).getLine())) {
                        temp2.add(stations.get(i).getName());
                    }
                }
                stationMsk.put(temp, temp2);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject obj = new JSONObject();
        obj.put("line", line);
        obj.put("station ", stationMsk);
        obj.put("demoLine", stations);// добавленно для мыслей по формированию переходов
        String json = GSON.toJson(obj);

        try (FileWriter file = new FileWriter("src/main/resources/map2.json")) {

            file.write(json);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


        msKMetro.add(stationMsk);
        msKMetro.add(line);

        try (FileWriter file = new FileWriter("src/main/resources/map.json")) {
            file.write(GSON.toJson(msKMetro));
        }

    }
}

