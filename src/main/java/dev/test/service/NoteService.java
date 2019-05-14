package dev.test.service;

import dev.test.models.WebNote;

import java.util.List;

public interface NoteService {
    List<WebNote> allNotes();
    List<WebNote> filteredNotes(String filter_string);
    void add(WebNote note);
    void delete(WebNote note);
    WebNote getById(int id);

}
