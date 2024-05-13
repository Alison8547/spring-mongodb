package com.br.springmongodb.dto.request;

import com.br.springmongodb.domain.Responsible;
import com.br.springmongodb.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequest {


    @NotBlank
    private String name;

    @NotNull
    private Integer age;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private Gender gender;

    private List<Responsible> responsibles;

    private List<String> hobbies;

}
