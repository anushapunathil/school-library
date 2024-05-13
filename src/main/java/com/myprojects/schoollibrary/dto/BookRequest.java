package com.myprojects.schoollibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private Long id;
    private String title;
    private String author;
    private String ISBN;
    private String genre;
    private LocalDateTime publicationDate;
    private boolean available;
}
