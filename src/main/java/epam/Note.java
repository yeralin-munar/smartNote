package epam;

import javafx.scene.chart.PieChart;

import java.util.Date;

public class Note {
    private int id;
    private String title, content, importance;
    private Date dateCreation, dateEdit;

    Note (int id, String title, String content, Date dateCreation){
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateCreation = dateCreation;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Date getDateChange() {return dateEdit;}


    public void print(){
        System.out.println("----------- "+this.getTitle()+" -----------");
        //System.out.println("Category: "+this.getCategoryById());
        System.out.println("\n"+this.getContent()+"\n");
        System.out.println("");
    }
}
