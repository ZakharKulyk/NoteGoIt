package com.example.todolist;


import com.example.todolist.crudservice.NoteService;
import com.example.todolist.model.Note;
import com.example.todolist.repository.NoteRepository;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NoteServiceTest {
    @Mock
    NoteRepository noteRepository;

    @InjectMocks
    NoteService noteService;



    @Test
    public void NoteTest() {
        Note note = new Note();
        note.setContent("test Content");
        note.setTitle("test Title");

        when(noteRepository.save(any(Note.class))).thenReturn(note);

        Note result = noteService.addNote(note);

        Assertions.assertNotNull(result);

        Assertions.assertEquals(note.getContent(), result.getContent());
        Assertions.assertEquals(note.getTitle(), result.getTitle());

        verify(noteRepository, times(1)).save(any(Note.class));

    }

}
