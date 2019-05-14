package dev.test.controllers;

import dev.test.models.WebNote;
import dev.test.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NotesController {
    private NoteService noteService;

    @Autowired
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView webNotes(@RequestParam(value = "search_string", required = false) String search_string) {
        List<WebNote> notes;
        if(search_string == null) {
            notes = noteService.allNotes();
        }
        else {
            notes = noteService.filteredNotes(search_string);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notes");
        modelAndView.addObject("noteslist", notes);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addNote(@ModelAttribute("note") WebNote note){
        ModelAndView modelAndView = new ModelAndView();
        if (note.getText() == ""){
            modelAndView.setViewName("noText");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/");
        noteService.add(note);
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView delNote(@ModelAttribute("id") int note_id){
        ModelAndView modelAndView = new ModelAndView();
        WebNote _note = noteService.getById(note_id);
        noteService.delete(_note);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchNote(@ModelAttribute("search_string") String search_string){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

}
