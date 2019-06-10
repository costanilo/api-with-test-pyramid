package com.testpyramid.controller;

import com.testpyramid.model.GenericModel;
import com.testpyramid.service.GenericService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/generic-api")
@Validated
@Slf4j
public class GenericController {

    @Autowired
    private GenericService service;

    @GetMapping(value = "/action/{genericVariable}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<GenericModel> genericAction(@PathVariable("genericVariable") int genericParam) {
        log.trace("some trace");
        return ResponseEntity.ok(service.genericMethod(genericParam));
    }
}
