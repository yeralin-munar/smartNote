package epam;

import javafx.scene.chart.PieChart;

import java.util.Date;

public class Note {
    int id;
    String header, text, importance;
    Date dateCreation, dateChange;

    public int getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public String getText() {
        return text;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Date getDateChange() {
        return dateChange;
    }
}
