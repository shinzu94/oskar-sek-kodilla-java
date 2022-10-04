package com.kodilla.hibernate.manytomany.facade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;


@Value
@Builder
@AllArgsConstructor
public class CompanyDto {
    private final int id;
    private final String name;
}