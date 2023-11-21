package com.br.springmongodb.repository;

import com.br.springmongodb.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    @Query("{ age: {$lt: ?0}}")
    List<Student> findListStudentsLtAge(Integer age);
}
