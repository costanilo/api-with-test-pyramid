package com.testpyramid.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GenericRepositoryTest {

    @InjectMocks
    private GenericRepository repository;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void shouldGetFilledModel() {
        GenericResponse mock = new GenericResponse();
        mock.setMessage("SIMPLE MESSAGE EXAMPLE!");

        //Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.any(HttpMethod.class), Mockito.any(), Mockito.any(Integer.class))).thenReturn(mock);
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                eq(null),
                eq(GenericResponse.class)
        )).thenReturn(new ResponseEntity<>(mock, HttpStatus.OK));

        GenericResponse response = repository.getDataFromExternalApi(1);

        assertEquals( "SIMPLE MESSAGE EXAMPLE!", response.getMessage());
    }
}
