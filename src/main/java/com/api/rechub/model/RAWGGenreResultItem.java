package com.api.rechub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RAWGGenreResultItem {
    private int id;
    @NonNull
    private String name;
    private String slug;
    private int games_count;
    private String image_background;
    private List<RAWGGame> games;
}
