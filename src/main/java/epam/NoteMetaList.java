package epam;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class NoteMetaList {
    private ArrayList<MetaListName> MetaListNames = new ArrayList<MetaListName>();
    private ArrayList<MetaListLink> MetaListLinks = new ArrayList<MetaListLink>();
    private int nameId, linkId;
    public void addName(String name) {
        MetaListNames.add(new MetaListName(nameId++,name));
    }

    public void addLink(int note_id, String metaName) {
        int metaId = getMetaIdByName(metaName);
        if (metaId != -1) MetaListLinks.add(new MetaListLink(linkId++ ,note_id, metaId));
        else System.out.printf("Can't addLink by %s, because of absense this meta in DataBase",metaName);
    }


    public void setName(int id, String name){
        MetaListName meta= getMetaById(id);
        meta.setName(name);
    }

    public void setLink(int noteId, int metaLink, int new_metaLink){
        getNoteMetaById(noteId,metaLink).setMetaLink_id(new_metaLink);
    }

    public void deleteNameById(int id){
        MetaListNames.remove(getListIdByMetaId(id));
    }
    public void deleteNameByName(String name){
        MetaListNames.remove(getListIdByMetaId(getMetaIdByName(name)));
    }

    public void deleteNoteLink(int noteId, int metaId){
        MetaListNames.remove(getLinkListId(noteId, metaId));
    }

    public int getListIdByMetaId(int id){
        for (int i=0; i < MetaListNames.size()-1; i++){
            if (MetaListNames.get(i).getId() == id) return i;
        }

        return -1;
    }
    public int getListIdByMetaName(String name){
        for (int i=0; i < MetaListNames.size()-1; i++){
            if (MetaListNames.get(i).getName().equals(name)) return i;
        }

        return -1;
    }

    public MetaListName getMetaById(int id){
        for (MetaListName meta: MetaListNames) {
            if (id == meta.getId()) return meta;
        }
        return null;
    }

    public MetaListName getMetaByName(String name){
        for (MetaListName meta: MetaListNames) {
            if (name.equals(meta.getName())) return meta;
        }
        return null;
    }

    public String getMetaNameById(int id){
        //return MetaListNames.get(id).toString();
        return getMetaById(id).getName();
    }

    public int getMetaIdByName(String name){
        return getMetaByName(name).getId();
    }

    /**
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

    /**
    * Вывод всех meta, относящихся к определенному note
    * */
    public ArrayList<String> getNoteMetasById(int noteId){
        ArrayList<String> metas = new ArrayList<String>();
        for (MetaListLink metaLink : MetaListLinks) {
            if (metaLink.getNote_id() == noteId) metas.add(getMetaNameById(metaLink.getMetaLink_id()));
        }
        return metas;
    }

    /**
    * Вывод определенного meta, относящийся к определенному note
    * */
    public MetaListLink getNoteMetaById(int noteId, int metaId){
        for (MetaListLink metaLink : MetaListLinks) {
            if (metaLink.getNote_id() == noteId && metaLink.getMetaLink_id() == metaId) return metaLink;
        }
        return null;
    }

    /**
    * Вывод индекса ссылки (link)
     */
    public int getLinkListId(int noteId, int metaId){
        for (int i=0; i < MetaListLinks.size()-1; i++){
            if (MetaListLinks.get(i).getNote_id() == noteId && MetaListLinks.get(i).getMetaLink_id() == metaId) return i;
        }

        return -1;
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
