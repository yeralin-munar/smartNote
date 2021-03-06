package com.epam.fabric;

import com.epam.entity.Category;
import com.epam.entity.Note;
import com.epam.entity.Tag;
import com.epam.service.NoteService;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Munar on 22.02.2016.
 */
public class NoteFabric {
    private String[] categories = {"История", "Мифы", "Мысли", "Музыка", "Фильмы", "Книги", "Новости"};
    private String[] tags = {"мое", "мысли в слух", "случай из жизни", "про работу"};
    private String[] titles ={"Учёные создали золотой алюминий и синее серебро",
                    "Открыта гигантская дьявольская лягушка", "В Японии построили измеритель смеха",
                    "Древняя змея показала скрытую ногу"};
    private String[] contents = {"Эта благая весть из Америки открывает захватывающие перспективы: фиолетовый в крапинку фонарный столб, переливающиеся радугой трамвайные рельсы и вообще – любая железяка любого цвета. Понятие «цветные металлы» эволюционирует, и это прекрасно.",
                    "К счастью для потенциальной добычи и неудовольствию биологов, «исчадие ада» не дотянуло до наших дней. Это и есть повод для хорошего настроения. А для жёлтого издания готово заглавие похлеще: «Гигантский дьявол поверг учёных в шок!»",
                    "И теперь ясно, с какой силой и уровнем веселятся тамошние граждане. Скажем, чтобы отсмеяться на твёрдую пятёрку, нужно искренне надорвать живот лишь на одну секунду. И помочь в этом может открытие, сделанное в Канаде: Учёные нашли простой рецепт счастья. Смешно, правда?",
                    "Ждать презентации бесполезной конечности нам пришлось 92 миллиона лет, однако дальнейшее терпеливое ожидание нам таких мощных открытий в змеином стане не сулит. Похоже, они показали всё, что скрыто. И, кстати, какой заголовок пропадает: «Одноногая змея повергла учёных в шок!»"};
    //private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd'T'HH:mm:ss");
    DateTime[] dates = {new DateTime("1999-9-10T10:01:20"),
                        new DateTime("2000-8-25T12:22:58"),
                        new DateTime("2002-2-13T13:01:50"),
                        new DateTime("2001-4-15T20:21:20"),
                        new DateTime("2010-10-5T23:01:20")};
    NoteService noteService = new NoteService();
    private List<Tag> listTags = new ArrayList<>();
    private List<Category> listCategories = new ArrayList<>();
    private List<Note> notes = new ArrayList<>();
    private int tagId;
    private int categoryId;
    private int noteId;

    public void create(){
        for (String cat:categories){
            listCategories.add(new Category(categoryId++,cat));
        }
        for (String tag:tags){
            listTags.add(new Tag(tagId++,tag));;
        }

        for (int i = 0; i < Math.min(titles.length,contents.length); i++) {
            notes.add(new Note(noteId++,titles[i], contents[i], categories[i], tags[i], dates[i]));
        }
    }
    public void print(){
        List<Note> newNotes = noteService.sortNotesByDate(notes);
        for (Note note: newNotes){
            note.printNote();
        }
    }

    public void printNotesRelToCat(){

        List<Note> newNotes = noteService.getCategoryNotes(notes, categories[1]);
        for (Note note: newNotes){
            note.printNote();
        }
    }
}
