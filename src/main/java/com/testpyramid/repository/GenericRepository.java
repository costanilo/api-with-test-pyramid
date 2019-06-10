package com.testpyramid.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class GenericRepository {
    @Autowired
    private RestTemplate restTemplate;

    public GenericResponse getDataFromExternalApi(Integer genericParam){
        String endpoint = String.join("/", "http://localhost:8889/generic-external-api", genericParam.toString());
        ResponseEntity<GenericResponse> response = restTemplate.exchange(endpoint, HttpMethod.GET, null, GenericResponse.class);

        return response.getBody();
    }
}
