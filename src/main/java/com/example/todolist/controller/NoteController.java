package com.example.todolist.controller;

import com.example.todolist.crudservice.NoteService;
import com.example.todolist.dto.request.NoteAddRequest;
import com.example.todolist.dto.request.NoteUpdateRequest;
import com.example.todolist.dto.response.NoteAddResponse;
import com.example.todolist.dto.response.NoteDeleteResponse;
import com.example.todolist.dto.response.NoteUpdateResponse;
import com.example.todolist.model.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/notes")
public class NoteController {


    private final NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping
    public NoteAddResponse addNote(@RequestBody NoteAddRequest request) {
        Note note = new Note();

        note.setTitle(request.getTitle());
        note.setContent(request.getContent());

        noteService.addNote(note);

        return NoteAddResponse.success(note.getTitle(), note.getContent());

    }

    @GetMapping("/{id}")
    public Optional<Note> getNoteById(@PathVariable int id) {
        return noteService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public NoteDeleteResponse deleteNote(@PathVariable("id") int id) {
        if (noteService.deleteByID(id) == 1) {
            return NoteDeleteResponse.success(id);
        }
        return NoteDeleteResponse.failed(id);
    }

    @PutMapping
    public NoteUpdateResponse updateNode(@RequestBody NoteUpdateRequest request) {
        Note note = new Note();

        note.setContent(request.getContent());
        note.setTitle(request.getTitle());
        note.setId(request.getId());

        noteService.updateNode(note);

        return NoteUpdateResponse.success(note.getTitle(), note.getContent(), note.getId());
    }

}
