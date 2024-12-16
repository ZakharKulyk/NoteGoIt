package com.example.todolist.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteUpdateRequest {
    int id;
    String title;
    String content;
}
