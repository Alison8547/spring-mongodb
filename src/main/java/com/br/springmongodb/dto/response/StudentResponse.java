package com.br.springmongodb.dto.response;

import com.br.springmongodb.domain.Responsible;
import com.br.springmongodb.enums.Gender;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {

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
