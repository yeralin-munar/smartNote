package epam;

class MetaListLink {
    private int id, note_id, metaLink_id;

    MetaListLink(int id, int note_id, int metaLink_id) {
        this.id = id;
        this.note_id = note_id;
        this.metaLink_id = metaLink_id;
    }

    public int getId() {
        return id;
    }

    int getMetaLink_id() {
        return metaLink_id;
    }

    public int getNote_id() {
        return note_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMetaLink_id(int metaLink_id) {
        this.metaLink_id = metaLink_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }
}
