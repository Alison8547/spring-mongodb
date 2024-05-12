package com.br.springmongodb.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Document(collection = "responsible")
public class Responsible {

    @Id
    private String id;
    private String name;
    private Integer age;
    private Address address;
    private LocalDateTime created;

}
