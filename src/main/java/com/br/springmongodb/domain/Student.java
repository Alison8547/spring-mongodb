package com.br.springmongodb.domain;

import com.br.springmongodb.enums.Gender;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Document(collection = "students")
public class Student {

    @Id
    private String id;
    private String name;
    private Integer age;
    private String email;
    private Gender gender;
    private List<Responsible> responsibles;
    private List<String> hobbies;
    private String school;
    private LocalDateTime created;
}
