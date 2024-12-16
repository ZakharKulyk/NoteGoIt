package com.example.todolist.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteAddResponse {
    private String title;
    private String content;
    private Status status;

    private enum Status {
        Added,
        FailedToAdd
    }

    public static NoteAddResponse success(String title, String content) {
        return NoteAddResponse.builder().title(title).content(content).status(Status.Added).build();
    }

    public static NoteAddResponse failed(String title, String content) {
        return NoteAddResponse.builder().title(title).content(content).status(Status.FailedToAdd).build();
    }
}
