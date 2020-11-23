package Metro;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String number;
    private String name;
   // private List<Station> stations;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Line(String number, String name){
        this.number = number;
        this.name = name;
       // stations = new ArrayList<>();
    }


}
