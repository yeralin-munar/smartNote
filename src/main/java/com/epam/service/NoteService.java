package com.epam.service;

import com.epam.entity.Category;
import com.epam.entity.Note;
import com.epam.entity.Tag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Munar on 22.02.2016.
 */
public class NoteService {

    public NoteService(){

    }

    public List<Note> findText(List<Note> notes, String text){
        List<Note> newNotes = new ArrayList<>();
        int i=0;
        for (Note note:notes){
            if (note.findInContent(text)){
                newNotes.add(note);
                i++;
            }
        }
        return newNotes;
    }

    public List<Note> getCategoryNotes(List<Note> notes, String catName){
        List<Note> newNotes = new ArrayList<>();
        for (Note note:notes){
            if (note.checkCategory(catName)) newNotes.add(note);
        }
        return newNotes;
    }

    public List<Note> getTagNotes(List<Note> notes, String tagName){
        List<Note> newNotes = new ArrayList<>();
        for (Note note:notes){
            if (note.checkTag(tagName)) newNotes.add(note);
        }
        return newNotes;
    }

    public List<Note> sortNotesByTitle(List<Note> notes){
        Collections.sort(notes, new Comparator<Note>(){
            //@Override
            public int compare(Note a, Note b) {
                return a.getTitle().compareTo(b.getTitle());
            }
        });
        return notes;
    }

    public List<Note> sortNotesByDate(List<Note> notes){
        Collections.sort(notes, new Comparator<Note>(){
            //@Override
            public int compare(Note a, Note b) {
                return a.getCreated().compareTo(b.getCreated());
            }
        });
        return notes;
    }

}
