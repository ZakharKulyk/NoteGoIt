package com.example.todolist.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteAddRequest {
    String title;
    String content;

}
