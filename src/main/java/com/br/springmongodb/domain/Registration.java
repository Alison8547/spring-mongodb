package com.br.springmongodb.domain;

import com.br.springmongodb.enums.StatusRegistration;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Document(collection = "registration")
public class Registration {

    @Id
    private String id;
    private Student student;
    private School school;
    private StatusRegistration statusRegistration;
    private LocalDateTime createdRegistration;


}
