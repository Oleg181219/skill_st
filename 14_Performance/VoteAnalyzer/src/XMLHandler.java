import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.concurrent.ForkJoinPool;

public class XMLHandler extends DefaultHandler {

    //    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
//    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
//    private static HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
    private static ForkJoinPool forkJoinPool = new ForkJoinPool(2);
    private static ForkTask task;
    String name = "";
    String birthDay = "";
    String station = "";
    String time = "";
    Boolean endVoter = false;
    Boolean endVisit = false;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equals("voter")) {
                name = attributes.getValue("name");
                birthDay = attributes.getValue("birthDay");
                endVoter = true;
            }
            if (qName.equals("visit")) {
                station = attributes.getValue("station");
                time = attributes.getValue("time");
                endVisit = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (endVisit && endVoter) {
            try {
                DBConnection.countVoter(name, birthDay, station, time);
                endVoter = false;
                endVisit = false;
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (DBConnection.getInsertQueryLenth() > 1048576) {
                while ((task != null) && !task.isDone()) {
                }
                try {
                    task = new ForkTask(DBConnection.getInsertQuery());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                forkJoinPool.execute(task);
            }
        }
    }


    @Override
    public void endDocument() throws SAXException {
        try {
            DBConnection.executeMultiInsert(DBConnection.getInsertQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

//    public void printWorkTimes() {
//        System.out.println("Voting station work times: ");
//        for (Integer votingStation : voteStationWorkTimes.keySet()) {
//            WorkTime workTime = voteStationWorkTimes.get(votingStation);
//            System.out.println("\t" + votingStation + " - " + workTime);
//        }
//    }

}
