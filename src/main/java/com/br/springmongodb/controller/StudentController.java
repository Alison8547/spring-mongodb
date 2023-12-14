package com.br.springmongodb.controller;

import com.br.springmongodb.dto.request.StudentRequest;
import com.br.springmongodb.dto.response.StudentResponse;
import com.br.springmongodb.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping("/list-students-school-name")
    public ResponseEntity<List<StudentResponse>> listStudentsSchoolName(@RequestParam String schoolName) {
        return new ResponseEntity<>(studentService.listStudentsSchoolName(schoolName), HttpStatus.OK);
    }

    @GetMapping("/list-created-dates")
    public ResponseEntity<List<StudentResponse>> listCreatedStudentsDates(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
                                                                          @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
        return new ResponseEntity<>(studentService.listCreatedDates(from, to), HttpStatus.OK);
    }

    @GetMapping("/list-gt-date")
    public ResponseEntity<List<StudentResponse>> listStudentsGtDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date value) {
        return new ResponseEntity<>(studentService.listStudentsGtDate(value), HttpStatus.OK);
    }
}
