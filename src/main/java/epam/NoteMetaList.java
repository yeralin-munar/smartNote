package epam;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

abstract class NoteMetaList {
    private ArrayList<MetaListName> MetaListNames = new ArrayList<MetaListName>();
    private ArrayList<MetaListLink> MetaListLinks = new ArrayList<MetaListLink>();
    private int nameId, linkId;
    public void setName(String name) {
        MetaListNames.add(new MetaListName(nameId++,name));
    }

    public void setLink(int note_id, String metaName) {
        int metaId = getMetaIdByName(metaName);
        if (metaId != -1) MetaListLinks.add(new MetaListLink(linkId++ ,note_id, metaId));
        else System.out.printf("Can't setLink by %s, because of absense this meta in DataBase",metaName);
    }

    private String getMetaNameById(int id){
        for (MetaListName meta: MetaListNames) {
            if (id == meta.getId()) return meta.getName();
        }
        //return MetaListNames.get(id).toString();
        return null;
    }

    private int getMetaIdByName(String name){
        for (MetaListName meta: MetaListNames) {
            if (name.equals(meta.getName())) return meta.getId();
        }
        return -1;
    }

    /*
     * Вернуть все записи (Note) относящиеся к определенной категории, тегу (MetaListName)
     * */
    public ArrayList<MetaListLink> getMetaNotesByName (String metaName){
        //MetaListLink link = new MetaListLink(note_id, MetaListNames.indexOf(name));
        //MetaListLinks.get(id) - идет как объект
        //http://stackoverflow.com/questions/985229/search-in-java-arraylist

        /* Поиск
        * Создается массив объектов ArrayList<MetaListLink> Notes = new ArrayList<MetaListLink>();
        * Проходимся по массиву MetaListLinks
        * Ищем нужное
        * */
        ArrayList<MetaListLink> notes = new ArrayList<MetaListLink>();
        int metaId = getMetaIdByName(metaName);
        if (metaId != -1) {
            for (MetaListLink metaLink : MetaListLinks) {
                if (metaLink.getMetaLink_id() == metaId) notes.add(metaLink);
            }
            return notes;///MetaListLinks.contains(link);
        } else return null;
    }

    /*
    * Вывод всех meta, относящихся к определенному note
    * */
    public ArrayList<String> getNotesMetaById (int noteId){
        ArrayList<String> metas = new ArrayList<String>();
        for (MetaListLink metaLink : MetaListLinks) {
            if (metaLink.getNote_id() == noteId) metas.add(getMetaNameById(metaLink.getMetaLink_id()));
        }
        return metas;
    }

    public void sortMetaListNamesById (){
        Collections.sort(MetaListNames, new Comparator<MetaListName>(){
            //@Override
            public int compare(MetaListName a, MetaListName b) {
                if (a.getId() < b.getId()) return -1;
                else if (a.getId() > b.getId()) return 1;
                return 0;
            }
        });
    }

    public void sortMetaListNamesByName (){
        Collections.sort(MetaListNames, new Comparator<MetaListName>(){
            //@Override
            public int compare(MetaListName a, MetaListName b) {
                return a.getName().compareTo(b.getName());
            }
        });
    }
    public void sortMetaListLinksByNoteId (){
        Collections.sort(MetaListLinks, new Comparator<MetaListLink>(){
            //@Override
            public int compare(MetaListLink a, MetaListLink b) {
                if (a.getNote_id() < b.getNote_id()) return -1;
                else if (a.getNote_id() > b.getNote_id()) return 1;
                return 0;
            }
        });
    }

    public void sortMetaListLinksByMetaLinkId (){
        Collections.sort(MetaListLinks, new Comparator<MetaListLink>(){
            //@Override
            public int compare(MetaListLink a, MetaListLink b) {
                if (a.getMetaLink_id() < b.getMetaLink_id()) return -1;
                else if (a.getMetaLink_id() > b.getMetaLink_id()) return 1;
                return 0;
            }
        });
    }

    /*
    * here will be new function getLinkIdByName ()
    * */
}
