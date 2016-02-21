package com.epam.entity;

import com.epam.entity.BaseEntity;

import java.text.SimpleDateFormat;

/**
 * Created by Munar on 22.02.2016.
 */
public class Note extends BaseEntity {
    private String title;
    private String content;
    private String[] category;
    private String[] tag;
    private SimpleDateFormat create;
    private SimpleDateFormat modified;

    public Note(int id, String title, String content, String[] category, String[] tag, SimpleDateFormat create, SimpleDateFormat modified){
        super(id);
        this.title = title;
        this.content = content;
        this.category = category;
        this.tag = tag;
        this.create = create;
        this.modified = modified;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }
    public void setCategory(String category) {
        this.category[this.category.length] = category;
    }

    public String[] getCategory() {
        return category;
    }

    public void setTag(String[] tag) {
        this.tag = tag;
    }

    public void setTag(String tag) {
        this.tag[this.tag.length] = tag;
    }

    public String[] getTag() {
        return tag;
    }

    public void setCreate(SimpleDateFormat create) {
        this.create = create;
    }

    public SimpleDateFormat getCreate() {
        return create;
    }

    public void setModified(SimpleDateFormat modified) {
        this.modified = modified;
    }

    public SimpleDateFormat getModified() {
        return modified;
    }
}
