package com.example.todolist.services;

import com.example.todolist.entity.Note;
import com.example.todolist.exceptions.NoSuchNodeFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class NoteService {
    private List<Note> db = new ArrayList<>();


    public List<Note> listAll() {
        return db;
    }

    public Note addNote(Note note) {
        note.setId(new Random().nextInt());
        db.add(note);
        return note;
    }

    public void deleteById(long id) {
        Note note = null;
        try {
            for (int i = 0; i < listAll().size(); i++) {
                Note loopNode = listAll().get(i);
                if (loopNode.getId()==id){
                    note = loopNode;
                }
            }
            if (note==null){
                throw  new NoSuchNodeFound("no node with such id");
            }
            listAll().remove(note);
            System.out.println("note was removed");
        } catch (Exception e) {
            System.out.println("No such id found to be deleted");
        }
    }

    public  void update(Note note){
        try {
            Note oldNote = note;
            for (int i = 0; i < listAll().size(); i++) {
                Note loopNote = listAll().get(i);
                if (loopNote.getId()== note.getId()){
                    oldNote = loopNote;
                    break;
                }
            }
            if (oldNote==null){
                throw new NoSuchNodeFound("no such id");
            }
            oldNote.setTitle(note.getTitle());
            oldNote.setContent(note.getContent());
            System.out.println("note was updated");
        }catch (Exception ex){
            System.out.println("no such id to be updated");
        }
    }

    public Note getById(long id){
        try {

            List<Note> collect = listAll().stream()
                    .filter(note -> note.getId() == id)
                    .collect(Collectors.toList());
            if (collect.size()==0){
                throw new NoSuchNodeFound("no such id");
            }
            return  collect.get(0);
        }catch (Exception ex){
            System.out.println("no such id to get");
            return  null;
        }
    }

//    public static void main(String[] args) {
//        NoteService noteService = new NoteService();
//
//        Note note = new Note();
//        note.setTitle("test");
//        note.setContent("test");
//        note.setId(1);
//
//        Note note1 = new Note();
//        note1.setId(1);
//        note1.setContent("updated");
//        note1.setTitle("updated");
//
//        noteService.db.add(note);
//
//        System.out.println(noteService.getById(2));
//    }

}
