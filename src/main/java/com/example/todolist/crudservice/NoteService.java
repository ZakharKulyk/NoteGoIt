package com.example.todolist.crudservice;

import com.example.todolist.exception.NoSuchNodeFound;
import com.example.todolist.model.Note;
import com.example.todolist.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;


    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }


    public Optional<Note> getById(int id) {
        try {
            return Optional.of(noteRepository.findById(id).orElseThrow(() -> new NoSuchNodeFound("There is no such node")));
        } catch (NoSuchNodeFound e) {
            throw new RuntimeException(e);
        }
    }

    public Note addNote(Note note) {
        note.setId(new Random().nextInt(500));
        noteRepository.save(note);
        return note;
    }

    public void deleteByID(int id) {
        noteRepository.deleteById(id);
    }

    public void updateNode(Note note) {
        try {
            Note note1 = noteRepository.findById(note.getId())
                    .orElseThrow(() -> new NoSuchNodeFound("There is no such node" + note.getId()));

            note1.setContent(note.getContent());
            note1.setTitle(note.getTitle());

            noteRepository.save(note1);
        } catch (NoSuchNodeFound e) {
            throw new RuntimeException(e);
        }
    }

}
