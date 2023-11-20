package com.br.springmongodb.controller;

import com.br.springmongodb.dto.request.StudentRequest;
import com.br.springmongodb.dto.response.StudentResponse;
import com.br.springmongodb.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping
public class StudentController {

    private final StudentService studentService;


    @PostMapping("create-student")
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(studentService.createStudent(studentRequest), HttpStatus.CREATED);
    }
}
