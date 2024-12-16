package com.example.todolist.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NoteDeleteResponse {
    private int id;
    private Status status;

    private enum Status{
        Deleted,
        FailedTODelete
    }

    public static NoteDeleteResponse success(int id){
        return NoteDeleteResponse.builder().id(id).status(Status.Deleted).build();
    }

    public static NoteDeleteResponse failed(int id){
        return NoteDeleteResponse.builder().id(id).status(Status.FailedTODelete).build();
    }

}
