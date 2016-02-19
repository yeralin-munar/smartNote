package epam;

import epam.fabric.NotesCreator;

/**
 * Created by Munar on 18.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        NotesCreator creator = new NotesCreator();
        creator.create();
        creator.printNotes();
    }
}
