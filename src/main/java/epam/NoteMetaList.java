package epam;


import java.util.ArrayList;

abstract class NoteMetaList {
    ArrayList<MetaListName> MetaListNames = new ArrayList<MetaListName>();
    ArrayList<MetaListLink> MetaListLinks = new ArrayList<MetaListLink>();

    public void setName(String name) {
        MetaListNames.add(new MetaListName(name));
    }

    public void setLink(int note_id, String metaName) {
        MetaListLinks.add(new MetaListLink(note_id, MetaListNames.indexOf(metaName)));
    }
}
