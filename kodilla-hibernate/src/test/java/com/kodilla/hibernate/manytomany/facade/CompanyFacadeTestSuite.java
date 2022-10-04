package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CompanyFacadeTestSuite {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyFacade companyFacade;
    private List<Company> companies;
    private List<Employee> employees;

    @BeforeEach
    private void beforeEach() {
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieSmith = new Employee("Stephanie", "Smith");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company dataMatter = new Company("Data Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieSmith);
        dataMaesters.getEmployees().add(lindaKovalsky);
        dataMatter.getEmployees().add(johnSmith);
        dataMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(dataMatter);
        stephanieSmith.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMatter);

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(dataMatter);
        companies = List.of(softwareMachine, dataMaesters, dataMatter);
        employees = List.of(johnSmith, stephanieSmith, lindaKovalsky);
    }

    @AfterEach
    private void afterEach() {
        companyDao.deleteAll(companies);
        employeeDao.deleteAllById(employees.stream().map(Employee::getId).collect(Collectors.toList()));
    }

    @Test
    public void testFindingEmployeeByPartialName() {
        //Given

        //When
        List employees = companyFacade.findEmployeeByPartialName("mit");

        //Then
        assertEquals(2, employees.size());
    }

    @Test
    public void testFindingCompanyByPartialName() {
        //Given

        //When
        List employees = companyFacade.findCompanyByPartialName("ata M");

        //Then
        assertEquals(2, employees.size());
    }
}