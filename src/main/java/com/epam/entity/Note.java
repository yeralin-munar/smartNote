package com.epam.entity;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Munar on 22.02.2016.
 */
public class Note extends BaseEntity {
    private String title;
    private String content;
    private ArrayList<String> category = new ArrayList<>();
    private ArrayList<String> tag = new ArrayList<>();
    private DateTime created;
    private DateTime modified;

    public Note(int id, String title, String content, String[] category, String[] tag, DateTime create, DateTime modified){
        super(id);
        this.title = title;
        this.content = content;
        setCategories(category);
        setTags(tag);
        this.created = create;
        this.modified = modified;
    }
    public Note(int id, String title, String content, String[] category, String[] tag, DateTime creted){
        super(id);
        this.title = title;
        this.content = content;
        setCategories(category);
        setTags(tag);
        this.created = creted;
    }
    public Note(int id, String title, String content, String category, String tag, DateTime created){
        super(id);
        this.title = title;
        this.content = content;
        addCategory(category);
        addTag(tag);
        this.created = created;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setCategories(String[] category) {
        Collections.addAll(this.category, category);
    }
    public void addCategory(String category) {
        this.category.add(category);
    }

    public ArrayList<String> getCategory() {
        return this.category;
    }

    public void setTags(String[] tag) {
        Collections.addAll(this.tag, tag);
    }

    public void addTag(String tag) {
        this.tag.add(tag);
    }

    public ArrayList<String> getTag() {
        return this.tag;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public DateTime getCreated() {
        return this.created;
    }

    public void setModified(DateTime modified) {
        this.modified = modified;
    }

    public DateTime getModified() {
        return this.modified;
    }

    public boolean checkCategory(String categoryName){
        for (String cat: this.category){
            if (cat.contains(categoryName)) return true;
        }
        return false;
    }

    public boolean checkTag(String tagName){
        for (String tag: this.tag){
            if (tag.contains(tagName)) return true;
        }
        return false;
    }

    public boolean findInContent(String text){
        return this.content.contains(text);
    }

    /**
     * Разбивает строку (text) на подстроки длинной (length)
     * и выводи в виде массива (string)
     */
    private ArrayList<String> wordWrap(String text, int length){
        ArrayList<String> string= new ArrayList<>();
        int start=0,end=length;
        if (text.length()<length) string.add(text);
        StringBuilder str = new StringBuilder(text);
        while (str.length() > length){
            //int p=str.indexOf(".",end),c=str.indexOf(",",end),s=str.indexOf(" ",end); //c -comma, p - point, s - space
            String[] split = {" ",",","."};

            int min=str.subSequence(start,end).toString().lastIndexOf(split[0]);
            for (String spl:split) {
                int sp = str.subSequence(start,end).toString().lastIndexOf(spl,end);
                if (sp == min) {min = sp; break;}
                if (sp != -1 && sp > min) min = sp;

            }
            end = min;

            string.add(str.subSequence(start,end).toString());
            str.delete(start,end);
            if (str.length() < length){
                end = str.length();
                string.add(str.subSequence(start,end).toString());
                break;
            }

        }
        return string;
    }

    public void printNote(){
        String create = getCreated()!=null ? getCreated().toString() : "";
        String modified = getModified() != null ? getModified().toString() : "";
        System.out.println("\n");
        System.out.println("## Note-"+getId()+" ##  -- "+create+"\nModified:"+modified);
        System.out.println("----------- "+getTitle()+" -----------");
        System.out.println("Categories: "+getCategory());
        System.out.println("\n");
        for (String con:wordWrap(getContent(), 100)) {
            System.out.println(con.trim());
        }
        System.out.println("\n");
        System.out.println("tags: "+getTag());
    }
}
