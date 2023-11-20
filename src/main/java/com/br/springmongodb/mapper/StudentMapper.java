package com.br.springmongodb.mapper;

import com.br.springmongodb.domain.Student;
import com.br.springmongodb.dto.request.StudentRequest;
import com.br.springmongodb.dto.response.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final ModelMapper mapper;

    public Student toStudentDomain(StudentRequest studentRequest) {
        return mapper.map(studentRequest, Student.class);
    }

    public StudentResponse toStudentResponse(Student student) {
        return mapper.map(student, StudentResponse.class);
    }
}
