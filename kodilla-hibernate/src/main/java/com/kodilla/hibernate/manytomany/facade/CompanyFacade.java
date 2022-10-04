package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyFacade {
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    public List<CompanyDto> findCompanyByPartialName(String name) {
        return companyDao.findByName("%" + name + "%").stream()
                .map(entity -> this.companyToDto(entity))
                .collect(Collectors.toList());
    }

    public List<EmployeeDto> findEmployeeByPartialName(String name) {
        return employeeDao.findByName("%" + name + "%").stream()
                .map(entity -> this.employeeToDto(entity))
                .collect(Collectors.toList());
    }

    private CompanyDto companyToDto(Company company) {
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .build();
    }

    private EmployeeDto employeeToDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstname(employee.getFirstname())
                .lastname(employee.getLastname())
                .build();
    }
}
