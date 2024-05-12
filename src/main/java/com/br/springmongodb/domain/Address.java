package com.br.springmongodb.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Address {

    private String street;
    private String city;
    private String state;
    private String zip;

}
