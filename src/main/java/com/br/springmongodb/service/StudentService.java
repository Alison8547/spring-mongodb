package com.br.springmongodb.service;

import com.br.springmongodb.domain.Responsible;
import com.br.springmongodb.domain.Smaller;
import com.br.springmongodb.domain.Student;
import com.br.springmongodb.dto.request.StudentRequest;
import com.br.springmongodb.dto.response.StudentResponse;
import com.br.springmongodb.exception.BusinessException;
import com.br.springmongodb.mapper.StudentMapper;
import com.br.springmongodb.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ResponsibleService responsibleService;
    private final SchoolService schoolService;
    private final StudentMapper mapper;


    public StudentResponse createStudent(StudentRequest studentRequest) {
        Student student = mapper.toStudentDomain(studentRequest);
        student.setCreated(LocalDateTime.now());
        student.setSchool(schoolService.findSchool("1").getNameSchool());

        studentRepository.insert(student);
        log.info("created student: {}", student);

        for (Responsible responsible : studentRequest.getResponsibles()) {
            responsible.setSmaller(new Smaller(findStudent(student.getId()).getId(), studentRequest.getName()));
            responsibleService.createResponsible(responsible);
        }

        schoolService.addStudentSchool(student);
        studentRepository.save(student);

        return mapper.toStudentResponse(student);
    }


    public Student findStudent(String id) {
        return studentRepository.findById(id).orElseThrow(() -> new BusinessException("Student not found"));
    }

    public List<StudentResponse> listStudentsLtAge(Integer age) {
        return studentRepository.findListStudentsLtAge(age).stream()
                .map(mapper::toStudentResponse)
                .toList();
    }

    public List<StudentResponse> listStudentsSchoolName(String schoolName) {
        return studentRepository.findStudentsSchoolName(schoolName).stream()
                .map(mapper::toStudentResponse)
                .toList();
    }

    public List<StudentResponse> listCreatedDates(Date from, Date to) {
        return studentRepository.findCreatedDates(from, to).stream()
                .map(mapper::toStudentResponse)
                .toList();
    }

    public List<StudentResponse> listStudentsGtDate(Date date) {
        return studentRepository.findStudentsGtDate(date).stream()
                .map(mapper::toStudentResponse)
                .toList();
    }
}
