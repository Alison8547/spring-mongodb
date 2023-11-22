package com.br.springmongodb.repository;

import com.br.springmongodb.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    @Query("{ age: {$lt: ?0}}")
    List<Student> findListStudentsLtAge(Integer age);

    // regex sensitive case
    @Query("{'school.name' : { $regex: ?0, $options: 'i'}}")
    List<Student> findStudentsSchoolName(String schoolName);

    @Query("{ 'created': { $gte: ?0, $lte: ?1} }")
    List<Student> findCreatedDates(Date from,Date to);
}
