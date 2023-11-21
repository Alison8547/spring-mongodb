package com.br.springmongodb.controller;

import com.br.springmongodb.dto.request.StudentRequest;
import com.br.springmongodb.dto.response.StudentResponse;
import com.br.springmongodb.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping
public class StudentController {

    private final StudentService studentService;


    @PostMapping("/create-student")
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(studentService.createStudent(studentRequest), HttpStatus.CREATED);
    }

    @GetMapping("/list-age-lt")
    public ResponseEntity<List<StudentResponse>> listStudentsLtAge(@RequestParam Integer age) {
        return new ResponseEntity<>(studentService.listStudentsLtAge(age), HttpStatus.OK);
    }
}
