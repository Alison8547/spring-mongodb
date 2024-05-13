package com.br.springmongodb.service;

import com.br.springmongodb.domain.School;
import com.br.springmongodb.domain.Student;
import com.br.springmongodb.exception.BusinessException;
import com.br.springmongodb.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class SchoolService {

    private final SchoolRepository schoolRepository;


    public School findSchool(String code) {
        return schoolRepository.findByCode(code).orElseThrow(() -> new BusinessException("school not found"));
    }

    public void addStudentSchool(Student student){
        School school = findSchool("1");
        school.getStudents().add(student);
        schoolRepository.save(school);
    }


}
