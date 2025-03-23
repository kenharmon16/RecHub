package com.api.rechub.service;

import com.api.rechub.model.RAWGAPIGenreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RAWGAPIService {

    private final RestTemplate restTemplate;

    @Value("${rawg.url}")
    private String rawgBaseUrl;

    @Value("${rawg.endpoints.genres}")
    private String rawgGenresEndpoint;

    @Value("${rawg.apiKey}")
    private String apiKey;

    @Autowired
    public RAWGAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<RAWGAPIGenreResponse> getRAWGAPIGenres() {
        ResponseEntity<RAWGAPIGenreResponse> response;

        String rawgUrl = String.format(rawgBaseUrl.concat(rawgGenresEndpoint).concat("?key=%s"), apiKey);

        try {
            response = restTemplate.getForEntity(rawgUrl, RAWGAPIGenreResponse.class);
            RAWGAPIGenreResponse responseBody = response.getBody();
            if (responseBody != null) {
                responseBody.setMessage("Successfully fetched genres");
            }
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            RAWGAPIGenreResponse failureResponse = new RAWGAPIGenreResponse();
            failureResponse.setMessage("RAWGGenreAPI service is currently unavailable now");
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(failureResponse);
        }
    }
}
