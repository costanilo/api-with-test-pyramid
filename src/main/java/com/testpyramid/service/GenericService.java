package com.testpyramid.service;

import com.testpyramid.model.GenericModel;
import com.testpyramid.repository.GenericRepository;
import com.testpyramid.repository.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericService {
    @Autowired
    private GenericRepository repository;

    public GenericModel genericMethod(int genericParam) {
        GenericModel model = new GenericModel();
        GenericResponse response = repository.getDataFromExternalApi(genericParam);
        model.setGenericProperty(response.getMessage());
        return model;
    }
}
