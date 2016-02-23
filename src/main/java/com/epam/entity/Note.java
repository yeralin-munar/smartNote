package com.epam.entity;

import com.epam.entity.BaseEntity;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by Munar on 22.02.2016.
 */
public class Note extends BaseEntity {
    private String title;
    private String content;
    private ArrayList<String> category = new ArrayList<>();
    private ArrayList<String> tag = new ArrayList<>();
    private DateTime create;
    private DateTime modified;

    public Note(int id, String title, String content, String[] category, String[] tag, DateTime create, DateTime modified){
        super(id);
        this.title = title;
        this.content = content;
        setCategory(category);
        setTag(tag);
        this.create = create;
        this.modified = modified;
    }
    public Note(int id, String title, String content, String[] category, String[] tag, DateTime create){
        super(id);
        this.title = title;
        this.content = content;
        setCategory(category);
        setTag(tag);
        this.create = create;
    }
    public Note(int id, String title, String content, String category, String tag, DateTime create){
        super(id);
        this.title = title;
        this.content = content;
        setCategory(category);
        setTag(tag);
        this.create = create;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String getTitle() {
        return this.title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String getContent() {
        return this.content;
    }

    private void setCategory(String[] category) {
        Collections.addAll(this.category, category);
    }
    public void setCategory(String category) {
        this.category.add(category);
    }

    private ArrayList<String> getCategory() {
        return this.category;
    }

    private void setTag(String[] tag) {
        Collections.addAll(this.tag, tag);
    }

    private void setTag(String tag) {
        this.tag.add(tag);
    }

    private ArrayList<String> getTag() {
        return this.tag;
    }

    public void setCreate(DateTime create) {
        this.create = create;
    }

    private DateTime getCreate() {
        return this.create;
    }

    private void setModified(DateTime modified) {
        this.modified = modified;
    }

    private DateTime getModified() {
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
        String create = getCreate()!=null ? getCreate().toString() : "";
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
