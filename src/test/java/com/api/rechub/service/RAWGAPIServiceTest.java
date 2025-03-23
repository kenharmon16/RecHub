package com.api.rechub.service;

import com.api.rechub.model.RAWGAPIGenreResponse;
import com.api.rechub.model.RAWGGenreResultItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@Tag("UnitTest")
@ExtendWith(MockitoExtension.class)
public class RAWGAPIServiceTest {

    @InjectMocks
    private RAWGAPIService rawgAPIService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        ReflectionTestUtils.setField(rawgAPIService, "rawgBaseUrl", "https://abc.io/api/");
        ReflectionTestUtils.setField(rawgAPIService, "rawgGenresEndpoint", "genres");
        ReflectionTestUtils.setField(rawgAPIService, "apiKey", "1234567890");
    }

    @Test
    public void testGetRAWGAPIGenres_Success() {
        RAWGAPIGenreResponse mockResponse = new RAWGAPIGenreResponse();
        mockResponse.setMessage("Successfully fetched genres");
        mockResponse.setCount(19);
        List<RAWGGenreResultItem> results = new ArrayList<>();
        RAWGGenreResultItem genre1 = new RAWGGenreResultItem();
        genre1.setId(1);
        genre1.setName("Action");
        results.add(genre1);
        mockResponse.setResults(results);

        when(restTemplate.getForEntity(anyString(), eq(RAWGAPIGenreResponse.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        ResponseEntity<RAWGAPIGenreResponse> response = rawgAPIService.getRAWGAPIGenres();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Successfully fetched genres", Objects.requireNonNull(response.getBody()).getMessage());
        assertEquals(19, response.getBody().getCount());
        assertEquals(1, response.getBody().getResults().size());
        assertEquals("Action", response.getBody().getResults().get(0).getName());
    }

    @Test
    public void testGetRAWGAPIGenres_Failure() {
        when(restTemplate.getForEntity(anyString(), eq(RAWGAPIGenreResponse.class)))
                .thenThrow(new RuntimeException("Service Unavailable"));

        ResponseEntity<RAWGAPIGenreResponse> response = rawgAPIService.getRAWGAPIGenres();

        assertEquals(HttpStatus.SERVICE_UNAVAILABLE, response.getStatusCode());
        assertEquals("RAWGGenreAPI service is currently unavailable now", Objects.requireNonNull(response.getBody()).getMessage());
    }
}
