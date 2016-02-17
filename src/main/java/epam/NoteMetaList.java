package epam;


import java.util.ArrayList;

abstract class NoteMetaList {
    private ArrayList<MetaListName> MetaListNames = new ArrayList<MetaListName>();
    private ArrayList<MetaListLink> MetaListLinks = new ArrayList<MetaListLink>();
    private int nameId, linkId;
    public void setName(String name) {
        MetaListNames.add(new MetaListName(nameId++,name));
    }

    public void setLink(int note_id, String metaName) {
        MetaListLinks.add(new MetaListLink(linkId++ ,note_id, MetaListNames.indexOf(metaName)));
    }

    public String getNameById (int id){
        for (MetaListName note: MetaListNames) {
            if (id == note.getId()) return note.getName();
        }
        //return MetaListNames.get(id).toString();
        return null;
    }

    /*
     * Вернуть все записи (Note) относящиеся к определенной категории, тегу (MetaListName)
     * */
    public ArrayList<MetaListLink> getMetaNotesByName (String name){
        //MetaListLink link = new MetaListLink(note_id, MetaListNames.indexOf(name));
        //MetaListLinks.get(id) - идет как объект
        //http://stackoverflow.com/questions/985229/search-in-java-arraylist

        /* Поиск
        * Создается массив объектов ArrayList<MetaListLink> Notes = new ArrayList<MetaListLink>();
        * Проходимся по массиву MetaListLinks
        * Ищем нужное
        * */
        ArrayList<MetaListLink> Notes = new ArrayList<MetaListLink>();
        int id = MetaListNames.indexOf(name);
        for (MetaListLink a:MetaListLinks) {
            if (a.getMetaLink_id() == id) Notes.add(a);
        }
        return  Notes;///MetaListLinks.contains(link);
    }

    /*
    * here will be new function getLinkIdByName ()
    * */
}
