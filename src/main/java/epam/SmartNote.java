package epam;

import java.util.ArrayList;
import java.util.Date;

public class SmartNote {

    private ArrayList<Note> notes = new ArrayList<Note>();
    private int noteId;
    public NoteMetaList category, tag;

    public void addNote(String title, String content, Date dateCreation){
        notes.add(new Note(noteId++, title, content, dateCreation));
    }
    public void addCategory(String categoryName){
        category.setName(categoryName);
    }
    public void addTag(String tagName){
        tag.setName(tagName);
    }
    public void linkCategoryToNote(int noteId, String categoryName){
        category.setLink(noteId, categoryName);
    }

    public void linkTagToNote(int noteId, String tagName){
        tag.setLink(noteId, tagName);
    }
    public ArrayList<Note> getNotes(){
        return notes;
    }
    public String getCategoryById(int id){
        return category.getMetaNameById(id);
    }
    public String getTagById(int id){
        return tag.getMetaNameById(id);
    }
    /*public ArrayList<String> getNoteCategoryById(){
        return String[];
    }*/
}
