package com.epam.service;

import com.epam.entity.Category;
import com.epam.entity.Note;
import com.epam.entity.Tag;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Munar on 22.02.2016.
 */
public class SmartNote {
    private ArrayList<Tag> tags = new ArrayList<>();
    private ArrayList<Category> categories = new ArrayList<>();
    private ArrayList<Note> notes = new ArrayList<>();
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

    public void addNote(String title, String content, String[] category, String[] tag, DateTime create, DateTime modified){
        notes.add(new Note(noteId++, title, content, category, tag, create, modified));
    }
    public void addNote(String title, String content, String[] category, String[] tag, DateTime create){
        notes.add(new Note(noteId++, title, content, category, tag, create));
    }
    public void addNote(String title, String content, String category, String tag, DateTime create){
        notes.add(new Note(noteId++, title, content, category, tag, create));
    }

    public ArrayList<Note> getNotes(){
        return notes;
    }

    public void findText(String text){
        int i=0;
        for (Note note:notes){
            if (note.findInContent(text)){
                note.printNote();
                i++;
            }
            if (i==0) System.out.println("Не найден");
        }
    }

    public void getCategoryNotes(String catName){
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("================================================================");
        System.out.println("-----------------   Записи категории "+ catName+" -------------------");
        System.out.println("================================================================");
        for (Note note:notes){
            if (note.checkCategory(catName)) note.printNote();
        }
    }

    public void getTagNotes(String tagName){
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("================================================================");
        System.out.println("-----------------   Записи тэга "+ tagName+" -------------------");
        System.out.println("================================================================");
        for (Note note:notes){
            if (note.checkTag(tagName)) note.printNote();
        }
    }

    public void sortNotesByTitle(){
        Collections.sort(notes, new Comparator<Note>(){
            //@Override
            public int compare(Note a, Note b) {
                return a.getTitle().compareTo(b.getTitle());
            }
        });
    }

    public void sortNotesByDate(){
        Collections.sort(notes, new Comparator<Note>(){
            //@Override
            public int compare(Note a, Note b) {
                return a.getCreate().compareTo(b.getCreate());
            }
        });
    }

}
