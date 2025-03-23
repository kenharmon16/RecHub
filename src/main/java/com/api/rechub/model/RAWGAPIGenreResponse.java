package com.api.rechub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class RAWGAPIGenreResponse {
    @NonNull
    private long count;
    private Optional<String> next;
    private Optional<String> previous;
    @NonNull
    private List<RAWGGenreResultItem> results;
    private String message;
}
