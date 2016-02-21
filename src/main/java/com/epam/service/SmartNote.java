package com.epam.service;

import com.epam.entity.Category;
import com.epam.entity.Note;
import com.epam.entity.Tag;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Munar on 22.02.2016.
 */
public class SmartNote {
    private ArrayList<Tag> tags = new ArrayList<Tag>();
    private ArrayList<Category> categories = new ArrayList<Category>();
    private ArrayList<Note> notes = new ArrayList<Note>();
    private int tagId;
    private int categoryId;
    private int noteId;

    public void addTag(String name){
        tags.add(new Tag(tagId++,name));
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void addCategory(String name){
        categories.add(new Category(categoryId++,name));
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void addNote(String title, String content, String[] category, String[] tag, SimpleDateFormat create, SimpleDateFormat modified){
        notes.add(new Note(noteId, title, content, category, tag, create, modified));
    }
}
