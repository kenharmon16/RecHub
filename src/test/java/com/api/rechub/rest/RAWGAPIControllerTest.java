package com.api.rechub.rest;

import com.api.rechub.model.RAWGAPIGenreResponse;
import com.api.rechub.service.RAWGAPIService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Tag("UnitTest")
@ExtendWith(MockitoExtension.class)
public class RAWGAPIControllerTest {

    @Mock
    private RAWGAPIService rawgAPIService;

    @InjectMocks
    private RAWGAPIController rawgAPIController;

    @Test
    public void testGetRAWGAPIGenresController() {
        RAWGAPIGenreResponse mockResponse = new RAWGAPIGenreResponse();
        mockResponse.setMessage("Successfully fetched genres");
        ResponseEntity<RAWGAPIGenreResponse> responseEntity = new ResponseEntity<>(mockResponse, HttpStatus.OK);

        when(rawgAPIService.getRAWGAPIGenres()).thenReturn(responseEntity);

        ResponseEntity<RAWGAPIGenreResponse> response = rawgAPIController.getRAWGAPIGenres();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Successfully fetched genres", response.getBody().getMessage());
    }
}
