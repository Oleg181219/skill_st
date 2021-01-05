package response;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class ToDo {
    private int id;
    private String name;
    private String description;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH-mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH-mm")
    private Date timeToStart;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH-mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH-mm")
    private Date timeToEnd;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Date getTimeToStart() {
        return timeToStart;
    }

    public void setTimeToStart(Date timeToStart) {
        this.timeToStart = timeToStart;
    }

    public Date getTimeToEnd() {
        return timeToEnd;
    }

    public void setTimeToEnd(Date timeToEnd) {
        this.timeToEnd = timeToEnd;
    }
}
