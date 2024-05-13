package com.br.springmongodb.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Document(collection = "school")
public class School {

    @Id
    private String id;
    private String code;
    private String nameSchool;
    private List<Student> students = new ArrayList<>();
    private LocalDateTime created;

}
