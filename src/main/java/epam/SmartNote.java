package epam;

import java.util.ArrayList;
import java.util.Date;

public class SmartNote {

    private ArrayList<Note> notes = new ArrayList<Note>();
    private int noteId;
    public NoteMetaList category = new NoteMetaList();
    public NoteMetaList tag = new NoteMetaList();

    public void addNote(String title, String content, Date dateCreation){
        notes.add(new Note(noteId++, title, content, dateCreation));
    }
    public void addCategory(String categoryName){
        category.addName(categoryName);
    }
    public void addTag(String tagName){
        tag.addName(tagName);
    }
    public void linkCategoryToNote(int noteId, String categoryName){
        category.addLink(noteId, categoryName);
    }

    public void linkTagToNote(int noteId, String tagName){
        tag.addLink(noteId, tagName);
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

    /**
     * Разбивает строку (text) на подстроки длинной (length)
     * и выводи в виде массива (string)
     */
    private ArrayList<String> wordWrap(String text, int length){
        ArrayList<String> string= new ArrayList<String>();
        int start=0,end=length;
        if (text.length()<length) string.add(text);
        StringBuffer str = new StringBuffer(text);
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

    public void printNotes(){
        for (Note note:notes) {
            System.out.println("\n");
            System.out.println("## Note-"+note.getId()+" ##");
            System.out.println("----------- "+note.getTitle()+" -----------");
            System.out.println("Categories: "+category.getNoteMetasById(note.getId()));
            System.out.println("\n");
            for (String con:wordWrap(note.getContent(), 100)) {
                System.out.println(con.trim());
            }
            System.out.println("\n");
            System.out.println("tags: "+tag.getNoteMetasById(note.getId()));
        }
    }
}
