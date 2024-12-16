package com.example.todolist.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NoteUpdateResponse {
    private int id;
    private String title;
    private String content;

    Status status;

    private enum Status {
        Updated,
        FailedToUpdate
    }

    public static NoteUpdateResponse success(String title, String content, int id) {
        return NoteUpdateResponse.builder().title(title).id(id).status(Status.Updated).content(content).build();
    }

    public static NoteUpdateResponse failed(String title, String content, int id) {
        return NoteUpdateResponse.builder().title(title).id(id).status(Status.FailedToUpdate).content(content).build();
    }
}
