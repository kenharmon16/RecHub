package com.api.rechub.rest;

import com.api.rechub.model.RAWGAPIGenreResponse;
import com.api.rechub.service.RAWGAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/")
public class RAWGAPIController {

    private final RAWGAPIService rawgService;

    @Autowired
    public RAWGAPIController(RAWGAPIService rawgService) {
        this.rawgService = rawgService;
    }

    @GetMapping("/genres")
    public ResponseEntity<RAWGAPIGenreResponse> getRAWGAPIGenres() {
        return rawgService.getRAWGAPIGenres();
    }
}
