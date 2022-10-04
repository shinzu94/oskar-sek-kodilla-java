package com.kodilla.hibernate.manytomany.facade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class EmployeeDto {
    private final int id;
    private final String firstname;
    private final String lastname;
}