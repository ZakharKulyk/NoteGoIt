package com.example.todolist.controller;

import com.example.todolist.crudservice.NoteService;
import com.example.todolist.model.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/note")
public class NoteController {

    private  final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getAllNotes() {
        ModelAndView modelAndView = new ModelAndView("listall");
        modelAndView.addObject("notes", noteService.getAllNotes());
        return modelAndView;
    }


    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") int id) {
        noteService.deleteByID(id);
        return "redirect:/note/list";
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdateUI(@PathVariable("id")int id){
        ModelAndView modelAndView = new ModelAndView("updateform");
        modelAndView.addObject("note", noteService.getById(id));

        return  modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String processChanges(@PathVariable("id") long id, @ModelAttribute(name = "note") Note newNote){
        noteService.updateNode(newNote);
        return "redirect:/note/update/"+id;
    }

    @GetMapping("/addNewNotation")
    public  ModelAndView getAddNewNotationUI(){
            return new ModelAndView("addnewnote");
    }

    @PostMapping("/addNewNotation/save")
    public  String processAdditionOfNote( String title,  String content){
        Note note = new Note();

        note.setContent(content);
        note.setTitle(title);

        noteService.addNote(note);

        return "redirect:/note/list";

    }

}
