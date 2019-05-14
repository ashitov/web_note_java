package dev.test.service;

import dev.test.models.WebNote;
import dev.test.dao.NoteDao;
import dev.test.dao.NoteDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    //private NoteDao noteDao = new NoteDaoImpl();

    private NoteDao noteDao;

    @Autowired
    public void setNoteDao(NoteDao noteDao){
        this.noteDao = noteDao;
    }

    @Override
    @Transactional
    public List<WebNote> allNotes() {
        return noteDao.allNotes();
    }

    @Override
    @Transactional
    public List<WebNote> filteredNotes(String filter_string) {
        return noteDao.filteredNotes(filter_string);
    }

    @Override
    @Transactional
    public void add(WebNote note) {
        noteDao.add(note);
    }

    @Override
    @Transactional
    public void delete(WebNote note) {
        noteDao.delete(note);
    }

    @Override
    @Transactional
    public WebNote getById(int id) {
        return noteDao.getById(id);
    }
}
